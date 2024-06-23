"use client";
import cx from "clsx";
import React from "react";
import {
  Container,
  Avatar,
  UnstyledButton,
  Group,
  Text,
  Menu,
  Tabs,
  Burger,
  rem,
  useMantineTheme,
  Flex,
  Anchor,
  Center,
  Alert,
  Image,
  AspectRatio,
} from "@mantine/core";
import { useDisclosure } from "@mantine/hooks";
import {
  IconLogout,
  IconHeart,
  IconStar,
  IconMessage,
  IconSettings,
  IconChevronDown,
  IconInfoCircle,
} from "@tabler/icons-react";
import NextImage, { type StaticImageData } from "next/image";
import ValleyLogo from "@public/valley_logo.png";

import classes from "../_styles/HeaderTabs.module.css";
import { redirect, usePathname, useRouter } from "next/navigation";

import { signOut, useSession } from "next-auth/react";
import { getBaseUrl } from "~/trpc/shared";
import { Link } from "~/navigation";
import { useLocale } from "next-intl";

const tabs = [
  { name: "Home", link: "" },
  { name: "Creators", link: "creators" },
];

export function HeaderTabs() {
  const theme = useMantineTheme();
  const [opened, { toggle }] = useDisclosure(false);
  const [userMenuOpened, setUserMenuOpened] = React.useState(false);
  const router = useRouter();
  const pathname = usePathname();

  const currentTabFromPath = pathname.split("/");

  const getCurrentTab = () => {
    let tab = "Home";
    if (currentTabFromPath.length > 2) {
      tab =
        currentTabFromPath[2]!.charAt(0).toUpperCase() +
        currentTabFromPath[2]!.slice(1);
    }
    return tab;
  };

  const session = useSession();
  const locale = useLocale();
  const [currentTab, setCurrentTab] = React.useState(getCurrentTab());

  const items = tabs.map((tab) => (
    <Link
      key={tab.link}
      onClick={() => changeTab(tab.link)}
      href={"/" + tab.link.toLowerCase()}
      style={{ textDecoration: "none" }}
    >
      <Tabs.Tab value={tab.name}>{tab.name}</Tabs.Tab>
    </Link>
  ));

  const changeTab = React.useCallback(
    (tab: string) => {
      router.push("/" + tab.toLowerCase());

      setCurrentTab(tab);
    },
    [router],
  );

  const icon = <IconInfoCircle />;

  return (
    <div className={classes.header}>
      <Flex>
        <Container ml="1rem" mr={0} h={"auto"} w={"auto"}>
          <Image
            h={"auto"}
            w={"250"}
            component={NextImage}
            src={ValleyLogo}
            alt="Valley-logo"
          />
        </Container>
        <Container ml={0}>
          <Alert
            variant="light"
            color="yellow"
            title="You are using an alpha version of Valley"
            icon={icon}
          ></Alert>
        </Container>
      </Flex>
      <Flex>
        <Center>
          <Container size="md" ml={"xs"}>
            <Tabs
              defaultValue={currentTab}
              variant="outline"
              visibleFrom="sm"
              classNames={{
                root: classes.tabs,
                list: classes.tabsList,
                tab: classes.tab,
              }}
            >
              <Tabs.List>{items}</Tabs.List>
            </Tabs>
          </Container>
        </Center>

        <Container className={classes.mainSection} ml="auto" mr="0">
          <Group justify="space-between">
            <Burger
              opened={opened}
              onClick={toggle}
              hiddenFrom="xs"
              size="sm"
            />

            <Menu
              width={260}
              position="bottom-end"
              transitionProps={{ transition: "pop-top-right" }}
              onClose={() => setUserMenuOpened(false)}
              onOpen={() => setUserMenuOpened(true)}
              withinPortal
            >
              <Menu.Target>
                <UnstyledButton
                  className={cx(classes.user, {
                    //@ts-expect-error because this is annoying
                    [classes.userActive]: userMenuOpened,
                  })}
                >
                  <Group gap={7}>
                    <Avatar
                      src={session.data?.user.image}
                      alt={"user-logo"}
                      radius="xl"
                      size={"md"}
                    />
                    <Text fw={500} size="sm" lh={1} mr={3}>
                      {session.data?.user.name}
                    </Text>
                    <IconChevronDown
                      style={{ width: rem(12), height: rem(12) }}
                      stroke={1.5}
                    />
                  </Group>
                </UnstyledButton>
              </Menu.Target>

              <Menu.Dropdown>
                <Link href={"/applications"} style={{ textDecoration: "none" }}>
                  <Menu.Item
                    leftSection={
                      <IconStar
                        style={{ width: rem(16), height: rem(16) }}
                        color={theme.colors.yellow[6]}
                        stroke={1.5}
                      />
                    }
                  >
                    Your Applications
                  </Menu.Item>
                </Link>
                <Menu.Item
                  leftSection={
                    <IconMessage
                      style={{ width: rem(16), height: rem(16) }}
                      color={theme.colors.blue[6]}
                      stroke={1.5}
                    />
                  }
                >
                  Your History
                </Menu.Item>
                <Menu.Divider />
                <Link href={"/settings"} style={{ textDecoration: "none" }}>
                  <Menu.Item
                    leftSection={
                      <IconSettings
                        style={{ width: rem(16), height: rem(16) }}
                        stroke={1.5}
                      />
                    }
                  >
                    Account settings
                  </Menu.Item>
                </Link>
                <Menu.Item
                  onClick={() =>
                    signOut({ callbackUrl: getBaseUrl() + "/" + locale })
                  }
                  leftSection={
                    <IconLogout
                      style={{ width: rem(16), height: rem(16) }}
                      stroke={1.5}
                    />
                  }
                >
                  Logout
                </Menu.Item>
              </Menu.Dropdown>
            </Menu>
          </Group>
        </Container>
      </Flex>
    </div>
  );
}

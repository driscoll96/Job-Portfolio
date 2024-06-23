"use client";
import {
  ActionIcon,
  Avatar,
  Button,
  Container,
  Divider,
  FileButton,
  FileInput,
  Group,
  NativeSelect,
  Paper,
  Stack,
  TextInput,
  Textarea,
  Title,
} from "@mantine/core";
import { IconTrash } from "@tabler/icons-react";
import { useSession } from "next-auth/react";
import { useState } from "react";
import { SettingsPlatformEditForm } from "@components/Settings/CreatorUserSettings";

//TODO add onchange functions to post updates to BE
export default function Settings() {
  const session = useSession();
  const [file, setFile] = useState<File | null>(null);
  return (
    <>
      <Container>
        <Title size={36}>Settings</Title>
      </Container>
      <Container mt={"xl"}>
        <Title order={3}>Profile Picture</Title>
        <Paper p={"md"} mt={"sm"} radius={"md"}>
          <Group>
            <Avatar
              src={session.data?.user.image}
              alt={"user-logo"}
              radius="xl"
              size={"xl"}
            />
            <Group>
              <FileButton onChange={setFile} accept="image/png,image/jpeg">
                {(props) => (
                  <Button
                    variant="gradient"
                    gradient={{ from: "violet", to: "pink", deg: 90 }}
                    {...props}
                  >
                    Update Profile Picture
                  </Button>
                )}
              </FileButton>
              <ActionIcon
                variant="subtle"
                size="lg"
                aria-label="Gradient action icon"
                gradient={{ from: "blue", to: "cyan", deg: 90 }}
              >
                <IconTrash />
              </ActionIcon>
            </Group>
          </Group>
        </Paper>
      </Container>

      <Container mt={"lg"}>
        <Title order={3}>Profile Settings</Title>
        <Paper p={"md"} mt={"sm"} radius={"md"}>
          <Group gap={"xl"} mb={"md"}>
            <Title order={4}>Bio</Title>
            <Textarea w={"25rem"} placeholder="Describe who you are!" />
          </Group>
          <Divider />
          <Group mt={"md"}>
            <Title order={4}>Account Type</Title>
            <NativeSelect data={["Creator", "Brand"]} />
          </Group>
        </Paper>
      </Container>
      <Container mt={"lg"}>
        <SettingsPlatformEditForm />
      </Container>
    </>
  );
}

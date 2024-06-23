import { Container, Flex, Group } from "@mantine/core";

import { HeaderTabs } from "./HeaderTabs";

import { FooterLinks } from "./FooterLink";
import { type ReactNode } from "react";
import { SessionProvider } from "next-auth/react";

import { NavbarNested } from "./UI/NavbarNested";
import { Session } from "next-auth";
import { HeaderTabsWrapper } from "./HeaderTabsWrapper";

interface IHomeAppShell {
  children: ReactNode;
  session: Session;
}

export function HomeAppShell(props: Readonly<IHomeAppShell>) {
  const { children } = props;
  return (
    <Container fluid={true} px={0} mih={"500px"}>
      <HeaderTabsWrapper />
      <Flex direction="row">
        <NavbarNested />
        {children}
      </Flex>

      <FooterLinks />
    </Container>
  );
}

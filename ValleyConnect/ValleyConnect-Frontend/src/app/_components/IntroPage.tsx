"use client";
import { Button, Center, Container } from "@mantine/core";
import { signIn } from "next-auth/react";
import { FooterLinks } from "./FooterLink";
import { getBaseUrl } from "~/trpc/shared";
import { useLocale } from "next-intl";

export function IntroPage() {
  const locale = useLocale();
  return (
    <Container fluid={true} px={0}>
      <Container h={"50vh"}>
        <Center>
          <Button
            onClick={() =>
              signIn(undefined, {
                callbackUrl: getBaseUrl() + "/" + locale,
              })
            }
            mt={"10vh"}
            variant="filled"
          >
            Sign in
          </Button>
        </Center>
      </Container>
      <FooterLinks />
    </Container>
  );
}

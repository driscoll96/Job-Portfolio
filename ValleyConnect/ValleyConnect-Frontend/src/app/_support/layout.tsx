import { Container } from "@mantine/core";
import { HomeAppShell } from "../_components/HomeAppShell";

export default function Layout({ children }: { children: React.ReactNode }) {
  return <Container>{children}</Container>;
}

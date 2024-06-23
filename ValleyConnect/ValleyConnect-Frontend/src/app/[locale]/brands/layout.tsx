import { Container } from "@mantine/core";

export default function Layout({ children }: { children: React.ReactNode }) {
  return <Container mt="1.5rem">{children}</Container>;
}

"use client";
import {
  Container,
  Text,
  Center,
  TextInput,
  Checkbox,
  Button,
  Group,
  Box,
} from "@mantine/core";

import { useForm } from "@mantine/form";
import SupportForm from "../_components/SupportForm";

export default function Home() {
  return (
    <Container py={15} size={"xs"}>
      <Center>
        <Text size="xl">Support Page</Text>
      </Center>
      <SupportForm />
    </Container>
  );
}

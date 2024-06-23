import { Center, Container, Paper, Stack, Title } from "@mantine/core";
import { CreateListingForm } from "~/app/_components/Brands/CreateListingForm";

export default function Page() {
  return (
    <Container mt="lg" mx="auto">
      <Center>
        <Stack w={600}>
          <Title>Create a new listing</Title>

          <CreateListingForm />
        </Stack>
      </Center>
    </Container>
  );
}

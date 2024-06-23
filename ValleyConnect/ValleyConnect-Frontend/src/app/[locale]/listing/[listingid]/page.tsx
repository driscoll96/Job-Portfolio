import { Avatar, Badge, Container, Group, Paper, Title } from "@mantine/core";
import { Text } from "@mantine/core";
import { Listing_One, Coffee_Brand } from "@constants/DummyData";

export default function Page() {
  // FETCH listing from url id

  const listing = Listing_One;
  return (
    <Container mt={"md"}>
      <Group>
        <Title>{listing.name}</Title>{" "}
        <Avatar src={Coffee_Brand.image} size={80} radius={80} ml={"sm"} />
      </Group>

      <Paper mt={"sm"} p={"md"}>
        <Group>
          <Title order={3}>Application Status</Title>
          <Badge
            size="lg"
            variant="gradient"
            gradient={{ from: "teal", to: "green", deg: 90 }}
          >
            Accepted
          </Badge>
        </Group>
      </Paper>
      <Title order={3} mt={"lg"}>
        Listing Details
      </Title>
      <Paper p={"md"} mt={"sm"}>
        <Text>adfasdf</Text>
      </Paper>
    </Container>
  );
}

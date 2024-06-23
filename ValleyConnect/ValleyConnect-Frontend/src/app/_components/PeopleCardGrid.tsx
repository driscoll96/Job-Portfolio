import {
  Button,
  Card,
  Container,
  Grid,
  Image,
  Text,
  Group,
} from "@mantine/core";

export function PeopleCardGrid() {
  const cardItem = (
    <Card shadow="sm" padding="lg" radius="md" withBorder>
      <Card.Section>
        <Image
          src="https://raw.githubusercontent.com/mantinedev/mantine/master/.demo/images/bg-8.png"
          alt="Norway"
          height={100}
        />
      </Card.Section>

      <Group justify="space-between" mt="md" mb="xs">
        <Text fw={500}>Norway Fjord Adventures</Text>
      </Group>
      <Text size="sm" c="dimmed">
        With Fjord Tours you can explore more of the magical fjord landscapes
        with tours and activities on and around the fjords of Norway
      </Text>

      <Button color="blue" fullWidth mt="md" radius="md">
        Book classic tour now
      </Button>
    </Card>
  );
  return (
    <Container mt={"xl"}>
      <Grid>
        <Grid.Col span={4}>{cardItem}</Grid.Col>
        <Grid.Col span={4}>{cardItem}</Grid.Col>
        <Grid.Col span={4}>{cardItem}</Grid.Col>
        <Grid.Col span={4}>{cardItem}</Grid.Col>
        <Grid.Col span={4}>{cardItem}</Grid.Col>
        <Grid.Col span={4}>{cardItem}</Grid.Col>
      </Grid>
    </Container>
  );
}

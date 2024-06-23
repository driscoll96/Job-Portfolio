import {
  Card,
  Image,
  Text,
  Title,
  Stack,
  Container,
  Paper,
  AspectRatio,
  Badge,
} from "@mantine/core";
import classes from "@styles/HoverCard.module.css";
import { useRouter } from "next/navigation";
import NextImage, { type StaticImageData } from "next/image";
export interface IFilterCardProps {
  filterType: string;
  image: StaticImageData;
}

export function FilterCard(props: Readonly<IFilterCardProps>) {
  const { filterType, image } = props;
  const router = useRouter();

  //TODO remove dummy data
  return (
    <Paper
      className={classes.card}
      onClick={() => router.push("/marketplace/" + filterType)}
      shadow="lg"
      radius="md"
      p={0}
    >
      <Container px={0}>
        <AspectRatio>
          <Image
            component={NextImage}
            src={image}
            alt={"brand image"}
            fill={true}
            style={{
              borderTopLeftRadius: "var(--mantine-radius-md)",
              borderTopRightRadius: "var(--mantine-radius-md)",
            }}
          />
        </AspectRatio>
      </Container>

      <Container mb={"0.5rem"}>
        <Stack gap={"0.25rem"} align="center">
          <Title order={4}>{filterType}</Title>
          <Badge
            variant="gradient"
            gradient={{ from: "blue", to: "cyan", deg: 90 }}
          >
            50 listings
          </Badge>
        </Stack>
      </Container>
    </Paper>
  );
}

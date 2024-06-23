"use client";
import { Card, Image, Text, Group, AspectRatio } from "@mantine/core";
import { type Brand } from "@prisma/client";
import { useRouter } from "next/navigation";
import classes from "@styles/HoverCard.module.css";
export interface IBrandCardProps {
  brand: Brand;
}
// TODO can we pass the brand object with the redirect?
export default function BrandCard(props: Readonly<IBrandCardProps>) {
  const { brand } = props;
  const router = useRouter();
  return (
    <Card
      shadow="sm"
      padding="lg"
      radius="md"
      withBorder
      onClick={() => router.push("/brands/" + brand.name)}
      style={{ cursor: "pointer" }}
      className={classes.card}
    >
      <Card.Section>
        <AspectRatio ratio={1080 / 720} maw={300} mx="auto">
          <Image src={brand.image} alt={brand.name} height={100} />
        </AspectRatio>
      </Card.Section>

      <Group justify="space-between" mt="md" mb="xs">
        <Text fw={500}>{brand.name}</Text>
      </Group>
      <Text size="sm" c="dimmed">
        {brand.description}
      </Text>
    </Card>
  );
}

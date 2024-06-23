"use client";
import {
  Card,
  Image,
  Text,
  Badge,
  Button,
  Group,
  Stack,
  Avatar,
  Skeleton,
  Title,
} from "@mantine/core";
import { type Listing, type Brand } from "@prisma/client";

import Link from "next/link";
import React from "react";
import { PlatformBadgesList } from "../PlatformBadgesList";
import classes from "@styles/HoverCard.module.css";

export interface IListingCardProps {
  brand: Brand;
  listing?: Listing;
}

export function ListingCard(props: Readonly<IListingCardProps>) {
  const { brand, listing } = props;

  const cardBody = () => {
    if (listing) {
      return (
        <Link
          href={`/listing/${listing.id}`}
          style={{ textDecoration: "none" }}
          key={listing.id}
        >
          <Card
            shadow="lg"
            padding="md"
            radius="md"
            withBorder
            pt={"0.25rem"}
            style={{ cursor: "pointer" }}
            className={classes.card}
            h={375}
          >
            <Stack mt="xs" mb="xs">
              <Group>
                <Avatar src={brand.image} size={80} radius={80} />
                <Text fw={600}>{brand.name}</Text>
              </Group>
              <Title order={3}>{listing.name}</Title>
              <Text size="sm" c="dimmed" lineClamp={6} h={120}>
                {listing.description}
              </Text>
              <Group gap={"xs"}>
                {listing.platforms ? (
                  <Stack>
                    Desired Platforms
                    <PlatformBadgesList platforms={listing.platforms} />
                  </Stack>
                ) : (
                  <></>
                )}
              </Group>
            </Stack>
          </Card>
        </Link>
      );
    } else {
      return (
        <Card
          shadow="lg"
          padding="md"
          radius="md"
          withBorder
          pt={"0.25rem"}
          style={{ cursor: "pointer" }}
          className={classes.card}
          h={300}
        >
          <Skeleton height={80} circle mb="xl" mt={"md"} />
          <Skeleton height={8} radius="xl" />
          <Skeleton height={8} mt={6} radius="xl" />
          <Skeleton height={8} mt={6} width="70%" radius="xl" />
        </Card>
      );
    }
  };

  //TODO color of tag should match platform ie. twitch = purple
  return cardBody();
}

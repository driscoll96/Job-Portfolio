import { Avatar, Text, Button, Paper, Badge, Group } from "@mantine/core";
import { type User } from "@prisma/client";
import React from "react";

import { PlatformBadgesList } from "../PlatformBadgesList";

export interface ICreatorCardProps {
  user: User;
}

export function CreatorCard(props: ICreatorCardProps) {
  const { user } = props;

  return (
    <Paper radius="md" withBorder p="lg" bg="var(--mantine-color-body)">
      <Avatar src={user.image} size={120} radius={120} mx="auto" />
      <Text ta="center" fz="lg" fw={500} mt="md">
        {user.name}
      </Text>
      <Group gap={"xs"}>
        {<PlatformBadgesList platforms={user.platforms} />}
      </Group>

      <Button variant="default" fullWidth mt="md">
        View Profile
      </Button>
    </Paper>
  );
}

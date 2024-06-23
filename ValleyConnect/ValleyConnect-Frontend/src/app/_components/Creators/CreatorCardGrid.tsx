"use client";
import { User } from "@prisma/client";
import React from "react";
import { CreatorCard } from "@components/Creators/CreatorCard";
import { SimpleGrid } from "@mantine/core";

export interface ICreatorCardGridProps {
  users: User[];
}

export function CreatorCardGrid(props: ICreatorCardGridProps) {
  const { users } = props;
  const creatorCards = React.useMemo(() => {
    const cardElements: JSX.Element[] = [];

    users.forEach((user) => {
      cardElements.push(<CreatorCard user={user} />);
    });
    return cardElements;
  }, [users]);

  return (
    <SimpleGrid cols={{ base: 1, sm: 2, lg: 3 }}>{creatorCards}</SimpleGrid>
  );
}

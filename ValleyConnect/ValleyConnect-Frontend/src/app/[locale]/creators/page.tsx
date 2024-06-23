"use client";
import { Container, Pagination, Title } from "@mantine/core";

import { api } from "~/trpc/react";
import { User, UserType } from "@prisma/client";
import React, { useState } from "react";
import { CreatorCardGrid } from "@components/Creators/CreatorCardGrid";

export default function Creators() {
  function chunk<T>(array: T[], size: number): T[][] {
    if (!array.length) {
      return [];
    }
    const head = array.slice(0, size);
    const tail = array.slice(size);
    return [head, ...chunk(tail, size)];
  }

  const [activePage, setActivePage] = useState(1);
  const creatorUsers = api.users.getByUserType.useQuery(UserType.CREATOR).data;

  const chunkedData = chunk(creatorUsers ?? [], 6);

  return (
    <Container mt={"md"} w={"75%"}>
      <Title size={50} mb={"2rem"}>
        Creators
      </Title>

      {creatorUsers ? (
        <>
          <CreatorCardGrid users={chunkedData[activePage - 1]} />
          <Pagination
            mt={"md"}
            total={chunkedData.length}
            value={activePage}
            onChange={setActivePage}
          />
        </>
      ) : (
        <></>
      )}
    </Container>
  );
}

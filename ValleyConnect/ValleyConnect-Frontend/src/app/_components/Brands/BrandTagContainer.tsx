import { Badge } from "@mantine/core";
import { type Tag } from "@prisma/client";
import React from "react";

export interface IBrandTagContainerProps {
  tags: Tag[];
}

export function BrandTagContainer(props: Readonly<IBrandTagContainerProps>) {
  const { tags } = props;

  const badges = React.useMemo(() => {
    const tagsElementArray: React.JSX.Element[] = [];

    tags.forEach((tag) => {
      const badgeElement = <Badge mr={"0.25rem"}>{tag.name}</Badge>;
      tagsElementArray.push(badgeElement);
    });
    return tagsElementArray;
  }, [tags]);

  return <>{badges}</>;
}

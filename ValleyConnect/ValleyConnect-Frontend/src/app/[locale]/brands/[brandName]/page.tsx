"use client";

import { Grid, Paper } from "@mantine/core";
import { Brand, Prisma, Tag } from "@prisma/client";
import { BrandPage } from "~/app/_components/Brands/BrandPage";
import { Coffee_Brand, Tags_One } from "@constants/DummyData";

// fetch the brand

export default function Page() {
  //TODO remove hard coded data

  //TODO new component BrandCardGrid to render the grid
  //TODO add hover to the cards
  return <BrandPage brand={Coffee_Brand} tags={Tags_One} />;
}

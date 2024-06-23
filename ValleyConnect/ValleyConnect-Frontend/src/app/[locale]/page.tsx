import { Button, Container, Tabs, Title, Tooltip } from "@mantine/core";
import { BrandCardGrid } from "@components/Brands/BrandCardGrid";
import { ListingCardGrid } from "@components/Brands/ListingCardGrid";

import { Coffee_Brand, Tags_One } from "@constants/DummyData";
import { api } from "~/trpc/server";
import Link from "next/link";
import { useTranslations } from "next-intl";
import { getTranslations } from "next-intl/server";

export default async function Page() {
  const listings = await api.listings.getAll.query();
  const c = await getTranslations("Common");
  return (
    <Container ml={"lg"} mt={"lg"} mr={"lg"} size={"lg"}>
      <Title size={50} mb={"2rem"}>
        {c("Listings")}
      </Title>

      <ListingCardGrid columns={3} brand={Coffee_Brand} listings={listings} />
    </Container>
  );
}

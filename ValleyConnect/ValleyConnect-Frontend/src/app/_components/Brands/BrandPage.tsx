import {
  AspectRatio,
  Button,
  Container,
  Divider,
  Group,
  Paper,
  Stack,
  Image,
  Text,
  Title,
  SimpleGrid,
} from "@mantine/core";
import { Listing, type Brand, type Tag } from "@prisma/client";
import { useTranslations } from "next-intl";
export interface IBrandPageProps {
  brand: Brand;
  tags: Tag[];
}
import NextImage from "next/image";
import { BrandTagContainer } from "./BrandTagContainer";

import { Listing_One } from "@constants/DummyData";
import { ListingCardGrid } from "./ListingCardGrid";

export function BrandPage(props: Readonly<IBrandPageProps>) {
  const { brand, tags } = props;
  const c = useTranslations("Common");

  //TODO create listings card grid to render under the company

  return (
    <Paper>
      <Group p="0.75rem" align="start" preventGrowOverflow={true}>
        <Container ml="1rem" id={"brand-image-" + brand.name} mr={0}>
          <Stack>
            <AspectRatio>
              <Image
                component={NextImage}
                alt="brand-logo"
                src={brand.image}
                width={250}
                height={250}
              />
            </AspectRatio>
            <Group>
              <Button>{c("Follow")}</Button>
              <Button>{c("VisitWebsite")}</Button>
            </Group>
          </Stack>
        </Container>
        <Container ml={0} w={"65%"} pb={"1rem"}>
          <Stack id={"brand-detail-" + brand.name}>
            <Container ml={0}>
              <Title order={1}>{brand.name}</Title>
            </Container>
            <Container ml={0}>
              <Text>{brand.description}</Text>
            </Container>

            {brand ? (
              <Container id={"brand-tags-" + brand.name} ml={0}>
                <BrandTagContainer tags={tags} />
              </Container>
            ) : (
              <></>
            )}
          </Stack>
        </Container>
      </Group>
      <Divider />
      <Container id={"brand-listing-grid-" + brand.name} py={"0.75rem"}>
        <ListingCardGrid
          columns={3}
          brand={brand}
          listings={[Listing_One, Listing_One, Listing_One, Listing_One]}
        />
      </Container>
    </Paper>
  );
}

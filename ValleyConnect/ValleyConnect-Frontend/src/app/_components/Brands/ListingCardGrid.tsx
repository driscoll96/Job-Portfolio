"use client";
import { Brand, Listing } from "@prisma/client";
import { ListingCard } from "./ListingCard";
import React from "react";
import { SimpleGrid } from "@mantine/core";

export interface IListingCardGridProps {
  listings?: Listing[];
  brand: Brand;
  columns: number;
}
//TODO we could prob make this to a generic grid wrapper
export function ListingCardGrid(props: Readonly<IListingCardGridProps>) {
  const { listings, brand } = props;

  // default grid of listings with skeleton
  const listingCards = React.useMemo(() => {
    const listingsElementArray: React.JSX.Element[] = [];
    if (listings) {
      listings.forEach((listing) => {
        const listingCard = <ListingCard brand={brand} listing={listing} />;
        listingsElementArray.push(listingCard);
      });
    } else {
      listingsElementArray.push(<ListingCard brand={brand} />);
      listingsElementArray.push(<ListingCard brand={brand} />);

      listingsElementArray.push(<ListingCard brand={brand} />);
      listingsElementArray.push(<ListingCard brand={brand} />);
    }
    return listingsElementArray;
  }, [brand, listings]);

  return (
    <SimpleGrid cols={{ base: 1, sm: 2, lg: 4 }}>{listingCards}</SimpleGrid>
  );
}

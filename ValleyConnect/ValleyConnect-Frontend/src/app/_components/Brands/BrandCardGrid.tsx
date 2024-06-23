import { SimpleGrid } from "@mantine/core";
import {
  Gaming_Brand,
  Tech_Brand,
  Coffee_Brand,
} from "~/app/_constants/DummyData";
import BrandCard from "./BrandCard";

export function BrandCardGrid() {
  return (
    <SimpleGrid cols={3}>
      <BrandCard brand={Gaming_Brand} />
      <BrandCard brand={Tech_Brand} />
      <BrandCard brand={Coffee_Brand} />
    </SimpleGrid>
  );
}

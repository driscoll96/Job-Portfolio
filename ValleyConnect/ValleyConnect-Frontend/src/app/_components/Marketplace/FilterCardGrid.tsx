import { SimpleGrid } from "@mantine/core";
import { FilterCard } from "@components/Marketplace/FilterCard";
import delivery from "@public/filters/delivery-filter.jpg";
import travel from "@public/filters/travel-filter.jpg";
import tech from "@public/filters/tech-filter.png";
import fitness from "@public/filters/fitness-filter.jpg";

//TODO remove hard coded data
export function FilterCardGrid() {
  return (
    <SimpleGrid cols={4}>
      <FilterCard image={delivery} filterType="Delivery" />
      <FilterCard image={travel} filterType="Travel" />
      <FilterCard image={tech} filterType="Tech" />
      <FilterCard image={fitness} filterType="Fitness" />
    </SimpleGrid>
  );
}

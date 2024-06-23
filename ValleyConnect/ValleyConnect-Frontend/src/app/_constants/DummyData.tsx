import { type Listing, type Brand, Tag } from "@prisma/client";

import coffee from "@public/brands/coffee-brand.svg";
import gaming from "@public/brands/gaming-brand.svg";
import tech from "@public/brands/tech-brand.svg";

/**
 * Temp file to hold common dummy data models
 */

export const Coffee_Brand: Brand = {
  id: "123",
  name: "Morning Coffee",
  image: "/brands/coffee-brand.svg",
  description: "We sell coffee!",
  createdOn: new Date(),
  createdBy: "1234",
  UpdatedOn: new Date(),
  verified: true,
  status: "ACTIVE",
};

export const Gaming_Brand: Brand = {
  id: "123",
  name: "Impact Esports",
  image: "/brands/gaming-brand.svg",
  description: "We compete in many games",
  createdOn: new Date(),
  createdBy: "1234",
  UpdatedOn: new Date(),
  verified: true,
  status: "ACTIVE",
};

export const Tech_Brand: Brand = {
  id: "123",
  name: "Infinity Tech",
  image: "/brands/tech-brand.svg",
  description: "Bringing infinity tech to you",
  createdOn: new Date(),
  createdBy: "1234",
  UpdatedOn: new Date(),
  verified: true,
  status: "ACTIVE",
};

export const Listing_One: Listing = {
  id: "123",
  brandId: "321",
  name: "Coffee Promo",
  image: "/brand-logo.png",
  description:
    "We want you to shoutout this thing. You will do this on twtich!",
  platform: "twitch",
  createdOn: new Date(),
  createdBy: "1234",
  UpdatedOn: new Date(),

  status: "ACTIVE",
};

export const Tags_One: Tag[] = [
  {
    id: "123",
    name: "tech",
    createdOn: new Date(),
    createdBy: "1234",
    UpdatedOn: new Date(),
    status: "ACTIVE",
  },
  {
    id: "1234",
    name: "fitness",
    createdOn: new Date(),
    createdBy: "1234",
    UpdatedOn: new Date(),
    status: "ACTIVE",
  },
];

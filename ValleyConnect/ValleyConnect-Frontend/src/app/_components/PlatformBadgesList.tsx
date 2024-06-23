import { Group, Image, Stack } from "@mantine/core";
import NextImage, { type StaticImageData } from "next/image";
export interface IPlatformBadgesListProps {
  platforms?: string;
}

import insta from "@public/platforms/insta.svg";
import kick from "@public/platforms/kick.png";
import twitch from "@public/platforms/twitch.svg";
import facebook from "@public/platforms/facebook.svg";
import youtube from "@public/platforms/youtube.svg";
import tiktok from "@public/platforms/tiktok.svg";
import x from "@public/platforms/x.svg";
export function PlatformBadgesList(props: IPlatformBadgesListProps) {
  const { platforms } = props;

  const platformImageMap: Map<string, string> = new Map<string, string>([
    ["X", x],
    ["Youtube", youtube],
    ["Twitch", twitch],
    ["Kick", kick],
    ["Instagram", insta],
    ["Tiktok", tiktok],
    ["Facebook", facebook],
  ]);

  const badgeElements: JSX.Element[] = [];
  if (platforms) {
    const platformsSplit = platforms.split(",");

    // we should have a map of platform to color
    platformsSplit.forEach((platform) => {
      const platformImage = platformImageMap.get(platform.trim());

      badgeElements.push(
        <Image
          component={NextImage}
          src={platformImage}
          alt="brand"
          height={25}
          width={100}
        />,
      );
    });
  }

  return <Group>{badgeElements}</Group>;
}

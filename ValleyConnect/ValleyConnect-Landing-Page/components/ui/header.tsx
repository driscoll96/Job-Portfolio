"use client";
import Link from "next/link";

import Image from "next/image";
import { Group, Button } from "@mantine/core";

export default function Header() {
  // TODO: Add this back in when we can forward logins to the dashboard page
  // eslint-disable-next-line @typescript-eslint/no-unused-vars
  const loginNavItems = (
    <nav className="hidden md:flex md:grow">
      {/* Desktop sign in links */}
      <ul className="flex grow justify-end flex-wrap items-center">
        <li>
          <Link
            href="https://frontend-6tc96mc52-ivor-zaluds-projects.vercel.app/api/auth/signin"
            className="font-medium text-purple-600 hover:text-gray-200 px-4 py-3 flex items-center transition duration-150 ease-in-out"
          >
            Sign in
          </Link>
        </li>
        <li>
          <Link
            href="/signup"
            className="btn-sm text-white bg-purple-600 hover:bg-purple-700 ml-3"
          >
            Sign up
          </Link>
        </li>
      </ul>
    </nav>
  );
  // eslint-disable-next-line @typescript-eslint/no-var-requires
  const logo = require("../../public/images/valley logo old colors white.png");

  return (
    <div>
      {/* Site branding */}
      <Group mt={"sm"} ml={"sm"}>
        {/* Logo */}

        <Image src={logo} alt="valley logo" width={250} height={100} />

        <Group gap={"xs"}>
          <Button
            variant="subtle"
            size="compact-lg"
            c={"white"}
            component={Link}
            href={"/"}
          >
            Home
          </Button>
          <a href="https://blog.valleyconnect.app">
            <Button variant="subtle" size="compact-lg" c={"white"}>
              Blog
            </Button>
          </a>
        </Group>
      </Group>
    </div>
  );
}

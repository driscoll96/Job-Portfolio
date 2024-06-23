"use client";
import { SessionProvider } from "next-auth/react";
import { HeaderTabs } from "./HeaderTabs";

export function HeaderTabsWrapper() {
  // We have to use this wrapper to provide session to the sub componenent
  return (
    <SessionProvider>
      <HeaderTabs />
    </SessionProvider>
  );
}

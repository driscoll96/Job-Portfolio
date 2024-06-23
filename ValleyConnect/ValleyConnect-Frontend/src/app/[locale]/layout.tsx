import "~/styles/globals.css";
import "@mantine/core/styles.css";
import "@mantine/carousel/styles.css";
import "@mantine/core/styles.css"; //import Mantine V7 styles needed by MRT
import "@mantine/dates/styles.css";
import "mantine-react-table/styles.css"; //import MRT styles
import { Inter } from "next/font/google";
import { cookies } from "next/headers";
import { ColorSchemeScript, Container, MantineProvider } from "@mantine/core";
import { TRPCReactProvider } from "~/trpc/react";
import { HomeAppShell } from "@components/HomeAppShell";
import { getServerAuthSession } from "~/server/auth";

import { IntroPage } from "@components/IntroPage";
import { Analytics } from "@vercel/analytics/react";
import { SpeedInsights } from "@vercel/speed-insights/next";
import { ReactNode } from "react";
import { locales } from "~/navigation";
import { getTranslations, unstable_setRequestLocale } from "next-intl/server";

type Props = {
  children: ReactNode;
  params: { locale: string };
};

export function generateStaticParams() {
  return locales.map((locale) => ({ locale }));
}

export async function generateMetadata({
  params: { locale },
}: Omit<Props, "children">) {
  const t = await getTranslations({ locale, namespace: "Metadata" });

  return {
    title: t("Title"),
    description: t("Description"),
    icons: [{ rel: "icon", url: "/favicon.ico" }],
  };
}

export default async function LocaleLayout({
  children,
  params: { locale },
}: Props) {
  const session = await getServerAuthSession();
  unstable_setRequestLocale(locale);

  return (
    <html lang="en">
      <head>
        <ColorSchemeScript />
      </head>

      <body>
        <MantineProvider defaultColorScheme="dark">
          <TRPCReactProvider cookies={cookies().toString()}>
            <Container
              fluid={true}
              px={0}
              className="bg-gradient-to-b from-gray-900 via-purple-900 to-violet-600"
            >
              {session?.user ? (
                <HomeAppShell session={session}>{children}</HomeAppShell>
              ) : (
                // sign in page
                <Container fluid={true} px={0}>
                  <IntroPage />
                </Container>
              )}
            </Container>
            <Analytics />
            <SpeedInsights />
          </TRPCReactProvider>
        </MantineProvider>
      </body>
    </html>
  );
}

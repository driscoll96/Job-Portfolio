import "./css/style.css";
import { SpeedInsights } from "@vercel/speed-insights/next";
import { Inter, Architects_Daughter } from "next/font/google";
import "@mantine/core/styles.css";

import { ColorSchemeScript, MantineProvider } from "@mantine/core";

const inter = Inter({
  subsets: ["latin"],
  variable: "--font-inter",
  display: "swap",
});

// eslint-disable-next-line @typescript-eslint/naming-convention
const architects_daughter = Architects_Daughter({
  subsets: ["latin"],
  variable: "--font-architects-daughter",
  weight: "400",
  display: "swap",
});

export const metadata = {
  title: "Valley",
  description: "Connecting Brands and Creators",
  keywords: [
    "valley",
    "valleyconnect",
    "streaming",
    "content creators",
    "micromarketing",
    "Brand Collaboration",
    "Content Sponsorship",
    "sponsored content",
  ],
  creator: "Valley Services, Inc.",
  publisher: "Valley Services, Inc.",
  robots: {
    index: true,
    follow: true,
    nocache: true,
    googleBot: {
      index: true,
      follow: false,
      noimageindex: true,
      "max-video-preview": -1,
      "max-image-preview": "large",
      "max-snippet": -1,
    },
  },
};

export default function RootLayout({
  children,
}: {
  children: React.ReactNode;
}) {
  return (
    <html lang="en">
      <head>
        <ColorSchemeScript />
      </head>
      <body
        className={`${inter.variable} ${architects_daughter.variable} font-inter antialiased bg-gray-900 text-gray-200 tracking-tight`}
      >
        <MantineProvider>
          <div className="flex flex-col min-h-screen overflow-hidden">
            {children}
          </div>
          <SpeedInsights />
        </MantineProvider>
      </body>
    </html>
  );
}

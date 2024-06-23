import "aos/dist/aos.css";

import PageIllustration from "@/components/page-illustration";
import Footer from "@/components/ui/footer";

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

export default function DefaultLayout({
  children,
}: {
  children: React.ReactNode;
}) {
  return (
    <>
      <main className="grow">
        <PageIllustration />

        {children}
      </main>

      <Footer />
    </>
  );
}

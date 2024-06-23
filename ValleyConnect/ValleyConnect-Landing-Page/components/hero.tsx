"use client";
import Zigzag from "./zigzag";
import Image from "next/image";
import HeroImage from "@/public/images/pexels-alena-darmel-7862360-edited.jpg";
import Newsletter from "./newsletter";
import { Title } from "@mantine/core";
import Header from "./ui/header";

export default function Hero() {
  return (
    <section>
      <div className="max-w-6xl mx-auto px-4 sm:px-6 relative">
        {/* Illustration behind hero content */}

        <Header />

        {/* Hero content */}
        <div className="relative pt-32 pb-10 md:pt-40 md:pb-16">
          {/* Section header */}
          <div className="max-w-3xl mx-auto text-center pb-12 md:pb-16">
            <h1 className="h1 mb-4" data-aos="fade-up">
              {/* Take your channel earnings to the next level */}
              Take your sponsorships to the next level
            </h1>
            <p
              className="text-xl text-gray-400 mb-8"
              data-aos="fade-up"
              data-aos-delay="200"
            >
              {/* From small streamers to mega influencers, Valley can help grow
              content and increase the earnings of any creator */}
              Valley can help grow the earnings of any creator and the brand awareness of any business 
            </p>
            <div
              className="max-w-xl md:max-w-none md:w-full mx-auto md:col-span-5 lg:col-span-6 mb-8 md:mb-0 md:order-1"
              data-aos="fade-up"
            >
              <Image
                className="max-w-full mx-auto md:max-w-none h-auto"
                src={HeroImage}
                width={600}
                height={465}
                alt="Wireframe 01"
              />
            </div>
            <div className="mt-8">
              <Title order={2} mb={"md"}>
                Enter your brand or creator info to be considered for
                partnerships now!
              </Title>
              <Newsletter />
            </div>
          </div>
        </div>
      </div>
      <></>
      <Zigzag />
    </section>
  );
}

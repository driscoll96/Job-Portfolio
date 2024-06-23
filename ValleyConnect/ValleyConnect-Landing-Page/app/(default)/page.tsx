"use client";
import Hero from "@/components/hero";

import AOS from "aos";
import React, { useEffect } from "react";

import Script from "next/script";

export default function Home() {
  useEffect(() => {
    AOS.init({
      once: true,
      disable: "phone",
      duration: 600,
      easing: "ease-out-sine",
    });
  });
  return (
    <>
      <Hero />
      <Script
        src="https://us.umami.is/script.js"
        data-website-id="5348150a-8a21-4bbe-8239-7ca5aec7073e"
      />
    </>
  );
}

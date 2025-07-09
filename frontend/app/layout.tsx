import type { Metadata } from "next";
import { Inter } from "next/font/google";
import "./globals.css";
import React from "react";
import { ThemeProvider } from "next-themes";

const inter = Inter({
    subsets: ["latin"],
})

export const metadata: Metadata = {
  title: "VoteHub",
  description: "Create polls, vote in real time and see what the community thinks.",
};

export default function RootLayout({
  children,
}: Readonly<{
  children: React.ReactNode;
}>) {
  return (
    <html lang="en" suppressHydrationWarning={true}>
      <body
        className={`${inter} antialiased`}
      >
      <ThemeProvider attribute="class" defaultTheme="dark" enableSystem={true}>
          {children}
      </ThemeProvider>
      </body>
    </html>
  );
}

import { ThemeToggle } from "@/components/theme-toggle";
import { Logo } from "@/components/logo";
import React from "react";

export function Header(): React.ReactNode {
    return (<header className="border-b">
        <div className="container mx-auto px-4 py-4 flex justify-between items-center">
            <Logo/>
            <ThemeToggle />
        </div>
    </header>)
}
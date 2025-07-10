"use client";

import { useTheme } from "next-themes";
import React, { useEffect, useState } from "react";
import { Button } from "@/components/ui/button";
import { Moon, Sun } from "lucide-react";

export function ThemeToggle(): React.ReactNode {
    const { theme, setTheme } = useTheme();
    const [mounted, setMounted] = useState(false);

    useEffect((): void => {
        setMounted(true);
    }, []);

    if (!mounted) return null;

    return (
        <Button
            onClick={(): void => setTheme(theme === "dark" ? "light" : "dark")}
            size="icon"
        >
            {theme === "dark" ? <Sun className="h-5 w-5" /> : <Moon className="h-5 w-5" />}
        </Button>
    );
}

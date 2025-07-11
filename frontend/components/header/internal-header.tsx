"use client";

import { ThemeToggle } from "@/components/theme-toggle";
import { SearchInput } from "@/components/search-input";
import { CreatePollButton } from "@/components/create-poll/create-poll-button";
import { Logo } from "@/components/logo";
import { MobileMenu } from "@/components/header/mobile-menu";
import { LogoutButton } from "@/components/logout-button";
import { useRouter } from "next/navigation";
import React from "react";
import { AppRouterInstance } from "next/dist/shared/lib/app-router-context.shared-runtime";

export function InternalHeader(): React.ReactNode {
    const router: AppRouterInstance = useRouter();

    const handleLogout: () => void = (): void => {
        localStorage.removeItem("auth-token");
        router.push("http://localhost:8080/logout");
    }

    return (
        <header className="border-b">
            <div className="container mx-auto px-4 py-4 flex items-center justify-between gap-4 flex-wrap">
                <Logo/>

                <div className="hidden md:flex gap-4">
                    <div className="max-w-xl w-full">
                        <SearchInput/>
                    </div>

                    <div className="flex items-center gap-2">
                        <CreatePollButton/>
                        <LogoutButton onLogoutAction={handleLogout}/>
                        <ThemeToggle/>
                    </div>
                </div>
                <div className="md:hidden">
                    <MobileMenu/>
                </div>
            </div>
        </header>
    );
}

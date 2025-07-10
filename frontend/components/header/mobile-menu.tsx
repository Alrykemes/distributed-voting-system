"use client";

import { Sheet, SheetContent, SheetHeader, SheetTitle, SheetTrigger } from "@/components/ui/sheet";
import { Button } from "@/components/ui/button";
import { Menu, Vote } from "lucide-react";
import { CreatePollButton } from "@/components/create-poll/create-poll-button";
import { ThemeToggle } from "@/components/theme-toggle";
import { SearchInput } from "@/components/search-input";
import { MyLabel } from "@/components/my-label";
import { LogoutButton } from "@/components/logout-button";
import { useRouter } from "next/navigation";
import { AppRouterInstance } from "next/dist/shared/lib/app-router-context.shared-runtime";

export function MobileMenu() {
    const router: AppRouterInstance = useRouter();

    const handleLogout: () => void = (): void => {
        router.push("/");
    }

    return (
        <Sheet>
            <SheetTrigger asChild>
                <Button variant="outline" size="icon" aria-label="Abrir menu">
                    <Menu className="w-6 h-6"/>
                </Button>
            </SheetTrigger>
            <SheetContent className="p-6 flex flex-col min-h-full">

                <SheetHeader className="flex flex-col items-center gap-2 border-b border-muted pb-4">
                    <SheetTitle>
                        <Vote className="w-6 h-6"/>
                    </SheetTitle>
                    <h2 className="text-lg font-semibold">VoteHub</h2>
                </SheetHeader>

                <div className="flex-1 space-y-8 pt-6">
                    <div className="space-y-2">
                        <MyLabel label="Pesquisar enquetes"/>
                        <SearchInput/>
                    </div>
                    <div className="space-y-2">
                        <MyLabel label="Criar enquete"/>
                        <CreatePollButton className="w-full"/>
                    </div>
                </div>

                <div className="flex justify-between pt-6 border-t border-muted">
                    <div className="text-center space-y-2">
                        <MyLabel label="Tema"/>
                        <ThemeToggle/>
                    </div>
                    <div className="text-center space-y-2">
                        <MyLabel label="Logout"/>
                        <LogoutButton onLogoutAction={handleLogout}/>
                    </div>
                </div>
            </SheetContent>
        </Sheet>
    );
}

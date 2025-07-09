import {Vote} from "lucide-react";
import {ThemeToggle} from "@/components/theme-toggle";
import {SearchInput} from "@/components/search-input";
import {CreatePollButton} from "@/components/create-poll-button";
import {Logo} from "@/components/logo";
import {MobileMenu} from "@/components/mobile-menu";

export function InternalHeader() {
    return (
        <header className="border-b">
            <div className="container mx-auto px-4 py-4 flex items-center justify-between gap-4 flex-wrap">
                <Logo/>

                <div className="hidden md:flex gap-4">
                    <div className="max-w-xl w-full">
                        <SearchInput />
                    </div>

                    <div className="flex items-center gap-2">
                        <CreatePollButton />
                        <ThemeToggle />
                    </div>
                </div>
                <div className="md:hidden">
                    <MobileMenu />
                </div>
            </div>
        </header>
    );
}

import {Vote} from "lucide-react";
import {ThemeToggle} from "@/components/theme-toggle";
import {Logo} from "@/components/logo";

export function Header() {
    return (<header className="border-b">
        <div className="container mx-auto px-4 py-4 flex justify-between items-center">
            <Logo/>
            <ThemeToggle />
        </div>
    </header>)
}
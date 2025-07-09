import {Vote} from "lucide-react";
import {ThemeToggle} from "@/components/theme-toggle";

export function Header() {
    return (<header className="border-b">
        <div className="container mx-auto px-4 py-4 flex justify-between items-center">
            <div className="flex items-center gap-2">
                <Vote className="h-8 w-8 text-primary" />
                <h1 className="text-2xl font-bold text-foreground">VoteHub</h1>
            </div>
            <ThemeToggle />
        </div>
    </header>)
}
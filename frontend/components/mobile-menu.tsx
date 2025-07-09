import {
    Sheet,
    SheetContent,
    SheetHeader,
    SheetTitle,
    SheetTrigger,
} from "@/components/ui/sheet";
import { Button } from "@/components/ui/button";
import { Menu, Vote } from "lucide-react";
import { CreatePollButton } from "@/components/create-poll-button";
import { ThemeToggle } from "@/components/theme-toggle";
import { SearchInput } from "@/components/search-input";
import { Label } from "@/components/ui/label";

export function MobileMenu() {
    return (
        <Sheet>
            <SheetTrigger asChild>
                <Button variant="outline" size="icon" aria-label="Abrir menu">
                    <Menu className="w-6 h-6" />
                </Button>
            </SheetTrigger>
            <SheetContent className="p-6 space-y-6">
                <SheetHeader className="flex flex-col items-center gap-2 border-b border-muted pb-4">
                    <SheetTitle>
                        <Vote className="w-6 h-6" />
                    </SheetTitle>
                    <h2 className="text-lg font-semibold">VoteHub</h2>
                </SheetHeader>
                <div className="space-y-4">
                    <div className="space-y-2">
                        <Label className="text-sm font-medium text-muted-foreground">
                            Pesquisar enquetes
                        </Label>
                        <SearchInput/>
                    </div>
                    <div className="space-y-2">
                        <Label className="text-sm font-medium text-muted-foreground">
                            Criar enquete
                        </Label>
                        <CreatePollButton/>
                    </div>
                </div>
                <div className="space-y-2 pt-6 border-t border-muted">
                    <Label className="text-sm font-medium text-muted-foreground">
                        Tema
                    </Label>
                    <ThemeToggle />
                </div>
            </SheetContent>
        </Sheet>
    );
}

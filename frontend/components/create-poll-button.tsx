import {Button} from "@/components/ui/button";
import {
    Dialog,
    DialogContent,
    DialogDescription,
    DialogHeader,
    DialogTitle,
    DialogTrigger
} from "@/components/ui/dialog";
import {Plus} from "lucide-react";

export function CreatePollButton() {
    return (
        <Dialog>
            <DialogTrigger asChild>
                <Button className="gap-2">
                    <Plus className="h-4 w-4"/>
                    Criar Enquete
                </Button>
            </DialogTrigger>
            <DialogContent>
                <DialogHeader>
                    <DialogTitle>
                        Criar Nova Enquete
                    </DialogTitle>
                    <DialogDescription>
                        Crie uma enquete para que a comunidade possa votar e expressar sua opinião.
                    </DialogDescription>
                </DialogHeader>

            </DialogContent>
        </Dialog>
    );
}
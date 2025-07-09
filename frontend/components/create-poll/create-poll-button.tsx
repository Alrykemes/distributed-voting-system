"use client";

import {Dialog, DialogTrigger,} from "@/components/ui/dialog";
import {Button} from "@/components/ui/button";
import {Plus} from "lucide-react";
import {CreatePollDialog} from "@/components/create-poll/create-poll-dialog";
import {cn} from "@/lib/utils"

interface CreatePollButtonProps {
    className?: string
}

export function CreatePollButton({className}: CreatePollButtonProps) {
    return (
        <Dialog>
            <DialogTrigger asChild>
                <Button className={cn("gap-2", className)}>
                    <Plus className="h-4 w-4"/>
                    Criar Enquete
                </Button>
            </DialogTrigger>
            <CreatePollDialog/>
        </Dialog>
    );
}

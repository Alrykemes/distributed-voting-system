"use client";

import {
    DialogContent,
    DialogDescription,
    DialogHeader,
    DialogTitle,
} from "@/components/ui/dialog";
import { CreatePollForm } from "@/components/create-poll/create-poll-form";
import React from "react";

export function CreatePollDialog(): React.ReactNode {
    return (
        <DialogContent>
            <DialogHeader>
                <DialogTitle>Criar Nova Enquete</DialogTitle>
                <DialogDescription>
                    Crie uma enquete para que a comunidade possa votar e expressar sua opinião.
                </DialogDescription>
            </DialogHeader>
            <CreatePollForm />
        </DialogContent>
    );
}

"use client";

import { InputField } from "@/components/form/input-field";
import { Control } from "react-hook-form";
import { Button } from "@/components/ui/button";
import { X } from "lucide-react";
import { CreatePollSchemaType } from "@/types/create-poll";
import React from "react";

interface PollOptionFieldProps {
    control: Control<CreatePollSchemaType>;
    index: number;
    onRemoveAction: () => void;
    disableRemove: boolean;
}

export function PollOptionField({
    control,
    index,
    onRemoveAction,
    disableRemove
}: PollOptionFieldProps): React.ReactNode {
    const name = `options.${index}.text` as const;

    return (
        <div className="flex gap-2 items-center">
            <InputField
                 control={control}
                 name={name}
                 label={`Opção ${index + 1}`}
                 placeholder={`Opção ${index + 1}`}
            />
            <Button
                type="button"
                onClick={onRemoveAction}
                disabled={disableRemove}
                title="Remover opção"
                className="h-9"
            >
                <X className="w-4 h-4" />
            </Button>
        </div>
    );
}
"use client";

import {FormControl, FormDescription, FormField, FormItem, FormLabel, FormMessage} from "@/components/ui/form";
import {Input} from "@/components/ui/input";
import {Control, Path} from "react-hook-form";
import React from "react";
import {CreatePollSchemaType} from "@/types/create-poll";

export interface InputFieldProps {
    control: Control<CreatePollSchemaType>;
    name: Path<CreatePollSchemaType>;
    label: string;
    placeholder?: string;
    type?: string;
    maxLength?: number
}

export function InputField({
     control,
     name,
     label,
     placeholder,
     type = "text",
    maxLength = 50
}: InputFieldProps) {
    return (
        <FormField
            control={control}
            name={name}
            render={({ field }) => {
                const { value, ...fieldWithoutValue } = field;
                return (
                    <FormItem>
                        <FormLabel>{label}</FormLabel>
                        <FormControl>
                            <Input
                                {...fieldWithoutValue}
                                value={typeof value === "string" ? value : ""}
                                type={type}
                                maxLength={maxLength}
                                placeholder={placeholder}
                            />
                        </FormControl>
                        <FormDescription>
                            {String(value ?? "").length}/{maxLength} caracteres.
                        </FormDescription>
                        <FormMessage />
                    </FormItem>
                );
            }}
        />
    );
}

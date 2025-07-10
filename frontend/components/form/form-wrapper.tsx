"use client";

import { Form } from "@/components/ui/form";
import { FieldValues, SubmitHandler, UseFormReturn } from "react-hook-form";
import React from "react";

interface FormWrapperProps<T extends FieldValues> {
    form: UseFormReturn<T>;
    onSubmitAction: SubmitHandler<T>;
    children: React.ReactNode;
    className?: string;
}

export default function FormWrapper<T extends FieldValues>({
     form,
     onSubmitAction,
     children,
     className,
}: FormWrapperProps<T>): React.ReactNode {
    return (
        <Form {...form}>
            <form onSubmit={form.handleSubmit(onSubmitAction)} className={className}>
                {children}
            </form>
        </Form>
    );
}
"use client";

import {Form, FormControl, FormDescription, FormField, FormItem, FormLabel, FormMessage} from "@/components/ui/form";
import {useCreatePollForm} from "@/hooks/useCreatePollForm";
import {CreatePollSchemaType} from "@/types/create-poll";
import {api} from "@/lib/api";
import {Input} from "@/components/ui/input";
import {useState} from "react";
import {Textarea} from "@/components/ui/textarea";
import {Button} from "@/components/ui/button";
import { toast } from "sonner"

export function CreatePollForm() {
    const [isLoading, setIsLoading] = useState(false);

    const form = useCreatePollForm();

    async function onSubmit(data: CreatePollSchemaType) {
        try {
            setIsLoading(true);
            const response = await api.post("polls/create", data)
            if (response.status === 201) {
                toast.success("Enquete criada com sucesso");
                form.reset();
            } else {
                toast.error("Ocorreu um erro ao criar sua enquete");
            }
        } catch (error) {
            toast.error("Erro inesperado");
        } finally {
            setIsLoading(false);
        }
    }

    return (
        <Form {...form}>
            <form onSubmit={form.handleSubmit(onSubmit)} className="space-y-8">
                <FormField
                    control={form.control}
                    name="title"
                    render={({field}) => (
                        <FormItem>
                            <FormLabel>Título da enquete</FormLabel>
                            <FormControl>
                                <Input
                                    placeholder="Pizza vs Hamburguer"
                                    {...field}
                                />
                            </FormControl>
                            <FormDescription>
                                {field.value?.length || 0}/100 caracteres.
                            </FormDescription>
                            <FormMessage/>
                        </FormItem>
                    )}
                />
                <FormField
                    control={form.control}
                    name="description"
                    render={({field}) => (
                        <FormItem>
                            <FormLabel>Descrição (Opcional)</FormLabel>
                            <FormControl>
                                <Textarea
                                    className="resize-none"
                                    placeholder="Adione mais contexto a sua enquete"
                                    {...field}
                                />
                            </FormControl>
                            <FormDescription>
                                {field.value?.length || 0}/500 caracteres.
                            </FormDescription>
                            <FormMessage/>
                        </FormItem>
                    )}
                />
                <Button type="submit" disabled={isLoading} className="h-12 w-full text-center">
                    {isLoading ? "Criando..." : "Criar Enquete"}
                </Button>
            </form>
        </Form>
    );
}
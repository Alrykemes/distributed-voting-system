"use client";

import {useCreatePollForm} from "@/hooks/useCreatePollForm";
import {CreatePollSchemaType} from "@/types/create-poll";
import {api} from "@/lib/api";
import {useState} from "react";
import {toast} from "sonner"
import FormWrapper from "@/components/form/form-wrapper";
import {InputField} from "@/components/form/input-field";
import {TextAreaField} from "@/components/form/text-area-field";
import {Button} from "@/components/ui/button";
import {useFieldArray} from "react-hook-form";
import {Label} from "@/components/label";
import {PollOptionField} from "@/components/form/poll-option-field";
import {Plus} from "lucide-react";

export function CreatePollForm() {
    const [isLoading, setIsLoading] = useState(false);
    const form = useCreatePollForm();

    const { control } = form;

    const { fields, append, remove } = useFieldArray({
        control,
        name: "options",
    })

    async function onSubmit(data: CreatePollSchemaType): Promise<void> {
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
        <FormWrapper form={form} onSubmitAction={onSubmit} className="space-y-8">
            <InputField control={form.control} name="title" label="Título da enquete"
                        placeholder="Pizza vs Hamburguer." maxLength={100}/>
            <TextAreaField control={form.control} name="description" label="Descrição (Opcional)"
                           placeholder="Adione mais contexto a sua enquete."/>
            <div className="space-y-4">
                <Label label="Opções"/>
                {fields.map((field, index) => (
                    <PollOptionField control={form.control}
                        index={index}
                        onRemoveAction={() => remove(index)}
                        disableRemove={fields.length <= 2}
                    />
                ))}
                <Button
                    type="button"
                    variant="outline"
                    size="sm"
                    onClick={() => append({ text: "" })}
                    disabled={fields.length >= 4}
                    className="gap-2"
                >
                    <Plus className="h-4 w-4" />
                    Adicionar opção
                </Button>
            </div>
            <Button type="submit" disabled={isLoading} className="h-12 w-full text-center">
                {isLoading ? "Criando..." : "Criar Enquete"}
            </Button>
        </FormWrapper>
    );
}
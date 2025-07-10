"use client";

import {FormControl, FormDescription, FormField, FormItem, FormLabel, FormMessage} from "@/components/ui/form";
import {Textarea} from "@/components/ui/textarea"
import {InputFieldProps} from "@/components/form/input-field";

export function TextAreaField({
      control,
      name,
      label,
      placeholder,
}: InputFieldProps) {
    return (
        <FormField
            control={control}
            name={name}
            render={({field}) => {
               const { value, ...fieldWithoutValue } = field;
               return (<FormItem>
                    <FormLabel>{label}</FormLabel>
                    <FormControl>
                        <Textarea
                            {...fieldWithoutValue}
                            value={typeof value === "string" ? value : ""}
                            maxLength={500}
                            className="resize-none"
                            placeholder={placeholder}
                        />
                    </FormControl>
                    <FormDescription>
                        {String(field.value ?? "").length}/500 caracteres.
                    </FormDescription>
                    <FormMessage/>
                </FormItem>)
            }}
        />
    );
}
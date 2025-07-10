import { useForm } from "react-hook-form";
import { CreatePollSchemaType } from "@/types/create-poll";
import { zodResolver } from "@hookform/resolvers/zod";
import { CreatePollSchema } from "@/schemas/create-poll";

export const useCreatePollForm = () => {
    return useForm<CreatePollSchemaType>({
        resolver: zodResolver(CreatePollSchema),
        defaultValues: {
            title: "",
            description: "",
            options: [{ text: "" }, { text: "" }],
        }
    });
};
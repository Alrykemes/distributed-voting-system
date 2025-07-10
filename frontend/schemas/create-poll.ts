import {z} from "zod/v4"

export const CreatePollSchema = z.object({
    title: z.string().trim().min(5, "O título não pode estar vazio").max(100),
    description: z.string().trim().max(500),
    options: z.array(z.object({
        text: z.string().min(1, "A opção não pode estar vazia")
    })).min(2, "Adicione pelo menos duas opções")
});
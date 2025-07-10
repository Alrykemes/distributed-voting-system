import {z} from "zod/v4"

export const CreatePollSchema = z.object({
    title: z.string().trim().min(5).max(100),
    description: z.string().trim().max(500)
});
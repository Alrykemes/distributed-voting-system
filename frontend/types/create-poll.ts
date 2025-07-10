import { CreatePollSchema } from "@/schemas/create-poll";
import { z } from "zod/v4";

export type CreatePollSchemaType = z.infer<typeof CreatePollSchema>;
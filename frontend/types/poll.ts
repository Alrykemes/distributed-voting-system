import { PollOption } from "./optionPoll";
import { Owner } from "./owner";

export type PollType = {
    id: string;
    title: string;
    description?: string;
    options: PollOption[];
    owner: Owner;
}
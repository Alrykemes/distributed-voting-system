import { PollOption } from "./optionPoll";
import { Owner } from "./owner";

export type PollType = {
    title: string;
    description?: string;
    options: PollOption[];
    owner: Owner;
}
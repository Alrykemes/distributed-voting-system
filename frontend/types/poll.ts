import { PollOption } from "./optionPoll";

export type PollType = {
    id: string;
    title: string;
    ownerId: string;
    ownerName: string;
    ownerPhoto: string;
    description?: string;
    options: PollOption[];
}
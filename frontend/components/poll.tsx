"use client";

import { Card, CardContent, CardDescription, CardHeader, CardTitle } from "@/components/ui/card";
import { Users } from "lucide-react";
import { MyLabel } from "@/components/my-label";
import React from "react";

interface PollOption {
    id: string;
    text: string;
    votes: number;
}

interface PollProps {
    title: string;
    description?: string;
    options: PollOption[];
}

export function Poll( { title, description, options }: PollProps): React.ReactNode {
    const totalVotes: number = options.reduce((acc: number, option: PollOption): number => {
        return acc + option.votes;
    }, 0);

    return (
        <Card>
            <CardHeader>
                <CardTitle>{title}</CardTitle>
                {description && <CardDescription>{description}</CardDescription>}
            </CardHeader>
            <CardContent>
                <div className="flex gap-2 items-center justify-end p-2">
                    <Users className="w-4 h-4"/>
                    <MyLabel label={String(totalVotes)}/>
                </div>
                {options.map((option: PollOption, index: number): React.ReactNode => {
                    const percentage: number = totalVotes > 0 ? Math.round((option.votes / totalVotes) * 100) : 0;
                    return (
                        <div
                            key={index}
                            className="w-full flex justify-between rounded-md border px-4 py-3 mb-2 text-sm hover:bg-accent transition-colors cursor-pointer"
                        >
                            {option.text}
                            <span>{`${percentage}% (${option.votes})`}</span>
                        </div>
                    );
                })}
            </CardContent>
        </Card>
    );
}
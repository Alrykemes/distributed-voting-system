"use client";

import { InternalHeader } from "@/components/header/internal-header";
import { Poll } from "@/components/poll";
import { TrendingUp } from "lucide-react";
import { MyLabel } from "@/components/my-label";
import React, { useEffect, useState } from "react";
import { useRouter, useSearchParams } from "next/navigation";
import { PollType } from "@/types/poll";
import { api } from "@/lib/api";
import { PollOption } from "@/types/optionPoll";

export default function Polls(): React.ReactNode {

    const searchParams = useSearchParams();
    const queryToken = searchParams.get('token');
    const router = useRouter();

    useEffect(() => {
        const storageToken = localStorage.getItem('auth-token');

        if (queryToken) {
            localStorage.setItem("auth-token", queryToken);
            router.replace('/polls', undefined);
        }

        if (!storageToken) {
            router.push("/")
        }

        setTimeout(() => {
            fetchTrendsPolls();
        }, 300)
    }, [router])

    const [getTrends, setGetTrends] = useState<boolean>(false);
    const [trendsPolls, setTrendsPolls] = useState<PollType[]>([]);

    const fetchTrendsPolls = async () => {
        const res = await api.get("/polls/get-trends")
        console.log(res.data);
        setTrendsPolls(res.data);
        setGetTrends(true);
    }

    useEffect(() => {
        console.log(trendsPolls);
        // mock poll options
        trendsPolls.map((poll) => {
            const option1: PollOption = {id: "1", text: "Yes", votes: 5}
            const option2: PollOption = {id: "1", text: "No", votes: 3}
            poll.options = [];
            poll.options.push(option1)
            poll.options.push(option2)
        })
    }, [getTrends])

    return (<div>
        <InternalHeader />
        <main>
            <section className="px-8 py-10 flex flex-col items-center justify-center">
                <div className="flex items-center gap-3 mb-6">
                    <TrendingUp className="h-6 w-6 text-green-500" />
                    <h2 className="text-2xl font-bold text-foreground">Mais Populares</h2>
                    <MyLabel label="As enquetes mais populares do momento."></MyLabel>
                </div>
                <div className="grid grid-cols-1 sm:grid-cols-2 md:grid-cols-3 lg:grid-cols-3 gap-8 w-full max-w-7xl">
                    {trendsPolls.map((poll: PollType) => (
                        <Poll
                            owner={poll.owner}
                            title={poll.title}
                            description={poll.description}
                            options={poll.options}
                        />
                    ))}
                </div>
            </section>
        </main>
    </div>);
}
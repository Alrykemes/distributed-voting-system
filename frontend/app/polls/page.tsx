"use client";

import { InternalHeader } from "@/components/header/internal-header";
import { Poll } from "@/components/poll";
import { TrendingUp } from "lucide-react";
import { MyLabel } from "@/components/my-label";
import React, { useEffect, useRef, useState } from "react";
import { useRouter, useSearchParams } from "next/navigation";
import { PollType } from "@/types/poll";
import { api } from "@/lib/api";
import { PollOption } from "@/types/optionPoll";
import { tr } from "zod/v4/locales";

export default function Polls(): React.ReactNode {

    const searchParams = useSearchParams();
    const queryToken = searchParams.get('token');
    const router = useRouter();
    
    const [logged, setLogged] = useState<boolean>(false);
    const isFirstRender = useRef(true)
    
    useEffect(() => {
        if (queryToken) {
            localStorage.setItem("auth-token", queryToken);
            router.replace('/polls', undefined);
            setLogged(true);
        }
        
        const storageToken = localStorage.getItem('auth-token');

        if (!storageToken) {
            router.push("/");
        } else {
            setLogged(true);
        }
    }, [router])

    const [trendsPolls, setTrendsPolls] = useState<PollType[]>([]);

    const fetchTrendsPolls = async () => {
        const res = await api.get("/polls/trends")
        setTrendsPolls(res.data);
    }

    useEffect(() => {
        if (isFirstRender.current) {
            isFirstRender.current = false;
            return;
        }

        if(logged) {
            fetchTrendsPolls();
        }
    }, [logged])

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
                    {trendsPolls.map((poll: PollType, index: number) => (
                        <Poll
                            key={index}
                            id={poll.id}
                            ownerId={poll.ownerId}
                            ownerName={poll.ownerName}
                            ownerPhoto={poll.ownerPhoto}
                            title={poll.title}
                            description={poll.description}
                            options={poll.options}/>
                    ))}
                </div>
            </section>
        </main>
    </div>);
}
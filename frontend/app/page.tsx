import {Header} from "@/components/header/header";
import {InfoCard} from "@/components/info-card";
import {BarChart3, LogIn, Users, Vote} from "lucide-react";
import {Button} from "@/components/ui/button";
import Link from "next/link";

export default function Home() {
    return (
        <main className="min-h-screen">
            <Header/>
            <div className="flex flex-col justify-center items-center gap-20 py-20 px-4 text-center">
                <div className="flex flex-col items-center gap-4">
                    <h1 className="text-4xl md:text-6xl font-bold">Sua voz importa.</h1>
                    <h2 className="text-lg md:text-2xl text-zinc-500">
                        Crie enquetes, vote em tempo real e veja o que a comunidade pensa.
                    </h2>
                </div>

                <div className="grid grid-cols-1 sm:grid-cols-2 md:grid-cols-3 gap-6 w-full max-w-6xl">
                    <InfoCard
                        icon={<BarChart3/>}
                        title="Votação em Tempo Real"
                        content="Veja os resultados atualizarem instantaneamente conforme as pessoas votam."
                    />
                    <InfoCard
                        icon={<Users/>}
                        title="Comunidade Ativa"
                        content="Conecte-se com milhares de usuários e participe de discussões relevantes."
                    />
                    <InfoCard
                        icon={<Vote/>}
                        title="Criação Simples"
                        content="Crie enquetes personalizadas em segundos e compartilhe com a comunidade."
                    />
                </div>

                <Link href="/polls">
                    <Button className="flex h-12 gap-2 px-6 items-center">
                        <LogIn className="w-5 h-5"/>
                        <span>Entrar com Google</span>
                    </Button>
                </Link>
            </div>
        </main>
    );
}

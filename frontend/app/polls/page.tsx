import {InternalHeader} from "@/components/header/internal-header";
import {Poll} from "@/components/poll";
import {TrendingUp} from "lucide-react";
import {Label} from "@/components/label";

export default function Polls() {
    return (<div>
        <InternalHeader/>
        <main>
            <section className="px-8 py-10 ">
                <div className="flex items-center gap-3 mb-6">
                    <TrendingUp className="h-6 w-6 text-green-500"/>
                    <h2 className="text-2xl font-bold text-foreground">Mais Populares</h2>
                    <Label label="As enquetes mais populares do momento."></Label>
                </div>
                <div className="grid grid-cols-1 sm:grid-cols-2 md:grid-cols-3 lg:grid-cols-4 gap-8 w-full max-w-7xl">
                    <Poll title="Devemos implementar trabalho remoto permanente?"
                          description="Sendo a internet o maior meio de comunição, entretenimento,
                       etc, se faz necessário uma migração para o trbalho remote.  Sendo a internet o maior meio de comunição, entretenimento,
                       etc, se faz necessário uma migração para o trbalho remote.
                       Sendo a internet o maior meio de comunição, entretenimento,
                       etc, se faz necessário uma migração para o trbalho remote."
                          options={["teste1", "teste2", "teste3"]}
                    />
                    <Poll title="Devemos implementar trabalho remoto permanente?"
                          description="Sendo a internet o maior meio de comunição, entretenimento,
                       etc, se faz necessário uma migração para o trbalho remote.  Sendo a internet o maior meio de comunição, entretenimento,
                       etc, se faz necessário uma migração para o trbalho remote.
                       Sendo a internet o maior meio de comunição, entretenimento,
                       etc, se faz necessário uma migração para o trbalho remote."
                          options={["teste1", "teste2", "teste3"]}
                    />
                    <Poll title="Devemos implementar trabalho remoto permanente?"
                          description="Sendo a internet o maior meio de comunição, entretenimento,
                       etc, se faz necessário uma migração para o trbalho remote.  Sendo a internet o maior meio de comunição, entretenimento,
                       etc, se faz necessário uma migração para o trbalho remote.
                       Sendo a internet o maior meio de comunição, entretenimento,
                       etc, se faz necessário uma migração para o trbalho remote."
                          options={["teste1", "teste2", "teste3"]}
                    />
                    <Poll title="Devemos implementar trabalho remoto permanente?"
                          description="Sendo a internet o maior meio de comunição, entretenimento,
                       etc, se faz necessário uma migração para o trbalho remote.  Sendo a internet o maior meio de comunição, entretenimento,
                       etc, se faz necessário uma migração para o trbalho remote.
                       Sendo a internet o maior meio de comunição, entretenimento,
                       etc, se faz necessário uma migração para o trbalho remote."
                          options={["teste1", "teste2", "teste3"]}
                    />
                </div>
            </section>
        </main>
    </div>);
}
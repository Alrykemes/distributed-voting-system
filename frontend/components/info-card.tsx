import {Card, CardContent, CardHeader, CardTitle} from "@/components/ui/card";
import React from "react";

interface InfoCardProps {
    icon: React.ReactElement<React.SVGProps<SVGElement>>;
    title: string;
    content: string;
}


export function InfoCard({ icon, title, content }: InfoCardProps) {
    const styledIcon = React.cloneElement(icon, {
        className: "h-10 w-10 text-primary mx-auto",
    });

    return (
        <Card className="text-center">
            <CardHeader className="flex flex-col items-center gap-2">
                {styledIcon}
                <CardTitle>
                    {title}
                </CardTitle>
            </CardHeader>
            <CardContent className="text-zinc-500">
                <p className="text-muted-foreground">{content}</p>
            </CardContent>
        </Card>
    );
}
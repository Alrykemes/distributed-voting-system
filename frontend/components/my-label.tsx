import { Label as Lb } from "@/components/ui/label";
import React from "react";

interface LabelProps {
    label: string;
}

export function MyLabel({ label }: LabelProps): React.ReactNode {
    return <Lb className="text-sm font-medium text-muted-foreground">{label}</Lb>
}
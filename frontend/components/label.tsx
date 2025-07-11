import { Label as Lb } from "@/components/ui/label";

interface LabelProps {
    label: string;
}

export function Label({ label }: LabelProps) {
    return <Lb className="text-sm font-medium text-muted-foreground">{label}</Lb>
}
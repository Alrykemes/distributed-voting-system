"use client";

import {Button} from "@/components/ui/button";
import {LogOut} from "lucide-react";

interface LogoutButtonProps {
    onLogoutAction: () => void;
}

export function LogoutButton({onLogoutAction}: LogoutButtonProps) {
    return (
        <Button onClick={onLogoutAction}>
            <LogOut className="h-4 w-4"/>
        </Button>
    );
}
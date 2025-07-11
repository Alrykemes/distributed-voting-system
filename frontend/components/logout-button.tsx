"use client";

import { Button } from "@/components/ui/button";
import { LogOut } from "lucide-react";
import React from "react";

interface LogoutButtonProps {
    onLogoutAction: () => void;
}

export function LogoutButton({onLogoutAction}: LogoutButtonProps): React.ReactNode {
    return (
        <Button onClick={onLogoutAction}>
            <LogOut className="h-4 w-4"/>
        </Button>
    );
}
"use client";

import {Search} from "lucide-react";
import {Input} from "@/components/ui/input";
import React from "react";

interface SearchInputProps {
    placeholder?: string;
    value?: string;
    onChange?: (e: React.ChangeEvent<HTMLInputElement>) => void;
}

export function SearchInput({ placeholder = "Pesquisar...", value, onChange}: SearchInputProps) {
    return (
        <div className="relative w-full sm:max-w-md md:max-w-lg lg:max-w-xl">
            <Search className="absolute left-3 top-1/2 -translate-y-1/2 h-4 w-4 text-muted-foreground"/>
            <Input
                id="search"
                type="text"
                placeholder={placeholder}
                className="pl-9"
                value={value}
                onChange={onChange}
            />
        </div>
    );
}

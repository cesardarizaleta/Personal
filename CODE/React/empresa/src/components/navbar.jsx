import React from "react";
import './navbar.css';

export default function Navbar() {
    return (
        <nav className="bg-blue-400 w-fit text-white font-bold fixed top-0 rounded-xl overflow-hidden shadow-xl">
            <ul className="flex justify-around items-center h-full w-full">
                <li className="transition-all duration-500 w-full text-center p-2 px-4 hover:bg-blue-300 cursor-pointer
                "><a href="/">Home</a></li>
                <li className="transition-all duration-500 w-full text-center p-2 px-4 hover:bg-blue-300 cursor-pointer"
                ><a href="/">About</a></li>
            </ul>
        </nav>
    )
}
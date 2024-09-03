import React from "react";
import './navbar.css';

export default function Navbar() {
    return (
        <nav className=" w-fit text-white font-bold fixed rounded-xl overflow-hidden shadow-xl">
            <ul className="flex justify-around bg-blue-400 items-center h-full w-full">
                <li className="transition-all duration-500 text-center p-2 px-4 hover:bg-blue-300 cursor-pointer
                ">+</li>
                <li className="transition-all bg-red-300 duration-500 w-full text-center p-2 px-4 hover:bg-red-400 cursor-pointer"
                >-</li>
            </ul>
        </nav>
    )
}
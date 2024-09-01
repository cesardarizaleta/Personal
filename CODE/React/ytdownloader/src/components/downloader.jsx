import React from "react";
import './downloader.css';

export default function Downloader() {

    function download(e) {
        e.preventDefault();
    }

    return (
        <form className='flex gap-4 flex-wrap' onSubmit={download} action=''>
            <input className='outline-none px-4 rounded-full p-3 bg-transparent' type='text' placeholder='Enter URL' />
            <button className='p-3 px-4 transition-all duration-500
            hover:bg-white hover:text-[#0e4166] rounded-full font-bold'>Download</button>
        </form>
    )
}
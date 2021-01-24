import axios from 'axios';

export const api = axios.create({
    //URL with embedded h2 database
    // baseURL: "https://roiim-assignment-boot.herokuapp.com",

    //URL with PostgreSQL
    baseURL:"https://roiim-boot-database.herokuapp.com/",
    withCredentials: false,
    headers: {
        'Access-Control-Allow-Origin' : '*',
        'Access-Control-Allow-Methods':'GET,PUT,POST,DELETE,PATCH,OPTIONS',   
    }
});
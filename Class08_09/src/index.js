// Print en Javascript
//console.log("Bienvenidos a la clase 8 de Node");
//console.log("Otro");

// Creación del backend con express
const express=require('express');
const app= express();
const {server}=require("./config/config");
const cors = require('cors');
const cookies=require('cookie-parser');


const productRoutes=require('./routes/store');
const invalidRoutes=require('./routes/404');

app.use(cors({
    origin:true,
    credentials:true
}));

app.use(cookies());

app.use(express.json());

app.use(productRoutes);
app.use(invalidRoutes);

app.listen(server.port,()=>{
    console.log("Server running on port: "+server.port);
})



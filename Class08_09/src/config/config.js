const dotenv = require('dotenv');
dotenv.config();

module.exports={
    server:{
        port:process.env.PORT
    },
    adminData:{
        username:process.env.USERSTORE,
        password:process.env.PASSWORD
    }
}


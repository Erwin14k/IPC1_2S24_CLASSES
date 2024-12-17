const express = require('express');

const router=express.Router();

router.use((req,res,next)=>{
    res.status(404).json({
        message:"Invalid endpoint"
    })
})

module.exports=router;

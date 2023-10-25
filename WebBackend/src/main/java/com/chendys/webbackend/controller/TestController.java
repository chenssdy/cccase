package com.chendys.webbackend.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/test")
public class TestController {

    private final Logger logger = LoggerFactory.getLogger(TestController.class);


    @ResponseBody
    @PostMapping()
    public String test(@RequestBody String pswd){
        logger.info(pswd);
        return pswd;
    }
}

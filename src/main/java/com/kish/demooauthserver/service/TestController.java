package com.kish.demooauthserver.service;


import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @GetMapping("/user/{userName}")
    public String helloString(@PathVariable(name = "userName") String userName){
        if(StringUtils.isEmpty(userName)){
            userName = "Guest ";
        }
        return String.format("Hello World for User : {%s}",userName);
    }
}

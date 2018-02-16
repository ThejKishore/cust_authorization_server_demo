package com.kish.demooauthserver.service;


import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;


@RestController
@Slf4j
public class UserServiceController {

    @GetMapping("/user/info")
    public Principal getUser(Principal principal){
        log.info(" User details {}",principal.getName());
        return  principal;
    }
}

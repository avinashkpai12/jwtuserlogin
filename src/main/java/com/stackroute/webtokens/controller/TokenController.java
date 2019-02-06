package com.stackroute.webtokens.controller;


import com.stackroute.webtokens.model.User;
import com.stackroute.webtokens.security.JwtGenerator;
import com.stackroute.webtokens.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/token/")
public class TokenController {

    private JwtGenerator jwtGenerator;

    private UserServiceImpl userServiceImpl;

    @Autowired
    public TokenController(JwtGenerator jwtGenerator, UserServiceImpl userServiceImpl) {
        this.jwtGenerator = jwtGenerator;
        this.userServiceImpl = userServiceImpl;
    }

    @PostMapping("login")
    public String generator(@RequestBody final User user) {

        String token = "";
        if(userServiceImpl.verifyUser(user.getUserName())){
            token = jwtGenerator.generate(user);
        }
        else{
            token = "Error";
        }
       return token;
    }
}

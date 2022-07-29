package com.example.CartiqueMySQL.controller;

import com.example.CartiqueMySQL.entity.Client;
import com.example.CartiqueMySQL.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value="/", consumes = MediaType.APPLICATION_JSON_VALUE)
@CrossOrigin(origins = "*")
public class AuthController {

    @Autowired
    AuthService authService;


    @PostMapping(value="/login")
    public Client login(@RequestBody Client client)
    {
        System.out.println("reojefc");
        String email = client.getEmail();
        String password = client.getPassword();
        return authService.login(email,password);
    }

    @RequestMapping(value = "/signup", method = RequestMethod.POST)
    public Client register(@RequestBody Client client)
    {
        System.out.print("trigerred");
        return authService.signup(client);
    }
}

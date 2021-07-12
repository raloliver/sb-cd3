package com.raloliver.sbcd3.controllers;

import com.raloliver.sbcd3.models.Client;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/clients")
public class ClientController {

    @GetMapping("/sample")
    public Client getClient() {
        return new Client(28, "Ana", "999.999.999-99");
    }
}

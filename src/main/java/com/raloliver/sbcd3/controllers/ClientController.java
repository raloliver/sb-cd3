package com.raloliver.sbcd3.controllers;

import com.raloliver.sbcd3.models.Client;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
@RequestMapping("/clients")
public class ClientController {

    @GetMapping("/sample")
    public Client getClient() {
        return new Client(28, "Ana", "999.999.999-99");
    }

    @GetMapping("/{id}")
    public Client getClientById(@PathVariable int id) {
        return new Client(id, "Maria", "000.000.000-00");
    }

    @GetMapping("")
    public Client getClientByIdWithParams(@RequestParam(name = "id", defaultValue = "1") int id) {
        return new Client(id, "João da Silva", "123.456.789-99");
    }

}

package com.raloliver.sbcd3.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/calc")
public class CalculatorController {

    @GetMapping("/sum/{a}/{b}")
    public int sum(@PathVariable int a, @PathVariable int b) {
        return a + b;
    }

    /**
     * No @RequestParam é possível inserir um valor padrão e também definir se o
     * mesmo é obrigatório ou não. Por padrão é obrigatório.
     * 
     * @param a
     * @param b
     * @return
     */
    @GetMapping("/sub")
    public int sub(@RequestParam(name = "a") int a, @RequestParam(name = "b") int b) {
        return a - b;
    }
}

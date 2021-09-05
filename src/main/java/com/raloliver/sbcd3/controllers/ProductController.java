package com.raloliver.sbcd3.controllers;

import javax.validation.Valid;

import com.raloliver.sbcd3.models.entities.Product;
import com.raloliver.sbcd3.models.repositories.ProductRespository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    @Autowired
    private ProductRespository productRespository;

    /**
     * Em vez disso RequestParam String name, RequestParam double price,
     * RequestParam double discount, utilize a interface.
     * 
     * @Valid para aplicar as validações criadas no modelo para o Product.
     * 
     * @return
     */
    @PostMapping()
    public @ResponseBody Product addProduct(@Valid Product product) {
        productRespository.save(product);

        return product;
    }
}

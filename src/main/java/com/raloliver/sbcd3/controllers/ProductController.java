package com.raloliver.sbcd3.controllers;

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
     * @return
     */
    @PostMapping()
    public @ResponseBody Product addProduct(Product product) {
        productRespository.save(product);

        return product;
    }
}

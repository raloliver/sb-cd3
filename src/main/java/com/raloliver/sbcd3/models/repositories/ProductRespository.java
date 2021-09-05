package com.raloliver.sbcd3.models.repositories;

import com.raloliver.sbcd3.models.entities.Product;

import org.springframework.data.repository.CrudRepository;

public interface ProductRespository extends CrudRepository<Product, Integer> {
    
}

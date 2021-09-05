package com.raloliver.sbcd3.models.repositories;

import com.raloliver.sbcd3.models.entities.Product;

import org.springframework.data.repository.PagingAndSortingRepository;

public interface ProductRespository extends PagingAndSortingRepository<Product, Integer> {
    
}

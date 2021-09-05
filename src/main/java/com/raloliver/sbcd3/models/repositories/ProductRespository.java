package com.raloliver.sbcd3.models.repositories;

import com.raloliver.sbcd3.models.entities.Product;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

public interface ProductRespository extends PagingAndSortingRepository<Product, Integer> {

    // Tenha atenção ao padrão de convenção.
    // findByAttributeContaining
    // findByAttributeIsContaining
    // findByAttributeContains
    // findByAttributeStartsWith
    // findByAttributeEndsWith
    // findByAttributeNotContaining

    public Iterable<Product> findByNameContainingIgnoreCase(String pieceName);

    /**
     * É possível também realizar queries diretamente
     * 
     * @Query("SELECT p FROM Product p WHERE p.name LIKE %:name%")
     */

    @Query("SELECT p FROM Product p WHERE p.name LIKE %:name%")
    public Iterable<Product> searchByNameLike(@Param("name") String name);

}

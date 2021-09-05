package com.raloliver.sbcd3.controllers;

import java.util.Optional;

import javax.validation.Valid;

import com.raloliver.sbcd3.models.entities.Product;
import com.raloliver.sbcd3.models.repositories.ProductRespository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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
     * @RequestMapping() com essa anotação possível utilizar o mesmo metodo para
     *                   adicionar e para alterar o item.
     * 
     * @Valid para aplicar as validações criadas no modelo para o Product.
     */
    // @PostMapping
    @RequestMapping(method = { RequestMethod.POST, RequestMethod.PUT })
    public @ResponseBody Product saveProduct(@Valid Product product) {
        productRespository.save(product);

        return product;
    }

    @GetMapping
    public Iterable<Product> getProducts() {
        return productRespository.findAll();
    }

    // Tenha atenção ao padrão de convenção.
    // findByAttributeContaining
    // findByAttributeIsContaining
    // findByAttributeContains
    // findByAttributeStartsWith
    // findByAttributeEndsWith
    // findByAttributeNotContaining

    @GetMapping(path = "/name/{pieceName}")
    public Iterable<Product> getProductsByName(@PathVariable String pieceName) {
        return productRespository.findByNameContainingIgnoreCase(pieceName);
    }

    /**
     * #TODO definir um valor padrão (ou deixar como opcional) o parâmetro qtty
     */
    @GetMapping(path = "/page/{pageNumber}/{qtty}")
    public Iterable<Product> getProductsByPage(@PathVariable int pageNumber, @PathVariable int qtty) {
        if (qtty >= 5) {
            qtty = 5;
        }
        Pageable page = PageRequest.of(pageNumber, qtty);
        return productRespository.findAll(page);
    }

    /**
     * @Optional pois o produto pode existir ou não e caso seja realizada uma
     *           requisição para um ID inexistente, será retornado null (com status
     *           200).
     */
    @GetMapping(path = "/{id}")
    public Optional<Product> getProductById(@PathVariable int id) {
        return productRespository.findById(id);
    }

    /**
     * O mesmo método (save) é utilizado para salvar e para atualizar.
     */
    // @PutMapping
    // public Product updateProduct(@Valid Product product) {
    // productRespository.save(product);

    // return product;
    // }

    /**
     * #TODO implementar soft delete
     */
    @DeleteMapping(path = "/{id}")
    public void removeProduct(@PathVariable int id) {
        productRespository.deleteById(id);
    }

}

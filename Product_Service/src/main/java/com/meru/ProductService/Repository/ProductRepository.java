package com.meru.ProductService.Repository;

import org.springframework.data.repository.CrudRepository;

import com.meru.ProductService.Model.Product;

public interface ProductRepository extends CrudRepository<Product, Integer> {

}

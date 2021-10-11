package com.example.task1.repository;

import com.example.task1.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "list" , path = "product")
public interface ProductRepository extends JpaRepository<Product, Integer> {

}

package com.example.test.demo.Repositories;

import com.example.test.demo.Models.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product,Long> {

    List<Product> findByProductName( String productName);

}

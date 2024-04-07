package com.example.test.demo.Repositories;

import com.example.test.demo.Models.Product1;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface Product1Repository extends JpaRepository<Product1,Long> {
    List<Product1> findByName(String name);
}

package com.itgenius.springbootlayout.repository;

import com.itgenius.springbootlayout.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product,Integer> {
    
}
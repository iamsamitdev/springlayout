package com.itgenius.springbootlayout.controller.api;
import java.util.List;
import java.util.Optional;

import com.itgenius.springbootlayout.model.Product;
import com.itgenius.springbootlayout.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class ProductAPIController {
    
    @Autowired
    private ProductRepository productRepository;

    // Read All products
    @GetMapping("/products")
    public List<Product> findAll(){
        return productRepository.findAll();
    }

    // Read Product By ID
    @GetMapping("/product/{id}")
    public Optional<Product> findProductById(@PathVariable("id") Integer id){
        return productRepository.findById(id);
    }

    // Add new Product
    @PostMapping("/products")
    public Product create(@RequestBody Product product){
        return productRepository.save(product);
    }

    // Update Product
    @PutMapping("/product/{id}")
    public Product update(
        @PathVariable("id") Integer id, 
        @RequestBody Product productObject){

            Product product = productRepository.getOne(id);
            product.setProductName(productObject.getProductName());
            product.setProductPrice(productObject.getProductPrice());
            product.setProductQty(productObject.getProductQty());
            product.setProductStatus(productObject.getProductStatus());
            product.setProductImage(productObject.getProductImage());

            return productRepository.save(product);
    }

    // Delete Product
    @DeleteMapping("/product/{id}")
    public List<Product> delete(@PathVariable("id") Integer id){
        productRepository.deleteById(id);
        return productRepository.findAll();
    }
}
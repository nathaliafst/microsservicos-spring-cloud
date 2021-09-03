package com.dio.experts.productcatalog.service;

import com.dio.experts.productcatalog.model.Product;
import com.dio.experts.productcatalog.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService {

    ProductRepository productRepository;

    @Autowired
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public Product findById(String id){
        return productRepository.findById(id).orElse(null);
    }

    public void save(Product product){
        productRepository.save(product);
    }

    public List<Product> findAll(){
        List<Product> list = new ArrayList<>();
        Iterable it =  productRepository.findAll();
        it.forEach(x -> list.add((Product) x));
        return list;
    }
}

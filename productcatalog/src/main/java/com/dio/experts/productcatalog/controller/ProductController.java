package com.dio.experts.productcatalog.controller;

import com.dio.experts.productcatalog.model.Product;
import com.dio.experts.productcatalog.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/product")
public class ProductController {


    ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @RequestMapping(method = RequestMethod.POST)
    void create(@RequestBody Product product){
        productService.save(product);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    Product findById(@PathVariable String id)
    {
        return productService.findById(id);
    }

    @GetMapping
    List<Product> findAll(){
        return productService.findAll();
    }
}
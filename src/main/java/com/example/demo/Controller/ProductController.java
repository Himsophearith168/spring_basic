package com.example.demo.Controller;


import com.example.demo.DTO.ProductResponse;
import com.example.demo.Model.Product;
import com.example.demo.Service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;


@RestController
@RequestMapping("/api/product")
@RequiredArgsConstructor
public class ProductController {
    private final ProductService productService;
    @GetMapping
    ResponseEntity<Map> getProduct(){
        var product = productService.getAll();
        Map res = new HashMap();
        res.put("Total",product.size());
        res.put("Success",true);
        res.put("Message","Success");
        res.put("List",productService.getAll());
        return ResponseEntity.ok(res);
    }
    @GetMapping("/{id}")
    ResponseEntity<ProductResponse> getProductById(@PathVariable Long id) {
        return ResponseEntity.ok(productService.findById(id));
    }

    @PostMapping
    ResponseEntity<Product> createProduct(@RequestBody Product product){
        return ResponseEntity.status(201).body(productService.createProduct(product));
    }
    @PutMapping("/{id}")
    ResponseEntity<Product> updateProduct(@PathVariable Long id, @RequestBody Product product){
        return ResponseEntity.ok(productService.updateProduct(id, product));
    }
    @DeleteMapping("/{id}")
    ResponseEntity<ProductResponse> deleteProduct(@PathVariable Long id){
        productService.deleteProduct(id);
        return ResponseEntity.noContent().build();
    }
}

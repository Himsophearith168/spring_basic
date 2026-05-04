package com.example.demo.Controller;


import com.example.demo.Repository.ProductRepository;
import com.example.demo.Service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/product")
@RequiredArgsConstructor
public class ProductController {
    private final ProductService productService;
    @GetMapping
    ResponseEntity<Map> getProduct(){
        var product = productService.getall();
        Map res = new HashMap();
        res.put("Total",product.size());
        res.put("Success",true);
        res.put("Message","Success");
        res.put("List",productService.getall());
        return ResponseEntity.ok(res);
    }

}

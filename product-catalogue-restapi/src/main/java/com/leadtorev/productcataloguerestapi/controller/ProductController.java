package com.leadtorev.productcataloguerestapi.controller;

import com.leadtorev.productcataloguerestapi.model.Product;
import com.leadtorev.productcataloguerestapi.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController
{

        @Autowired
        private ProductService productService;

        @PostMapping("/addproduct")
        public ResponseEntity<Product> addProduct(@RequestBody Product product) {
            Product createdProduct = productService.addProduct(product);
            return new ResponseEntity<>(createdProduct, HttpStatus.CREATED);
        }

        @GetMapping("/{productId}")
        public ResponseEntity<Product> getProduct(@PathVariable String productId) {
            Product product = productService.getProduct(productId);
            return new ResponseEntity<>(product, HttpStatus.OK);
        }

        @PutMapping("/{productId}")
        public ResponseEntity<Product> updateProduct(@PathVariable String productId, @RequestBody Product product) {
            Product updatedProduct = productService.updateProduct(productId, product);
            return new ResponseEntity<>(updatedProduct, HttpStatus.OK);
        }

        @DeleteMapping("/{productId}")
        public ResponseEntity<Void> deleteProduct(@PathVariable String productId) {
            productService.deleteProduct(productId);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        @GetMapping("/search")
        public ResponseEntity<List<Product>> searchProducts(
                @RequestParam(required = false) String name,
                @RequestParam(required = false) String categories

        ) {
            List<Product> products = productService.searchProducts(name, categories);
            return new ResponseEntity<>(products, HttpStatus.OK);
        }
    }



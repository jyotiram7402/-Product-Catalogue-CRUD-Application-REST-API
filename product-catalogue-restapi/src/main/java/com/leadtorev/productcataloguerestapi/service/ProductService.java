package com.leadtorev.productcataloguerestapi.service;

import com.leadtorev.productcataloguerestapi.model.Product;
import com.leadtorev.productcataloguerestapi.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService
{
    @Autowired
    private ProductRepository productRepository;

    public Product addProduct(Product product) {
        return productRepository.save(product);
    }

    public Product getProduct(String productId) {
        return productRepository.findById(Integer.valueOf(productId)).orElse(null);
    }

    public Product updateProduct(String productId, Product updatedProduct) {
        return productRepository.save(updatedProduct);
    }

    public void deleteProduct(String productId) {

        productRepository.deleteById(Integer.valueOf(productId));
    }

    public List<Product> searchProducts(String name, String categories) {
        return productRepository.searchProducts(name, categories);
    }
}

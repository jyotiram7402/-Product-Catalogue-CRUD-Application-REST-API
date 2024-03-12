package com.leadtorev.productcataloguerestapi.repository;

import com.leadtorev.productcataloguerestapi.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product,Integer>
{
    @Query(
            value = "Select * from product p where p.name=:name And p.categories=:categories",
            nativeQuery = true
    )
    List<Product> searchProducts(String name, String categories);
}

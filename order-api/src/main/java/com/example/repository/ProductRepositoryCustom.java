package com.example.repository;

import com.example.domain.model.model.Product;

import java.util.List;

public interface ProductRepositoryCustom {
    List<Product> searchByName(String name);

}

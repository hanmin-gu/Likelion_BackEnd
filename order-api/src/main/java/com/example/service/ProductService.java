package com.example.service;

import com.example.domain.model.model.Product;
import com.example.domain.model.prodcut.AddProductForm;
import com.example.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepository productRepository;

    @Transactional
    public Product addProduct(Long memberId, AddProductForm form){
        return productRepository.save(Product.of(memberId, form));
    }
}

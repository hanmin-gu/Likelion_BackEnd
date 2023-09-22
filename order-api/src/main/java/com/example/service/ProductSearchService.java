package com.example.service;

import com.example.domain.model.model.Product;
import com.example.exception.CustomException;
import com.example.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.example.exception.ErrorCode.NOT_FOUND_PRODUCT;

@Service
@RequiredArgsConstructor
public class ProductSearchService {
    private final ProductRepository productRepository;

    public List<Product> searchByName(String name){

    }

    public Product getByProductId(Long productId){
        return productRepository.findWithProductItemsById(productId)
                .orElseThrow(()->new CustomException(NOT_FOUND_PRODUCT));
    }

    public List<Product> getListByProductIds(List<Long> productIds){
        return productRepository.findAllById(productIds);
    }
}

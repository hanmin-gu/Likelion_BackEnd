package com.example.service;


import com.example.domain.model.model.Product;
import com.example.domain.model.model.ProductItem;
import com.example.domain.model.prodcut.AddProductItemForm;
import com.example.exception.CustomException;
import com.example.repository.ProductItemRepository;
import com.example.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import static com.example.exception.ErrorCode.NOT_FOUND_PRODUCT;
import static com.example.exception.ErrorCode.SAME_ITEM_NAME;

@Service
@RequiredArgsConstructor
public class ProductItemService {
    private final ProductRepository productRepository;
    private final ProductItemRepository productItemRepository;

    @Transactional
    public Product addProductItem(Long memberId, AddProductItemForm form) {
        Product product = productRepository.findByMemberIdAndId(memberId, form.getProductId())
                .orElseThrow(() -> new CustomException(NOT_FOUND_PRODUCT));

        if (product.getProductItems().stream()
                .anyMatch(item -> item.getName().equals(form.getName()))) {
            throw new CustomException(SAME_ITEM_NAME);
        }

        ProductItem productItem = ProductItem.of(memberId, form);
        product.getProductItems().add(productItem);

        return product;
    }
}


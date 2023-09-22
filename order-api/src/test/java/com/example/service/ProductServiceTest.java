package com.example.service;

import com.example.domain.model.model.Product;
import com.example.domain.model.prodcut.AddProductForm;
import com.example.domain.model.prodcut.AddProductItemForm;
import com.example.repository.ProductItemRepository;
import com.example.repository.ProductRepository;
import org.hibernate.envers.AuditOverride;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ProductServiceTest {

    @Autowired
    private ProductService productService;
    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private ProductItemRepository productItemRepository;

    @Test
    void ADD_PRODUCT_TEST(){
        Long memberId = 1L;

        AddProductForm form = makeProductForm("Hello world", "봉사" ,  3);

        Product p = productService.addProduct(memberId, form);
        Product result = productRepository.findWithProductItemsById(p.getId()).get();
        assertNotNull(result);

        assertEquals(result.getName(), "Hello world");
        assertEquals(result.getDescription(), "봉사");
        assertEquals(result.getProductItems().size(), 3);
        assertEquals(result.getProductItems().get(0).getName(), "Hello world");
        assertEquals(result.getProductItems().get(0).getName(), "봉사");
        assertEquals(result.getProductItems().get(0).getName(), 3);
        assertEquals(result.getProductItems().get(0).getName(), 1);

    }

    private static AddProductForm makeProductForm(String name, String description, int itemCount){
        List<AddProductItemForm> itemForms = new ArrayList<>();
        for(int i=0; i < itemCount; i++){
            itemForms.add(makeProductItemForm(null, name + i));
        }

        return AddProductForm.builder().name(name).description(description).items(itemForms).build();

    }
    private static AddProductItemForm makeProductItemForm(Long productId, String name){
        return AddProductItemForm.builder()
                .productId(productId)
                .name(name)
                .price(10000)
                .count(1)
                .build();
    }

}
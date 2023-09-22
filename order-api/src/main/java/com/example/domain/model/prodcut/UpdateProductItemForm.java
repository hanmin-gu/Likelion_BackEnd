package com.example.domain.model.prodcut;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UpdateProductItemForm {
    private Long productId;
    private Long id;
    private String name;
    private Integer price;
    private Integer count;
}

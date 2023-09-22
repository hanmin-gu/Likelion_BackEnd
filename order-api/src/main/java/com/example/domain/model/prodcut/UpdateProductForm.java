package com.example.domain.model.prodcut;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UpdateProductForm {

    private Long productId;
    private String name;
    private Integer price;
    private Integer count;

}

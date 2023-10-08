package com.example.domain.model.prodcut;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.w3c.dom.stylesheets.LinkStyle;

import java.util.List;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UpdateProductForm {

    private Long id;
    private String name;
    private String description;
    private List<UpdateProductForm> items;

}

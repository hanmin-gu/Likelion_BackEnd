package com.example.domain.model.model;

import com.example.domain.model.prodcut.AddProductForm;
import lombok.*;
import org.hibernate.envers.AuditOverride;
import org.hibernate.envers.Audited;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Audited
@AuditOverride(forClass = BaseEntity.class)
public class Product extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long memberId;

    private String name;

    private String description;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "product_id")
    private List<ProductItem> productItems = new ArrayList<>();


    public static Product of(Long memberId, AddProductForm form){
        return Product.builder()
                .memberId(memberId)
                .name(form.getName())
                .description(form.getDescription())
                .productItems(form.getItems().stream()
                        .map(piFrom -> ProductItem.of(memberId, piFrom)).collect(Collectors.toList()))
                .build();
    }





}

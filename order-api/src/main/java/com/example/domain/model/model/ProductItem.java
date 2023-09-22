package com.example.domain.model.model;


import com.example.domain.model.model.BaseEntity;
import com.example.domain.model.model.Product;
import com.example.domain.model.prodcut.AddProductItemForm;
import lombok.*;
import org.hibernate.envers.AuditOverride;
import org.hibernate.envers.Audited;

import javax.persistence.*;


@Entity
@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Audited
@AuditOverride(forClass = BaseEntity.class)
public class ProductItem extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long memberId;

    @Audited
    private String name;

    @Audited
    private Integer price;

    private Integer count;


    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "product_id")
    private Product product;

    public static ProductItem of(Long memberId, AddProductItemForm form){
        return ProductItem.builder()
                .memberId(memberId)
                .name(form.getName())
                .price(form.getPrice())
                .count(form.getCount())
                .build();
    }


}

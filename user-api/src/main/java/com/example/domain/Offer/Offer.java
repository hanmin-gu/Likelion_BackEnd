package com.example.domain.Offer;

import com.example.domain.model.AddOfferForm;
import com.example.domain.model.BaseEntity;
import lombok.*;
import org.hibernate.envers.AuditOverride;
import org.hibernate.envers.Audited;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Audited
@AuditOverride(forClass = BaseEntity.class)
public class Offer extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long memberId;
    private String email;
    private String title;

    private String description;
    private String work;
    private String time;
    private String region;

    private String eligibility;
    private String status;
    private String capacity;
    //private String work;


    private String date;


    /*
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "product_id")
    private List<ProductItem> productItems = new ArrayList<>(); */


    public static Offer of(Long memberId, String email, AddOfferForm form){
        return Offer.builder()
                .memberId(memberId)
                .email(email)
                .time(form.getTime())
                .date(form.getDate())
                //.name(form.getName())
                .description(form.getDescription())
                .eligibility(form.getEligibility())
                .title(form.getTitle())
                .region(form.getRegion())
                .status(form.getStatus())
                .capacity(form.getCapacity())
                .build();


        //
                // .productItems(form.getItems().stream()
                       // .map(piFrom -> ProductItem.of(memberId, piFrom)).collect(Collectors.toList()))
               // .build();
    }





}

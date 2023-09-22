package com.example.domain.model;


import com.example.domain.Offer.Offer;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
public class OfferDto {


    private String region;
    private String title;
    private String work;
    private String description;
    private String eligibility;
    private String time;

    public static OfferDto from(Offer offer) {

        return new OfferDto(offer.getTitle(), offer.getRegion(), offer.getWork(), offer.getDescription(), offer.getEligibility(), offer.getTime());
    }

}

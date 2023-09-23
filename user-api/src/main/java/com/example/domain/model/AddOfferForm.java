package com.example.domain.model;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AddOfferForm {
    private String description;
    private String title;
    private String status;
    private String capacity;
    //private String work;
    private String region;
    private String time;
    private String date;
    private String eligibility;

}

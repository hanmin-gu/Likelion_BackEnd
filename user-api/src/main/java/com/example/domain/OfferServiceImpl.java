package com.example.domain;

import com.example.domain.Offer.Offer;

import java.util.List;

public interface OfferServiceImpl {
    List<Offer> getOfferList() throws Exception;
}

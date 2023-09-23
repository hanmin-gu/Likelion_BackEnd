package com.example.Controller;


import com.example.domain.Offer.Offer;
import com.example.domain.model.AddOfferForm;
import com.example.domain.model.OfferDto;
import com.example.exception.CustomException;
import com.example.service.Offer.OfferService;
import common.UserVo;
import config.JwtAuthenticationProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.example.exception.ErrorCode.NOT_FOUND_OFFER;

@RestController
@RequestMapping("/offer")
@RequiredArgsConstructor
public class OfferController {

    private final JwtAuthenticationProvider provider;
    private final OfferService offerService;


    @PostMapping("/addOffer")
    public ResponseEntity<Offer> addOffer(@RequestHeader(name = "X-AUTH-TOKEN") String token, @RequestBody AddOfferForm form) {

        UserVo vo = provider.getUserVo(token);

        Offer offer = offerService.addOffer(vo.getId(), vo.getEmail(), form);
        return ResponseEntity.ok(offer);


    }

    @GetMapping("/getInfo")
    public ResponseEntity<OfferDto> getInfo(@RequestHeader(name = "X-AUTH-TOKEN") String token) {
        UserVo vo = provider.getUserVo(token);
        Offer o = offerService.findByIdAndEmail(vo.getId(), vo.getEmail()).orElseThrow(
                () -> new CustomException(NOT_FOUND_OFFER));

        return ResponseEntity.ok(OfferDto.from(o));

    }

    @GetMapping("/allOffers")
    public ResponseEntity<List<Offer>> getOffers() {
        return ResponseEntity.ok(offerService.getOfferList());
    }


    @GetMapping("/count")
    public ResponseEntity<Integer> getCount(@RequestHeader(name = "X-AUTH-TOKEN") String token) {
        UserVo vo = provider.getUserVo(token);
        Integer count = 0;

        List<Offer> offers = offerService.getOfferList();
        for (Offer offer : offers) {
            if (vo.getId() == offer.getId() && vo.getEmail().equals(offer.getEmail())) {
                count++;
            }
        }
        return ResponseEntity.ok(count);
    }


}


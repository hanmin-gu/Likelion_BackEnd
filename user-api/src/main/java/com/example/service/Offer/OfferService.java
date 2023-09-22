package com.example.service.Offer;

import com.example.domain.Offer.Offer;
import com.example.domain.OfferServiceImpl;
import com.example.domain.model.AddOfferForm;
import com.example.domain.model.Customer;
import com.example.domain.repository.OfferRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class OfferService implements OfferServiceImpl {
    private final OfferRepository offerRepository;

    @Transactional
    public Offer addOffer(Long memberId,String email, AddOfferForm form){
        return offerRepository.save(Offer.of(memberId, email, form));
    }

    public Optional<Offer> findByIdAndEmail(Long id, String email) {
        Optional<Offer> offer = offerRepository.findById(id);
        if(offer.get().getEmail().equals(email)){
            return offer;
        }

        return Optional.empty();
    }

    @Override
    public List<Offer> getOfferList(){
        return (List<Offer>) offerRepository.findAll();
    }

}


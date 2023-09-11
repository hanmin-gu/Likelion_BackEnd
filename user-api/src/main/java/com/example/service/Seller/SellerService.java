package com.example.service.Seller;


import com.example.domain.SignUpForm;
import com.example.domain.model.Seller;
import com.example.domain.repository.SellerRepository;
import com.example.exception.CustomException;

import com.example.exception.ErrorCode;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.Optional;


@Service
@RequiredArgsConstructor
public class SellerService {
    private final SellerRepository sellerRepository;

    public Optional<Seller> findByIdAndEmail(Long id, String email){
        //Optional<Seller> seller = sellerRepository.findById(id);
        //if(seller.get().getEmail().equals(email)) return seller;
        //return Optional.empty();
        return sellerRepository.findByIdAndEmail(id,email);
    }
    public Optional<Seller> findValidSeller(String email, String password){
        return sellerRepository.findByEmailAndPasswordAndVerifyIsTrue(email, password);
    }
    public Seller signUp(SignUpForm form){
        return sellerRepository.save(Seller.from(form));
    }
    public boolean isEmailExist(String email){
        return sellerRepository.findByEmail(email).isPresent();
    }
    @Transactional
    public void verifyEmail(String email, String code) {
        Seller seller = sellerRepository.findByEmail(email)
                .orElseThrow(() -> new CustomException(ErrorCode.NOT_FOUND_USER));
        if (seller.isVerify()) {
            throw new CustomException(ErrorCode.ALREADY_VERIFY);
        }
        else if (!seller.getVerificationCode().equals(code)) {
            throw new CustomException(ErrorCode.WRONG_VERIFICATION);
        }
        else if(seller.getVerifyExpiredAt().isBefore(LocalDateTime.now())){
            throw new CustomException(ErrorCode.EXPIRE_CODE);
        }
        seller.setVerify(true);
    }
    @Transactional
    public LocalDateTime ChangeSellerValidateEmail(Long sellerId, String verificationCode) {
        Optional<Seller> sellerOptional = sellerRepository.findById(sellerId);

        if (sellerOptional.isPresent()) {
            Seller seller = sellerOptional.get();
            seller.setVerificationCode(verificationCode);
            seller.setVerifyExpiredAt(LocalDateTime.now().plusDays(1));
            return seller.getVerifyExpiredAt();
        }
        //Exception
        throw new CustomException(ErrorCode.NOT_FOUND_USER);
    }

}

package com.example.application;


import com.example.domain.SignInForm;
import com.example.domain.model.Customer;
import com.example.domain.model.Seller;
import com.example.exception.CustomException;
import com.example.exception.ErrorCode;
import com.example.service.Customer.CustomerService;
import com.example.service.Seller.SellerService;
import common.UserType;
import config.JwtAuthenticationProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SignInApplication {
    private final CustomerService customerService;
    private final JwtAuthenticationProvider provider;
    private final SellerService sellerService;

    public String customerLoginToken(SignInForm form){
        Customer c = customerService.findValidCustomer(form.getEmail(),form.getPassword())
                .orElseThrow(()-> new CustomException(ErrorCode.LOGIN_CHECK_FAIL));


        //토큰 발행
        return provider.createToken(c.getEmail(), c.getId(), UserType.CUSTOMER);
    }

    public String sellerLoginToken(SignInForm form){
        Seller s = sellerService.findValidSeller(form.getEmail(),form.getPassword())
                .orElseThrow(()-> new CustomException(ErrorCode.LOGIN_CHECK_FAIL));


        //토큰 발행
        return provider.createToken(s.getEmail(), s.getId(), UserType.SELLER);
    }
}

package com.example.Controller;

import com.example.domain.Offer.Offer;
import com.example.domain.customer.ChangeBalanceForm;
import com.example.domain.customer.CustomerDto;
import com.example.domain.model.Customer;
import com.example.exception.CustomException;
import com.example.exception.ErrorCode;
import com.example.service.Customer.CustomerBalanceService;
import com.example.service.Customer.CustomerService;
import com.example.service.Offer.OfferService;
import common.UserVo;
import config.JwtAuthenticationProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.data.util.Pair;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/customer/Inf")
@CrossOrigin
@RequiredArgsConstructor
public class CustomerController {

    private final JwtAuthenticationProvider provider;
    private final CustomerService customerService;
    private final OfferService offerService;

    private final CustomerBalanceService customerBalanceService;

    @GetMapping("/getInfo")
    public ResponseEntity<Pair<CustomerDto, Integer>> getInfo(@RequestHeader(name = "X-AUTH-TOKEN") String token) {
        System.out.println(token);
        UserVo vo = provider.getUserVo(token);
        Integer count = 0;

        Customer c = customerService.findByIdAndEmail(vo.getId(), vo.getEmail()).orElseThrow(
                () -> new CustomException(ErrorCode.NOT_FOUND_USER)
        );

        List<Offer> offers = offerService.getOfferList();
        for (Offer offer : offers) {
            if (vo.getId() == offer.getMemberId() && vo.getEmail().equals(offer.getEmail())) {
                count++;
            }
        }
        Pair<CustomerDto, Integer> inf = Pair.of(CustomerDto.from(c), count);

        return ResponseEntity.ok(inf);
    }

    @PostMapping("/balance")
    public ResponseEntity<Integer> changeBalance(@RequestHeader(name = "X-AUTH-TOKEN") String token, @RequestBody ChangeBalanceForm form) {
        //System.out.println(token);
        UserVo vo = provider.getUserVo(token);

        return ResponseEntity.ok(customerBalanceService.changeBalance(vo.getId(), form).getCurrentMoney());
    }


}

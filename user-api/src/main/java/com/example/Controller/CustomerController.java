package com.example.Controller;


import com.example.domain.customer.ChangeBalanceForm;
import com.example.domain.customer.CustomerDto;
import com.example.domain.model.Customer;
import com.example.exception.CustomException;
import com.example.exception.ErrorCode;
import com.example.service.Customer.CustomerBalanceService;
import com.example.service.Customer.CustomerService;
import common.UserVo;
import config.JwtAuthenticationProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/customer")
@CrossOrigin
@RequiredArgsConstructor
public class CustomerController {

    private final JwtAuthenticationProvider provider;
    private final CustomerService customerService;
    private final CustomerBalanceService customerBalanceService;

    @GetMapping("/getInfo")
    public ResponseEntity<CustomerDto> getInfo(@RequestHeader(name = "X-AUTH-TOKEN") String token){
        System.out.println(token);
        UserVo vo = provider.getUserVo(token);

        Customer c = customerService.findByIdAndEmail(vo.getId(), vo.getEmail()).orElseThrow(
                ()->new CustomException(ErrorCode.NOT_FOUND_USER)
        );
        return ResponseEntity.ok(CustomerDto.from(c));
    }
    @PostMapping("/balance")
    public ResponseEntity<Integer> changeBalance(@RequestHeader(name = "X-AUTH-TOKEN") String token, @RequestBody ChangeBalanceForm form){
        //System.out.println(token);
        UserVo vo = provider.getUserVo(token);

        return ResponseEntity.ok(customerBalanceService.changeBalance(vo.getId(), form).getCurrentMoney());
    }





}

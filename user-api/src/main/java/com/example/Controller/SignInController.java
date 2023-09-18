package com.example.Controller;

import com.example.application.SignInApplication;
import com.example.domain.SignInForm;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping(value= "/signin")
@RequiredArgsConstructor
public class SignInController {

    private final SignInApplication signInApplication;
    @PostMapping("/customer")
    public ResponseEntity<String> signInCustomer(@RequestBody SignInForm form){
        //System.out.println(form.toString());
        return ResponseEntity.ok(signInApplication.customerLoginToken(form));
    }

    @PostMapping("/seller")
    public ResponseEntity<String> signInSeller(@RequestBody SignInForm form){
        //System.out.println(form.toString());
        return ResponseEntity.ok(signInApplication.sellerLoginToken(form));
    }


}

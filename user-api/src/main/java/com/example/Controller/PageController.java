package com.example.Controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
//@RequestMapping
public class PageController {
    @GetMapping
    public String mainPage() {
        return "main";
    }

    @GetMapping("/join")
    public String joinPage() {
        return "join";
    }

    @GetMapping("/login")
    public String loginPage() {
        return "login";
    }

    @GetMapping("/mypage")
    public String myPage() {
        return "mypage";
    }

    @GetMapping("/volunteer")
    public String volunteerPage() {
        return "volunteer";
    }

    @GetMapping("/volunteerOffer")
    public String volunteerOfferPage() {
        return "volunteerOffer";
    }

    @GetMapping("/navrequest")
    public String getNav(){
        return "nav";
    }
}

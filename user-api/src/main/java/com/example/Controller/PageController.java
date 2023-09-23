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
        return "user_page";
    }

    @GetMapping("/volunteer")
    public String volunteerPage() {
        return "volunteer";
    }

    @GetMapping("/volunteerWrite")
    public String volunteerOfferPage() {
        return "volunteer_write";
    }

    @GetMapping("/navrequest")
    public String getNav(){
        return "nav";
    }

    @GetMapping("test")
    public String test(){
        return "test";
    }


    @GetMapping("introduce")
    public String introduce(){
        return "introduce";
    }

    @GetMapping("market")
    public String marketPage(){
        return "market";
    }

    @GetMapping("community")
    public String community(){
        return "community";
    }
    @GetMapping("chat")
    public String chat(){
        return "chat";
    }

    @GetMapping("volunteerPartherBoard")
    public String partnerBoard(){
        return "volunteerPartnerBoard";
    }


}

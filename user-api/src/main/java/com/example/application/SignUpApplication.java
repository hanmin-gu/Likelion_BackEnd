package com.example.application;

import com.example.Client.MailgunClient;
import com.example.Client.maligun.SendMailForm;
import com.example.domain.SignUpForm;
import com.example.domain.model.Customer;
import com.example.domain.model.Seller;
import com.example.exception.CustomException;
import com.example.exception.ErrorCode;
import com.example.service.Customer.SignUpCustomerService;
import com.example.service.Seller.SellerService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
@Slf4j
public class  SignUpApplication {
    private final MailgunClient mailgunClient;
    private final SignUpCustomerService signUpCustomerService;
    private final SellerService sellerService;

    public void customerVerify(String email, String code){
        signUpCustomerService.verifyEmail(email, code);
    }
    public String customerSignUp(SignUpForm form) {

        if (signUpCustomerService.isEmailExist(form.getEmail())) {
            throw new CustomException(ErrorCode.ALREADY_REGISTER_USER);
        } else {
            Customer c = signUpCustomerService.signUp(form);
            //LocalDateTime now = LocalDateTime.now();


            String code = getRandomCode();
            SendMailForm sendMailForm = SendMailForm.builder()
                    .from("alrrn6807@naver.com")
                    .to(form.getEmail())
                    .subject("verification Email")
                    .text(getVerificationEmailBody(c.getEmail(), c.getName(),"customer", code))
                    .build();
            System.out.println(sendMailForm.toString());
            log.info("Send email result : " + mailgunClient.sendEmail(sendMailForm));
            //mailgunClient.sendEmail(sendMailForm);
            signUpCustomerService.ChangeCustomerValidateEmail(c.getId(), code);
        }

        return "회원가입에 성공하였습니다.";

    }

    private String getRandomCode() {
        return RandomStringUtils.random(10, true, true);
    }

    private String getVerificationEmailBody(String email, String name, String type, String code) {
        StringBuilder builder = new StringBuilder();
        return builder.append("Hello ").append(name).append("! Please CLick Link for verification.\n\n")
                .append("http://localhost:8081/signup/" + type + "/verify/?email=")
                .append(email)
                .append("&code=")
                .append(code).toString();
    }
    public void sellerVerify(String email, String code){
        sellerService.verifyEmail(email, code);
    }

    public String sellerSignUp(SignUpForm form){

        if (sellerService.isEmailExist(form.getEmail())) {
            throw new CustomException(ErrorCode.ALREADY_REGISTER_USER);
        } else {
            Seller s = sellerService.signUp(form);
            //LocalDateTime now = LocalDateTime.now();

            String code = getRandomCode();
            SendMailForm sendMailForm = SendMailForm.builder()
                    .from("alrrn6807@naver.com")
                    .to(form.getEmail())
                    .subject("verification Email")
                    .text(getVerificationEmailBody(s.getEmail(), s.getName(),"seller", code))
                    .build();
            System.out.println(sendMailForm.toString());
            log.info("Send email result : " + mailgunClient.sendEmail(sendMailForm));
            //mailgunClient.sendEmail(sendMailForm);
            sellerService.ChangeSellerValidateEmail(s.getId(), code);
        }

        return "회원가입에 성공하였습니다.";
    }

}

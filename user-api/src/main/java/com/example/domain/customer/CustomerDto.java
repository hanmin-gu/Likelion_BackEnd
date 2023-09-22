package com.example.domain.customer;

import com.example.domain.model.Customer;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
public class CustomerDto {

    private Long id;
    private String email;
    private String Type;
    private Integer balance; //봉사시간
    private Integer works;
    private Integer age;

    public static CustomerDto from(Customer customer) {
        String birth = customer.getBirth().toString();
        Integer age = 2023 - Integer.parseInt(birth.substring(0, 4));
        System.out.println("11" + birth);
        return new CustomerDto(customer.getId(), customer.getEmail(),customer.getType(), customer.getBalance() == null ? 0 : customer.getBalance(), customer.getWorks(), age);

    }
}

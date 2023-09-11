package com.example.service.Customer;

import com.example.domain.model.Customer;
import com.example.domain.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CustomerService {
    private final CustomerRepository customerRepository;

    public Optional<Customer> findByIdAndEmail(Long id, String email) {
        Optional<Customer> customer = customerRepository.findById(id);
        if(customer.get().getEmail().equals(email)){
            return customer;
        }

        return Optional.empty();
    }
    public Optional<Customer> findValidCustomer(String email, String password) {
        Optional<Customer> customer = customerRepository.findByEmail(email);
        if(customer.get().isVerify() && customer.get().getPassword().equals(password)) {
            return customer;
        }

        return Optional.empty();
    }
}

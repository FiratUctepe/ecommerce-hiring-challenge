package com.example.ecommercehiringchallenge.security;

import com.example.ecommercehiringchallenge.model.Customer;
import com.example.ecommercehiringchallenge.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.security.authentication.event.AuthenticationFailureBadCredentialsEvent;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

@Component
public class AuthenticationFailureListener implements ApplicationListener<AuthenticationFailureBadCredentialsEvent> {

    private static final int MAX_ATTEMPTS = 2;

    @Autowired
    CustomerRepository customerRepository;

    @Autowired
    private CustomerUserDetailsService customerUserDetailsService;

    @Override
    public void onApplicationEvent(AuthenticationFailureBadCredentialsEvent event) {
        String username = (String) event.getAuthentication().getPrincipal();
        UserDetails userDetails = customerUserDetailsService.loadUserByUsername(username);

        if (userDetails != null) {
            CustomerUserDetails customerUserDetails = (CustomerUserDetails) userDetails;
            Customer customer = customerRepository.findByUserName(username);

        }

    }
}

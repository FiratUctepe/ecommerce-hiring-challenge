package com.example.ecommercehiringchallenge.service;

import com.example.ecommercehiringchallenge.dto.request.CreateCustomerRequest;
import com.example.ecommercehiringchallenge.dto.request.UpdateCustomerRequest;
import com.example.ecommercehiringchallenge.dto.response.CustomerResponseDto;
import com.example.ecommercehiringchallenge.dto.util.ERole;
import com.example.ecommercehiringchallenge.exception.NotFoundCustomerException;
import com.example.ecommercehiringchallenge.model.Customer;
import com.example.ecommercehiringchallenge.model.Role;
import com.example.ecommercehiringchallenge.model.Token;
import com.example.ecommercehiringchallenge.repository.CustomerRepository;
import com.example.ecommercehiringchallenge.repository.RoleRepository;
import com.example.ecommercehiringchallenge.repository.TokenRepository;
import jakarta.mail.MessagingException;
import org.springframework.mail.javamail.JavaMailSender;
//import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

@Service
public class CustomerService {

    private final CustomerRepository customerRepository;
    private final RoleRepository roleRepository;
    private final TokenRepository tokenRepository;

    private final JavaMailSender javaMailSender;
//    private final PasswordEncoder passwordEncoder;

    public CustomerService(CustomerRepository customerRepository,
                           RoleRepository roleRepository,
                           TokenRepository tokenRepository,
                           JavaMailSender javaMailSender
//                           PasswordEncoder passwordEncoder
    ) {
        this.customerRepository = customerRepository;

        this.roleRepository = roleRepository;
        this.tokenRepository = tokenRepository;
        this.javaMailSender = javaMailSender;
//        this.passwordEncoder = passwordEncoder;
    }
    private Customer findCustomerById(Integer customerId) {
        return customerRepository.findById(customerId)
                .orElseThrow(() -> new NotFoundCustomerException("Bu id ile bir müşteri bulunamadı : " + customerId));
    }


    public CustomerResponseDto getCustomerById(Integer customerId) {
        return new CustomerResponseDto(findCustomerById(customerId));
    }

    //Bu metod token oluşturmak için revize edilecek.
    @Transactional
    public CustomerResponseDto createCustomer(CreateCustomerRequest createCustomerRequest) throws MessagingException {

        //Customer @Builder anotasyonuyla customer oluşturuyoruz
        Customer customer = Customer.builder()
                        .userName(createCustomerRequest.getUserName())
//                        .password(passwordEncoder.encode(createCustomerRequest.getPassword()))
                        .firstName(createCustomerRequest.getFirstName())
                        .lastName(createCustomerRequest.getLastName())
                        .age(createCustomerRequest.getAge())
                        .email(createCustomerRequest.getEmail())
                        .roles(new HashSet<>())
                        .orders(new ArrayList<>())
                        .createdDate(Calendar.getInstance().getTime())
                        .build();

        customerRepository.save(customer);

        //Bu costumera token veriyoruz
        Token token = new Token(customer);
        tokenRepository.save(token);

//        //Mail oluşturma işlemleri
//        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
//        MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage);
//
//        mimeMessageHelper.setTo(createCustomerRequest.getEmail());
//        mimeMessageHelper.setSubject("TEBRİKLER KAYDOLDUNUZ");
//        mimeMessageHelper.setText("Üyeliğinizi tamamlamak için linke tıklayın : "+"Token doğrulama linki/"+token.getToken());
//        //E-posta gönderme işlemi
//        javaMailSender.send(mimeMessage);

        return new CustomerResponseDto(customer);
    }

    @Transactional
    public CustomerResponseDto updateCustomerById(Integer customerId,UpdateCustomerRequest updateCustomerRequest) {
        Customer customer = findCustomerById(customerId);

        customer.setUserName(updateCustomerRequest.getUserName());
        customer.setPassword(updateCustomerRequest.getPassword());
        customer.setFirstName(updateCustomerRequest.getFirstName());
        customer.setLastName(updateCustomerRequest.getLastName());
        customer.setEmail(updateCustomerRequest.getEmail());
        customer.setAge(updateCustomerRequest.getAge());

        customerRepository.save(customer);
        return new CustomerResponseDto(customer);
    }
    @Transactional
    public void deleteCustomerById(Integer customerId) {
        customerRepository.delete(findCustomerById(customerId));
    }

    public String customerTokenConfirm(String tokenNumber) {
        Optional<Token> token = tokenRepository.findByTokenCode(tokenNumber);
        if(token.isPresent()){
            //Token doğruysa rolü set edip veritabınana kaydediyoruz
            Role role = new Role();
            role.setRoleName(ERole.USER.getValue());
            roleRepository.save(role);
            //Sonra tokenın ait olduğu kullanıcıya bu rolü set edip veritabanına kaydediyoruz
            Customer customer = token.get().getCustomer();
            customer.getRoles().add(role);
            customerRepository.save(customer);
            //Daha sonra bu tokenı veritabanımızdan siliyoruz.
            //Çünkü bir seferlik doğrulama için kullanılacak
            tokenRepository.delete(token.get());
            return "Başarılı bir şekilde aktive oldu";
        }
        return "Maalesef aktive olamadınız";
    }
}

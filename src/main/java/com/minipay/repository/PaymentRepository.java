package com.minipay.repository;



import com.minipay.entity.Payment;

import com.minipay.entity.User;

import org.springframework.data.jpa.repository.JpaRepository;



import java.util.List;



public interface PaymentRepository extends JpaRepository<Payment, Long> {

    List<Payment> findByUser(User user);

}
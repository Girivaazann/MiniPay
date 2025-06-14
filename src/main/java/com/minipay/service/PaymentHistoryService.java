package com.minipay.service;






import com.minipay.dto.PaymentHistoryResponse;

import com.minipay.entity.Payment;

import com.minipay.entity.User;

import com.minipay.repository.PaymentRepository;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;



import java.util.List;

import java.util.stream.Collectors;



@Service

public class PaymentHistoryService {



    @Autowired

    private PaymentRepository paymentRepository;



    public List<PaymentHistoryResponse> getPaymentHistory(User user) {

        List<Payment> payments = paymentRepository.findByUser(user);



        return payments.stream()

            .map(p -> new PaymentHistoryResponse(

                    p.getAmount(),

                    p.getMethod(),

                    p.getStatus(),

                    p.getTimestamp()

            )).collect(Collectors.toList());

    }

}



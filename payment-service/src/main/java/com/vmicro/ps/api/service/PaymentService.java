package com.vmicro.ps.api.service;

import java.util.Random;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.vmicro.ps.api.entity.Payment;
import com.vmicro.ps.api.repository.PaymentRepository;

@Service
public class PaymentService {

	private PaymentRepository paymentRepository;
	
	public PaymentService(PaymentRepository repository) {
		this.paymentRepository = repository;
	}
	
	public Payment doPay(Payment payment) {
		payment.setStatus(paymentprocessing());
		payment.setTransactionId(UUID.randomUUID().toString());
		return paymentRepository.save(payment);
	}
	
	public String paymentprocessing() {
		//should be third party payment gateway (paypal, paytm, phonepay)
		return new Random().nextBoolean()?"success":"false";
	}
}

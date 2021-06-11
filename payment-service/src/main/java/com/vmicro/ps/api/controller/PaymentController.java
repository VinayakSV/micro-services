package com.vmicro.ps.api.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vmicro.ps.api.entity.Payment;
import com.vmicro.ps.api.service.PaymentService;

@RestController
@RequestMapping("/payment")
public class PaymentController {

	private PaymentService paymentService;
	
	public PaymentController(PaymentService paymentService) {
		this.paymentService = paymentService;
	}
	
	
	@PostMapping("/dopay")
	public Payment doPayment(@RequestBody Payment payment) {
		return paymentService.doPay(payment);
	}
	
}

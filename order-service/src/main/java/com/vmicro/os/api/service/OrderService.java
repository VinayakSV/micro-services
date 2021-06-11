package com.vmicro.os.api.service;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.vmicro.os.api.common.Payment;
import com.vmicro.os.api.common.TransactionRequest;
import com.vmicro.os.api.common.TransactionResponse;
import com.vmicro.os.api.entity.Order;
import com.vmicro.os.api.repository.OrderRepository;

@Service
public class OrderService {

	private OrderRepository orderRepository;
	
	private RestTemplate restTemplate;

	public OrderService(OrderRepository orderRepository, RestTemplate restTemplate) {
		this.orderRepository = orderRepository;
		this.restTemplate = restTemplate;
	};

	public TransactionResponse saveOrder(TransactionRequest transactionRequest) {
		
		String response="";
		
		Order order = transactionRequest.getOrder();
		
		Payment payment = transactionRequest.getPayment();
		payment.setOrderId(order.getId());
		payment.setAmount(order.getPrice());
		
		
		//rest call
		Payment paymentResponse = restTemplate.postForObject("http://localhost:9191/payment/dopay", payment, Payment.class);
		
		response = paymentResponse.getStatus().equals("success")?"payment processing successful and order placed":"There is a failure in payment api, order added to cart";
		
		orderRepository.save(order);
		
		return new TransactionResponse(order, paymentResponse.getTransactionId(), paymentResponse.getAmount(), response);
		
	}
	
	
	
}

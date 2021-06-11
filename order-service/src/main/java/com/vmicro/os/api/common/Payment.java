package com.vmicro.os.api.common;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Payment {

	private int paymentId;
	private String status;
	private String transactionId;
	private int orderId;
	private double amount;
}

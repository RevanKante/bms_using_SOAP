package com.bms.endpoint;


import com.bms.service.TransactionService;
import com.bms.transaction_management.GetAllTransactionsRequest;
import com.bms.transaction_management.GetAllTransactionsResponse;
import com.bms.transaction_management.PerformTransactionRequest;
import com.bms.transaction_management.PerformTransactionResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

@Endpoint
public class TransactionEndpoint {

	private static final String NAMESPACE = "http://www.bms.com/transaction-management";

	@Autowired
	TransactionService service;

	@PayloadRoot(namespace = NAMESPACE, localPart = "PerformTransactionRequest")
	@ResponsePayload
	public PerformTransactionResponse performTransaction(@RequestPayload PerformTransactionRequest request) {
		return service.performTransaction(request);
	}

	@PayloadRoot(namespace = NAMESPACE, localPart = "GetAllTransactionsRequest")
	@ResponsePayload
	public GetAllTransactionsResponse getAllTransactions(@RequestPayload GetAllTransactionsRequest request) {
		return service.getAllTransactions(request.getAccountNumber());
	}
}

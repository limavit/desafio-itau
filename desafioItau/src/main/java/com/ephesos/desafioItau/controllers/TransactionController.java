package com.ephesos.desafioItau.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ephesos.desafioItau.models.Transaction;
import com.ephesos.desafioItau.services.TransactionService;
import com.ephesos.desafioItau.utils.MediaType;

@RestController
@RequestMapping("/transaction")
public class TransactionController {
	
	@Autowired
	TransactionService transactionService;
	
	
	@PostMapping(consumes = MediaType.APPLICATION_JSON)
	public void create(@RequestBody Transaction transaction) {
		
		transactionService.createTransaction(transaction);
		
	}

}

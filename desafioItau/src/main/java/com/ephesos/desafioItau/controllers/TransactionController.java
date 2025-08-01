package com.ephesos.desafioItau.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
	public ResponseEntity<Void> create(@RequestBody Transaction transaction) {
		
		try {
			transactionService.createTransaction(transaction);
			return ResponseEntity.status(HttpStatus.CREATED).build();//201
		} catch (IllegalArgumentException e) {
			return ResponseEntity.badRequest().build();//400
		}
		
		
		
	}

}

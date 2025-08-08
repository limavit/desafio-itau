package com.ephesos.desafioItau.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
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
	
	
	@PostMapping
	public ResponseEntity<Void> create(@RequestBody Transaction transaction) {
	    try {
	        boolean isCreated = transactionService.createTransaction(transaction);
	        
	        if (isCreated) {
	            return ResponseEntity.status(HttpStatus.CREATED).build(); // 201 - Criado com sucesso
	        } else {
	            return ResponseEntity.unprocessableEntity().build(); // 422 - Regras de negócio violadas
	        }
	    } catch (NullPointerException e) {
	        return ResponseEntity.badRequest().build(); // 400 - Requisição mal formada
	    } catch (IllegalArgumentException e) {
	        return ResponseEntity.unprocessableEntity().build(); // 422 - Dados inválidos
	    } catch (Exception e) {
	        return ResponseEntity.internalServerError().build(); // 500 - Erro inesperado
	    }
	}
	@DeleteMapping
	public ResponseEntity<Void> delete(){
		transactionService.deleteTransactions();
		return ResponseEntity.status(HttpStatus.OK).build();
	}
	

}

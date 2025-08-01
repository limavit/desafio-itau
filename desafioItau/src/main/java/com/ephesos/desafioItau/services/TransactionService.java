package com.ephesos.desafioItau.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ephesos.desafioItau.DesafioItauApplication;
import com.ephesos.desafioItau.models.Transaction;
import com.ephesos.desafioItau.repositories.TransactionRepository;

@Service
public class TransactionService {

    private final DesafioItauApplication desafioItauApplication;
    private static final Logger logger = LoggerFactory.getLogger(TransactionService.class);
	@Autowired	
	TransactionRepository repository;

    TransactionService(DesafioItauApplication desafioItauApplication) {
        this.desafioItauApplication = desafioItauApplication;
    }
	
	public void createTransaction(Transaction transaction){
		logger.info("Transaction inserted ");
		repository.createTransaction(transaction);
	}
	

}

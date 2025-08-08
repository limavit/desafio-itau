package com.ephesos.desafioItau.services;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

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
	
	public boolean createTransaction(Transaction transaction){
		
		if (isTransactionValid(transaction)) {
			logger.info("Transaction inserted ");
			logger.info("Transaction: " + transaction.getValor() + " : " + transaction.getDataHora());
			repository.createTransaction(transaction);
			return true;
		}else {
			logger.error("Transaction not inserted.");
			return false;
		}
		
	}
	public void deleteTransactions() {
		logger.info("Deleting transactions");
		repository.deleteTransaction();
		
	}
	
	public boolean isTransactionValid(Transaction transaction) {
		//evitar NullPointerException
	    if (transaction == null) { 
	        return false;
	    }
	    // Se qualquer um desses testes falhar, retorna false (422)
	    return !(transaction.getValor() == null 
	            || transaction.getDataHora() == null 
	            || transaction.getValor().compareTo(BigDecimal.ZERO) <= 0);
	}
	

}

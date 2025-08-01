package com.ephesos.desafioItau.rules;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

import com.ephesos.desafioItau.models.Transaction;

public class TransactionValidation {
	
	
	
	Transaction trxNow = new Transaction(new BigDecimal("0.0"), OffsetDateTime.now());

	
	public boolean transactionIsNull(Transaction transaction){
		if (transaction == null) {
			return true; //status 400 NULO
		}
		return false; 
	}
	//Regra da transação valida 422	
	public boolean isTransctionIsValid(Transaction transaction) {
		if (transaction.getValor().compareTo(BigDecimal.ZERO) <= 0 || transaction.getDataHora().isAfter(trxNow.getDataHora())) {
			return false;
		}
		
		return true;
	}

}

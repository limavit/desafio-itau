package com.ephesos.desafioItau.repositories;


import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.ephesos.desafioItau.models.Transaction;

@Repository
public class TransactionRepository {
	
	private final List<Transaction> listTransacoes = new ArrayList<>();
	
	public void createTransaction(Transaction transaction) {
		listTransacoes.add(transaction);
	}
	public void deleteTransaction() {
		listTransacoes.clear();
	}
}

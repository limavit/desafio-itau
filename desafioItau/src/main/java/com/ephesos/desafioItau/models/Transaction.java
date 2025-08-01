package com.ephesos.desafioItau.models;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

public class Transaction {
	private BigDecimal valor; //Existe uma falha. O mais indicado para performance seria o long
	private OffsetDateTime dataHora; // o mais indicado[
	
	public Transaction(BigDecimal valor, OffsetDateTime dataHora) {
		super();
		this.valor = valor;
		this.dataHora = dataHora;
	}

	public BigDecimal getValor() {
		return valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}

	public OffsetDateTime getDataHora() {
		return dataHora;
	}

	public void setDataHora(OffsetDateTime dataHora) {
		this.dataHora = dataHora;
	}
	
		
	
	

}

package br.edu.ifsp.spo.lp1a3.simple_bank;

import br.edu.ifsp.spo.lp1a3.simple_bank.Conta;

public class NumeroContaException extends RuntimeException {
	
	public NumeroContaException(String msg) {	
		super(msg);
	}
}
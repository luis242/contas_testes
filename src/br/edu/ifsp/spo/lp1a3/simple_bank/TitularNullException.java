package br.edu.ifsp.spo.lp1a3.simple_bank;

import br.edu.ifsp.spo.lp1a3.simple_bank.Conta;

public class TitularNullException extends RuntimeException{
	
	public TitularNullException(String msg) {	
		super(msg);
	}
}
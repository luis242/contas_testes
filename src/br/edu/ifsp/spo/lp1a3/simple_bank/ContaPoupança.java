package br.edu.ifsp.spo.lp1a3.simple_bank;

public class ContaPoupanša extends Conta {
	
	public ContaPoupanša(String titular, String numeroConta) {
		super(titular, numeroConta);
	}

	static double taxaRendimento;

	public static double getTaxaRendimento() {
		return taxaRendimento;
	}
	
	public void aplicarRendimento(double taxaRendimento) {
		this.saldo =  this.saldo + (this.saldo * taxaRendimento); 
	}

}

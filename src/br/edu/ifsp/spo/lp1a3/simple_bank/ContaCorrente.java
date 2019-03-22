package br.edu.ifsp.spo.lp1a3.simple_bank;

public class ContaCorrente extends Conta {
	
	public ContaCorrente(String titular, String numeroConta) {
		super(titular, numeroConta);
	}
	
	double limiteChequeEspecial;
	static double taxaJurosChequeEspecial;
	
	public void debitarJuros(double taxaJurosChequeEspecial) {
		this.saldo =  this.saldo - (this.saldo * taxaJurosChequeEspecial);
	}
	
	public double sacarcc(double valor) {
		this.saldo = valor -  (this.saldo * 0.01) ;
		return 0;
	}
	
}

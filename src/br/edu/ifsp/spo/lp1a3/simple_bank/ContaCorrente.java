package br.edu.ifsp.spo.lp1a3.simple_bank;

public class ContaCorrente extends Conta {
	
	double limiteChequeEspecial;
	static double taxaJurosChequeEspecial;
	
	public ContaCorrente(String titular, String numeroConta, double limite) {
		super(titular, numeroConta);
		
		if (limite < 0) {
			throw new LimiteMenorZeroException("Limite não pode ser 0 ou menor");
		}
		else {
			this.limiteChequeEspecial = limite;
		}
	}
	
	public double getLimiteChequeEspecial() {
		return limiteChequeEspecial;
	}
	public static double getTaxaJurosChequeEspecial() {
		return taxaJurosChequeEspecial;
	}
	
	public static void setTaxaJurosChequeEspecia(double taxaJurosChequeEspecial) {
		ContaCorrente.taxaJurosChequeEspecial = taxaJurosChequeEspecial;
	}
	
	public void debitarJuros(double taxaJurosChequeEspecial) {
		this.saldo =  this.saldo - (this.saldo * taxaJurosChequeEspecial);
	}
	
	public double sacarcc(double valor) {
		if (this.getSaldo() == 0) {
			throw new SaldoZeroException("Saldo não pode ser 0");
		}
		else {
		this.saldo = valor -  (this.saldo * 0.01) ;
		return 0;
		}
	
	}
}

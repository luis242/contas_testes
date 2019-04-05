package br.edu.ifsp.spo.lp1a3.simple_bank;

public class Conta {
	
	protected String titular;
	protected String numeroConta;
	protected double saldo;
	
	public String getTitular() {
		return this.titular;
	}
	
	public String getNumeroConta() {
		return this.numeroConta;
	}

	public double getSaldo() {
		return this.saldo;
	}
	
	public Conta(String titular, String numeroConta) {
		if (titular == null || titular.trim().isEmpty()) {
			throw new TitularNullException("Titular n�o pode ser nulo ou vazio");
		}
		else {
			
		this.titular = titular;
		
		if ((numeroConta == null || numeroConta.trim().isEmpty())) {
			throw new NumeroContaException("N�mero da conta n�o pode ser nulo ou vazio");
		}
		else {
			this.numeroConta = numeroConta;
			}
		}
	}

	public void depositar(double valor) { 
		this.saldo = this.saldo + valor;
	}

	public double retirar(double valor) {
		if (this.saldo == 0) {
			throw new SaldoZeroException("Saldo n�o pode ser 0");
		}	
		else {
			this.saldo = this.getSaldo() - valor;
			return this.getSaldo();
		}
	}

	public void transferirPara(Conta contaDestino, double valorATransferir) {
		double valor = this.retirar(valorATransferir);
		contaDestino.depositar(valor);
	}
}

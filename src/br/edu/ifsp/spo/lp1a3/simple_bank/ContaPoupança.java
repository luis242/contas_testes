package br.edu.ifsp.spo.lp1a3.simple_bank;

public class ContaPoupan�a extends Conta {
	
	public ContaPoupan�a(String titular, String numeroConta) {
		super(titular, numeroConta);
	}

	private static double taxaRendimento = 0.05;

	public static double getTaxaRendimento() {
		return taxaRendimento;
	}
	
	public static double setTaxaRendimento() {
		return taxaRendimento;
	}
	
	public void setTaxaRendimento(double taxaRendimento) {
		if (taxaRendimento <= 0) {
			throw new RendimentoMenorZeroException("Rendimento n�o pode ser 0");
		}
		else {
			ContaPoupan�a.taxaRendimento = taxaRendimento;
		}
	}
	
	public void aplicarRendimento(double taxaRendimento) {
		this.saldo =  this.saldo + (this.saldo * taxaRendimento); 
	}

}

package br.edu.ifsp.spo.lp1a3.simple_bank.tests;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.junit.Assert.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import br.edu.ifsp.spo.lp1a3.simple_bank.Conta;
import br.edu.ifsp.spo.lp1a3.simple_bank.ContaCorrente;

public class ContaCorrenteTests {
	
	@Test
	public void conta_corrente_deve_ser_uma_conta() {
		// 1. Configura��o
		// 2. Execu��o
		
		// 3. Valida��o / Asser��o
		assertThat(new ContaCorrente("Jo�o da Silva", "123-456"), instanceOf(Conta.class));
	}
	
	@Test
	public void devo_conseguir_debitar_juros_na_conta_corrente() {
		// 1. Configura��o
		ContaCorrente conta = new ContaCorrente("Jo�o da Silva", "123-456");
		double valorADepositar = 1000;
		double jurosADebitar = 0.01;
		
		// 2. Execu��o
		conta.depositar(valorADepositar);
		conta.debitarJuros(jurosADebitar);
				
		// 3. Valida��o / Asser��o
		assertEquals(valorADepositar - (valorADepositar * jurosADebitar), conta.getSaldo());
	}
	
	@Test
	public void devo_conseguir_sacar_da_conta_corrente() {
		// 1. Configura��o
		ContaCorrente conta = new ContaCorrente("Jo�o da Silva", "123-456");
		double valorADepositar = 1000;
		double valorSacar = 500;
				
		// 2. Execu��o
		conta.depositar(valorADepositar);
		conta.sacarcc(valorSacar);
						
		// 3. Valida��o / Asser��o
		assertEquals(valorSacar - (valorADepositar * 0.01), conta.getSaldo());
	}
}

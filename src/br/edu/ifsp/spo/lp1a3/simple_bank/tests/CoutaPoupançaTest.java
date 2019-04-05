package br.edu.ifsp.spo.lp1a3.simple_bank.tests;

import static org.hamcrest.CoreMatchers.instanceOf;

import static org.junit.Assert.assertThat;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import br.edu.ifsp.spo.lp1a3.simple_bank.Conta;
import br.edu.ifsp.spo.lp1a3.simple_bank.ContaPoupan�a;
import br.edu.ifsp.spo.lp1a3.simple_bank.RendimentoMenorZeroException;

public class CoutaPoupan�aTest {
	
	@Test
	public void conta_pupanca_deve_ser_uma_conta() {
		// 1. Configura��o
		
		// 2. Execu��o
		
		// 3. Valida��o / Asser��o
		assertThat(new ContaPoupan�a("Jo�o da Silva", "123-456"), instanceOf(Conta.class));
	}
	
	@Test
	public void devo_conseguir_aplicar_um_rendimento_na_poupan�a() {
		// 1. Configura��o
		ContaPoupan�a conta = new ContaPoupan�a ("Jo�o da Silva", "123-456");
		double valorADepositar = 1000;
		double taxaDeRendimento = 0.01;
		
		// 2. Execu��o
		conta.depositar(valorADepositar);
		conta.aplicarRendimento(taxaDeRendimento);
		
		// 3. Valida��o / Asser��o
		assertEquals(valorADepositar + (valorADepositar * 0.01), conta.getSaldo());
	}

	@Test
	public void taxa_rendimento_n�o_pode_ser_menor_que_0() {
		// 1. Configura��o
		ContaPoupan�a conta = new ContaPoupan�a ("Jo�o da Silva", "123-456");
		double taxaDeRendimento = -1;
		
		// 2. Execu��o
				
		// 3. Valida��o / Asser��o
		try {
			conta.setTaxaRendimento(taxaDeRendimento);
		}	
		catch (RendimentoMenorZeroException msg){
			
		}
	}
}

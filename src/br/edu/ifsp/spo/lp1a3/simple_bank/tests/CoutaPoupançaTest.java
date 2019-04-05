package br.edu.ifsp.spo.lp1a3.simple_bank.tests;

import static org.hamcrest.CoreMatchers.instanceOf;

import static org.junit.Assert.assertThat;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import br.edu.ifsp.spo.lp1a3.simple_bank.Conta;
import br.edu.ifsp.spo.lp1a3.simple_bank.ContaPoupança;
import br.edu.ifsp.spo.lp1a3.simple_bank.RendimentoMenorZeroException;

public class CoutaPoupançaTest {
	
	@Test
	public void conta_pupanca_deve_ser_uma_conta() {
		// 1. Configuração
		
		// 2. Execução
		
		// 3. Validação / Asserção
		assertThat(new ContaPoupança("João da Silva", "123-456"), instanceOf(Conta.class));
	}
	
	@Test
	public void devo_conseguir_aplicar_um_rendimento_na_poupança() {
		// 1. Configuração
		ContaPoupança conta = new ContaPoupança ("João da Silva", "123-456");
		double valorADepositar = 1000;
		double taxaDeRendimento = 0.01;
		
		// 2. Execução
		conta.depositar(valorADepositar);
		conta.aplicarRendimento(taxaDeRendimento);
		
		// 3. Validação / Asserção
		assertEquals(valorADepositar + (valorADepositar * 0.01), conta.getSaldo());
	}

	@Test
	public void taxa_rendimento_não_pode_ser_menor_que_0() {
		// 1. Configuração
		ContaPoupança conta = new ContaPoupança ("João da Silva", "123-456");
		double taxaDeRendimento = -1;
		
		// 2. Execução
				
		// 3. Validação / Asserção
		try {
			conta.setTaxaRendimento(taxaDeRendimento);
		}	
		catch (RendimentoMenorZeroException msg){
			
		}
	}
}

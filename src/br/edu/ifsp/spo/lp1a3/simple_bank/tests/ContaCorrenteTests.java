package br.edu.ifsp.spo.lp1a3.simple_bank.tests;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.junit.Assert.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import br.edu.ifsp.spo.lp1a3.simple_bank.Conta;
import br.edu.ifsp.spo.lp1a3.simple_bank.ContaCorrente;
import br.edu.ifsp.spo.lp1a3.simple_bank.LimiteMenorZeroException;
import br.edu.ifsp.spo.lp1a3.simple_bank.SaldoZeroException;

public class ContaCorrenteTests {
	
	@Test
	public void conta_corrente_deve_ser_uma_conta() {
		// 1. Configura��o
		// 2. Execu��o
		
		// 3. Valida��o / Asser��o
		assertThat(new ContaCorrente("Jo�o da Silva", "123-456", 300), instanceOf(Conta.class));
	}
	
	@Test
	public void devo_conseguir_debitar_juros_na_conta_corrente() {
		// 1. Configura��o
		ContaCorrente conta = new ContaCorrente("Jo�o da Silva", "123-456", 300);
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
		ContaCorrente conta = new ContaCorrente("Jo�o da Silva", "123-456", 300);
		double valorADepositar = 1000;
		double valorSacar = 500;
				
		// 2. Execu��o
		conta.depositar(valorADepositar);
		conta.sacarcc(valorSacar);
						
		// 3. Valida��o / Asser��o
		assertEquals(valorSacar - (valorADepositar * 0.01), conta.getSaldo());
	}
	
	@Test
	public void limite_cheque_especial_0_ou_menor() {
		// 1. Configura��o
		String nm = "Jos�";
		String num = "123-456";
		double limite = -30;
		
		// 2. Execu��o
								
		// 3. Valida��o / Asser��o
		try {
			ContaCorrente corrente = new ContaCorrente(nm, num, limite);
		}
		catch (LimiteMenorZeroException msg){
		}	
	}
	
	@Test
	public void saldo_corrente_0() {
		// 1. Configura��o
		ContaCorrente conta = new ContaCorrente("Jo�o da Silva", "123-456", 300);
		double valor = 300;
		
		// 2. Execu��o
										
		// 3. Valida��o / Asser��o
		try {
			conta.sacarcc(valor);
		}
		catch (LimiteMenorZeroException msg){	
		}	
	}
}

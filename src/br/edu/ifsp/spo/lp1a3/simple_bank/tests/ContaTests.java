package br.edu.ifsp.spo.lp1a3.simple_bank.tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import br.edu.ifsp.spo.lp1a3.simple_bank.Conta;
import br.edu.ifsp.spo.lp1a3.simple_bank.NumeroContaException;
import br.edu.ifsp.spo.lp1a3.simple_bank.SaldoZeroException;
import br.edu.ifsp.spo.lp1a3.simple_bank.TitularNullException;

public class ContaTests {

	@Test
	public void deve_conseguir_criar_uma_conta_com_titular_e_numero() {
		// 1. Configura��o
		String titular = "Jo�o da Silva";
		String numeroConta = "001-002";
		
		// 2. Execu��o
		Conta conta = new Conta(titular, numeroConta);
		
		// 3. Valida��o / Asser��o
		assertNotNull(conta);
		assertEquals(titular, conta.getTitular());
		assertEquals(numeroConta, conta.getNumeroConta());
	}
	
	@Test
	public void uma_nova_conta_deve_ter_saldo_zero() {
		//1. Configura��o
		Conta conta = new Conta("Jo�o da Silva", "123-456");
		
		//2. Execu��o
		double saldo = conta.getSaldo();
		
		//3. Valida��o / Asser��o
		assertEquals(0, saldo);
	}
	
	@Test
	public void devo_conseguir_depositar_um_valor_na_conta() {
		//1. Configura��o
		Conta conta = new Conta("Jo�o da Silva", "123-456");
		double valorADepositar = 100;
		
		//2. Execu��o
		conta.depositar(valorADepositar);
		
		//3. Valida��o / Asser��o
		assertEquals(valorADepositar, conta.getSaldo());
	}
	
	@Test
	public void devo_conseguir_retirar_um_valor_da_conta() {
		//1. Configura��o
		Conta conta = new Conta("Jo�o da Silva", "123-456");
		conta.depositar(100);
		double valorARetirar = 70;
		double saldoFinalEsperado = 30;
		
		//2. Execu��o
		double valorRetirado = conta.retirar(valorARetirar);
		
		//3. Valida��o / Asser��o
		assertEquals(valorARetirar, valorRetirado);
		assertEquals(saldoFinalEsperado, conta.getSaldo());
	}
	
	@Test
	public void devo_conseguir_transferir_valores_para_outra_conta() {
		//1. Configura��o
		Conta contaOrigem = new Conta("Jo�o da Silva", "123-456");
		contaOrigem.depositar(1000);
		double valorATransferir = 150;
		double saldoEsperadoOrigem = 1000 - valorATransferir;
		double saldoEsperadoDestino = valorATransferir;
		
		Conta contaDestino = new Conta("Maria da Silva", "123-457");
		
		//2. Execu��o
		contaOrigem.transferirPara(contaDestino, valorATransferir);
		
		//3. Valida��o / Asser��o
		assertEquals(saldoEsperadoOrigem, contaOrigem.getSaldo());
		assertEquals(saldoEsperadoDestino, contaDestino.getSaldo());
	}
	
	@Test
	public void titular_da_conta_null_ou_0() {
		//1. Configura��o
		String nm = null;
		String num = "123-456";
		
		//2. Execu��o
		
		//3. Valida��o / Asser��o
		try {
			Conta conta = new Conta(nm, num);
		}
		catch (TitularNullException msg) {		
		}
	}
	
	@Test
	public void numero_conta_null_ou_0() {
		//1. Configura��o
		String nm = "Jos�";
		String num = null;
		
		//2. Execu��o
		
		//3. Valida��o / Asser��o
		try {
			Conta conta = new Conta(nm, num);
		}
		catch (NumeroContaException msg) {		
		}
	}
}

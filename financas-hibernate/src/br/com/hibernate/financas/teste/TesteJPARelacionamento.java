package br.com.hibernate.financas.teste;

import java.math.BigDecimal;
import java.util.Calendar;

import javax.persistence.EntityManager;

import br.com.hibernate.financas.modelo.Conta;
import br.com.hibernate.financas.modelo.Movimentacao;
import br.com.hibernate.financas.modelo.TipoMovimentacao;
import br.com.hibernate.financas.util.JPAUtil;

public class TesteJPARelacionamento {

	public static void main(String[] args) {
		
		Conta conta = new Conta();
		conta.setAgencia("0102");
		conta.setBanco("343 - Nu Bank");
		conta.setNumero("1234-5");
		conta.setTitular("Renato Marela");
		
		Movimentacao movi = new Movimentacao();
		movi.setData(Calendar.getInstance());
		movi.setDescricao("Descricao da movimentação");
		movi.setTipo(TipoMovimentacao.SAIDA);
		movi.setValor(new BigDecimal("200.0"));
		
		movi.setConta(conta);
		
		EntityManager em = new JPAUtil().getEntityManager();
		
		em.getTransaction().begin();
		
		em.persist(conta);
		em.persist(movi);
		
		em.getTransaction().commit();
		
		em.close();
	}
}

package br.com.hibernate.financas.teste;

import javax.persistence.EntityManager;

import br.com.hibernate.financas.modelo.Conta;
import br.com.hibernate.financas.modelo.Movimentacao;
import br.com.hibernate.financas.util.JPAUtil;

public class TesteMovimentacaoConta {
	 public static void main(String[] args) {
		
		 
		 EntityManager em = new JPAUtil().getEntityManager();
		 em.getTransaction().begin();
		 
		 Movimentacao movi = em.find(Movimentacao.class, 3);
		 
		 Conta conta = movi.getConta();
		 
		 System.out.println(conta.getTitular());
		 
		 System.out.println(conta.getMovimentacoes().size());
		 
		 em.getTransaction().commit();
		 em.close();
	}
}

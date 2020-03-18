package br.com.hibernate.financas.teste;

import javax.persistence.EntityManager;

import br.com.hibernate.financas.modelo.Conta;
import br.com.hibernate.financas.util.JPAUtil;

public class TesteBuscaConta {
	public static void main(String[] args) {
		
		EntityManager em = new JPAUtil().getEntityManager();
		
		em.getTransaction().begin();
		
		Conta conta = em.find(Conta.class, 1);
		
		
		
		em.getTransaction().commit();
	}

}

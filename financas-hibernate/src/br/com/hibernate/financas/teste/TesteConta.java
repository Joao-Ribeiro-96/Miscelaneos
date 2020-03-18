package br.com.hibernate.financas.teste;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.hibernate.financas.modelo.Conta;
import br.com.hibernate.financas.util.JPAUtil;

public class TesteConta {

	public static void main(String[] args) {
		
		
		Conta conta = new Conta();
		conta.setTitular("João");
		conta.setBanco("BB");
		conta.setAgencia("123");
		conta.setNumero("456");
		
		EntityManager em = new JPAUtil().getEntityManager();
		
		em.getTransaction().begin();
		em.persist(conta);
		em.getTransaction().commit();
		
		
		em.close();
	}
}
 
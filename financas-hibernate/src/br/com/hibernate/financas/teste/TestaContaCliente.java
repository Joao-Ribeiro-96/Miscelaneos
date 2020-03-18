package br.com.hibernate.financas.teste;

import javax.persistence.EntityManager;

import br.com.hibernate.financas.modelo.Cliente;
import br.com.hibernate.financas.modelo.Conta;
import br.com.hibernate.financas.util.JPAUtil;

public class TestaContaCliente {
	public static void main(String[] args) {
		
		Cliente cliente1 = new Cliente();
		cliente1.setNome("Roberto Guararapes");
		cliente1.setProfissao("Analista de produtos");
		cliente1.setEndereco("Rua Augusta 123");
		
		Cliente cliente2 = new Cliente();
		cliente2.setNome("Glauber Faria");
		cliente2.setProfissao("Gerente de loja");
		cliente2.setEndereco("Rua Gutierre 123");
		
		Conta conta = new Conta();
		conta.setId(2);
		
		cliente1.setConta(conta);
		cliente2.setConta(conta);
		
		EntityManager em = new JPAUtil().getEntityManager();
		
		em.getTransaction().begin();
		
		em.persist(cliente1);
//		em.persist(cliente2);
		
		
		em.getTransaction().commit();
		em.close();
	}

}

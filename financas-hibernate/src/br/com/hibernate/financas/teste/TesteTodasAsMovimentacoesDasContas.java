package br.com.hibernate.financas.teste;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.hibernate.financas.modelo.Conta;
import br.com.hibernate.financas.util.JPAUtil;

public class TesteTodasAsMovimentacoesDasContas {
	public static void main(String[] args) {
	
		EntityManager em = new JPAUtil().getEntityManager();
		em.getTransaction().begin();
		
		String jpql = "select distinct c from Conta c left join fetch c.movimentacoes"; // o distinct evita que busque a mesma conta * a quantidade de movimenta��es
																						// O left busca tamb�m as entidades que n�o t�m movimenta��es
		Query query = em.createQuery(jpql);
		
		List <Conta> todasAsContas = query.getResultList();
		
		for (Conta conta : todasAsContas) {
			System.out.println("Titular "+ conta.getTitular());
			System.out.println("Movimentacoes: ");
			System.out.println(conta.getMovimentacoes());
		}
		
		em.getTransaction().commit();
		em.close();
	}
	
}

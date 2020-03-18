package br.com.hibernate.financas.teste;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.hibernate.financas.modelo.Conta;
import br.com.hibernate.financas.modelo.Movimentacao;
import br.com.hibernate.financas.modelo.TipoMovimentacao;
import br.com.hibernate.financas.util.JPAUtil;

public class TesteJPQL {

	public static void main(String[] args) {
		
		EntityManager em = new JPAUtil().getEntityManager();
		
		em.getTransaction().begin();
		
		Conta conta = new Conta();
		conta.setId(2);
		
		String jpql = "select m from Movimentacao m where m.conta = :pConta" +
		" and m.tipo = :pTipo" +
		" order by m.valor desc";
		
		Query query = em.createQuery(jpql);
		query.setParameter("pConta", conta);
		query.setParameter("pTipo", TipoMovimentacao.ENTRADA);
		
		List <Movimentacao> resultados = query.getResultList();
		
		for (Movimentacao movimentacao : resultados) {
			System.out.println("Descricao:" + movimentacao.getDescricao());
			System.out.println("Conta:" + movimentacao.getConta().getId());
		}
		
		em.getTransaction().commit();
		em.close();
	}
}

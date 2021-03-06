package br.com.hibernate.financas.teste;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.hibernate.financas.modelo.Categoria;
import br.com.hibernate.financas.modelo.Movimentacao;
import br.com.hibernate.financas.modelo.TipoMovimentacao;
import br.com.hibernate.financas.util.JPAUtil;

public class TesteMovimentacoesPorCategoria {
	
	public static void main(String[] args) {
		
		EntityManager em = new JPAUtil().getEntityManager();
		em.getTransaction().begin();
		
		Categoria categoria = new Categoria();
		categoria.setId(2);
		
		String jpql = "select m from Movimentacao m join m.categoria c where c = :pCategoria" ;
		
		Query query = em.createQuery(jpql);
		query.setParameter("pCategoria", categoria);
		
		List <Movimentacao> resultados = query.getResultList();
		
		for (Movimentacao movimentacao : resultados) {
			System.out.println("Descricao:" + movimentacao.getDescricao());
			System.out.println("Conta:" + movimentacao.getConta().getId());
		}
		
		
		em.getTransaction().commit();
		em.close();
	}

}

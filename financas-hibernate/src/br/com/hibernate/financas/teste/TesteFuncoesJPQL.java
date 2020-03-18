package br.com.hibernate.financas.teste;

import java.awt.geom.Arc2D.Double;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.hibernate.financas.modelo.Conta;
import br.com.hibernate.financas.modelo.TipoMovimentacao;
import br.com.hibernate.financas.util.JPAUtil;

public class TesteFuncoesJPQL {

	public static void main(String[] args) {
		
		EntityManager em = new JPAUtil().getEntityManager();
		
		em.getTransaction().begin();
		
		Conta conta = new Conta();
		conta.setId(2);
		
//      Calcula a m�dia das linhas do campo valor da Entidade movimenta��o
//		String jpql = "select avg(m.valor) from Movimentacao m where m.conta = :pConta" +
//		" and m.tipo = :pTipo" +
//		" order by m.valor desc";
//		
// 		Soma das linhas do campo valor da Entidade movimenta��o
//		String jpql = "select sum(m.valor) from Movimentacao m where m.conta = :pConta" +
//				" and m.tipo = :pTipo" +
//				" order by m.valor desc";
		

		

// 		a vari�vel valor � do tipo BigDecimal na classe Movimenta��o		
//		BigDecimal media = (BigDecimal)query.getSingleResult();
		
		Query typedQuery = em.createNamedQuery("MediasPorDiaETipo", Double.class);
		typedQuery.setParameter("pConta", conta);
		typedQuery.setParameter("pTipo", TipoMovimentacao.SAIDA);
		
		List<Double> medias = typedQuery.getResultList();
		
		
		System.out.println("A m�dia do dia 26 �: " + medias.get(0));
		System.out.println("A m�dia do dia 27 �: " + medias.get(1));
		
		em.getTransaction().commit();
		em.close();
}
}

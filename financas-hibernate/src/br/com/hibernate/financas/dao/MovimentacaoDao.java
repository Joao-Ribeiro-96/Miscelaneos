package br.com.hibernate.financas.dao;

import java.awt.geom.Arc2D.Double;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.hibernate.financas.modelo.Conta;
import br.com.hibernate.financas.modelo.TipoMovimentacao;

public class MovimentacaoDao {
	
	private EntityManager em;
	

	public MovimentacaoDao(EntityManager em) {
		this.em = em;
	}


	public List<Double> getMediasPorDiaETipo(TipoMovimentacao saida, Conta conta) {

	String jpql = "select distinct avg(m.valor) from Movimentacao m where m.conta = :pConta" +
			" and m.tipo = :pTipo" +
			" group by m.data";
	
	
	
		Query query = em.createQuery(jpql);
		query.setParameter("pConta", conta);
		query.setParameter("pTipo", TipoMovimentacao.SAIDA);


	
		return query.getResultList();
	}
}
package br.com.hibernate.financas.teste;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Calendar;

import javax.persistence.EntityManager;

import br.com.hibernate.financas.modelo.Categoria;
import br.com.hibernate.financas.modelo.Conta;
import br.com.hibernate.financas.modelo.Movimentacao;
import br.com.hibernate.financas.modelo.TipoMovimentacao;
import br.com.hibernate.financas.util.JPAUtil;

public class TesteMovimentacoesComCategoria {
	
	public static void main(String[] args) {
		Categoria categoria1 = new Categoria("Viagem");
		Categoria categoria2 = new Categoria("Negocios");
		
		Conta conta = new Conta();
		conta.setId(2);

		
		Movimentacao movi1 = new Movimentacao();
		movi1.setData(Calendar.getInstance());
		movi1.setDescricao("Viagem à São Paulo");
		movi1.setTipo(TipoMovimentacao.SAIDA);
		movi1.setValor(new BigDecimal("200.0"));
		movi1.setCategorias(Arrays.asList(categoria1,categoria2));
		
		movi1.setConta(conta);
		
		Movimentacao movi2 = new Movimentacao();
		movi2.setData(Calendar.getInstance());
		movi2.setDescricao("Viagem ao Rio de JAneiro");
		movi2.setTipo(TipoMovimentacao.SAIDA);
		movi2.setValor(new BigDecimal("150.0"));
		movi2.setCategorias(Arrays.asList(categoria1,categoria2));
		
		movi2.setConta(conta);
		
		EntityManager em = new JPAUtil().getEntityManager();
		em.getTransaction().begin();
		
		em.persist(categoria1);
		em.persist(categoria2);
		
		em.persist(movi1);
		em.persist(movi2);
		
		em.getTransaction().commit();
		em.close();
		
	}

}

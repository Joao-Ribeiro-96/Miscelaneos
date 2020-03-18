package br.com.hibernate.financas.teste;

import java.util.List;

import javax.persistence.EntityManager;

import br.com.hibernate.financas.modelo.Conta;
import br.com.hibernate.financas.modelo.Movimentacao;
import br.com.hibernate.financas.util.JPAUtil;

public class TesteInserirMovimentacao {

    public static void main(String[] args) {

        EntityManager em = new JPAUtil().getEntityManager();

        Conta conta = em.find(Conta.class, 1);

        List<Movimentacao> movimentacoes = conta.getMovimentacoes();
        
        for (Movimentacao movimentacao : movimentacoes) {
            System.out.println("Movimentação: " + movimentacao.getDescricao());
        }

        em.close();

       

    }
}
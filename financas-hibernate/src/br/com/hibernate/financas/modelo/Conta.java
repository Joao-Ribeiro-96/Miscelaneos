package br.com.hibernate.financas.modelo;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity //indica que essa classe ser� uma entidade no banco de dados
public class Conta {
	
	@Id// indica que o atributo ID ser� o identificador do objeto, ou seja o ID
	@GeneratedValue(strategy=GenerationType.IDENTITY)//indica que o banco gerer� um id nova. Stratergy indica como ser� feita a adi��o do ID aonde Generationtype.Identity � o auto increment
	private Integer id;
	private String titular;
	private String numero;
	private String banco;
	private String agencia;
	
	
	//One to Many Indica que o ter� uma conta para diversas movimenta��es  //A tag mappedby ir� indica que o relacionamento one to many ser� sincronizado com o relacionamento many to one configurado dentro da classe conta, evitando assim que se crie dois relacionamentos diferentes dependedo de qual objeto � istanciado antes
	@OneToMany(mappedBy="conta") 
	private List<Movimentacao> movimentacoes;
	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getTitular() {
		return titular;
	}
	public void setTitular(String titular) {
		this.titular = titular;
	}
	public String getNumero() {
		return numero;
	}
	public void setNumero(String numero) {
		this.numero = numero;
	}
	public String getBanco() {
		return banco;
	}
	public void setBanco(String banco) {
		this.banco = banco;
	}
	public String getAgencia() {
		return agencia;
	}
	public void setAgencia(String agencia) {
		this.agencia = agencia;
	}
	public List<Movimentacao> getMovimentacoes() {
		
		return movimentacoes;
	}
	

}

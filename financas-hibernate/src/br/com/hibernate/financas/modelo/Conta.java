package br.com.hibernate.financas.modelo;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity //indica que essa classe será uma entidade no banco de dados
public class Conta {
	
	@Id// indica que o atributo ID será o identificador do objeto, ou seja o ID
	@GeneratedValue(strategy=GenerationType.IDENTITY)//indica que o banco gererá um id nova. Stratergy indica como será feita a adição do ID aonde Generationtype.Identity é o auto increment
	private Integer id;
	private String titular;
	private String numero;
	private String banco;
	private String agencia;
	
	
	//One to Many Indica que o terá uma conta para diversas movimentações  //A tag mappedby irá indica que o relacionamento one to many será sincronizado com o relacionamento many to one configurado dentro da classe conta, evitando assim que se crie dois relacionamentos diferentes dependedo de qual objeto é istanciado antes
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

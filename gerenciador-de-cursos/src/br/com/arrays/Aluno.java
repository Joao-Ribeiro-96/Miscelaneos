package br.com.arrays;

public class Aluno {
	private String nome;
	private int numeroMatricula;

	
	public Aluno(String nome, int numeroMatricula) {
		if (nome == null) { //Tratando a exceção nukk
			throw new NullPointerException("Nome não pode ser null");
		}
		this.nome = nome;
		this.numeroMatricula = numeroMatricula;
	}

	public int getNumeroMatricula() {
		return numeroMatricula;
	}

	public String getNome() {
		return nome;
	}

	@Override
	public boolean equals(Object obj) { //Modificando o equals de forma a definir a comparação
		Aluno outro = (Aluno) obj;
		return this.nome.equals(outro.nome);
	}
	
	@Override
	public int hashCode() { //Código que irá definir o critério de separaçao dos conjuntos de Alunos a serem armazenados.
		//return this.nome.charAt(0);//pega o primeiro char do nome e separará todos os Alunos cujo o nome começa com essa letra.
		return this.nome.hashCode();
	}

	@Override
	public String toString() {
		return "[Aluno: " + this.nome + ", matricula: " + this.numeroMatricula + "]";
	}
	

}

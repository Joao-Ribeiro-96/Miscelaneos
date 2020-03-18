package br.com.arrays;

public class TestaBuscaAlunosNoCurso {
	
	public static void main(String[] args) {
		
		Curso javaColecoes =  new Curso("Dominando as coleções", "Prof" );
		
		javaColecoes.adiciona(new Aula("Trabalhando com ArrayList", 21));
		javaColecoes.adiciona(new Aula("Criando uma aula", 22));
		javaColecoes.adiciona(new Aula("Modelagem de coleções ", 23));
		
		Aluno a1 = new Aluno("João Ribeiro", 5617);
		Aluno a2 = new Aluno("Gilbertou Man", 32551);
		Aluno a3 = new Aluno("Motocicleberson Faria", 51553);
		
		javaColecoes.matricula(a1);
		javaColecoes.matricula(a2);
		javaColecoes.matricula(a3);
		
		System.out.println("Quem é o aluno com a matricula 5617?");
		Aluno aluno = javaColecoes.buscaMatriculado(5617);
		System.out.println("Aluno: " + aluno );
		
	} 

}

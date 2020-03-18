package br.com.arrays;

public class TestaCursoComAluno {
	public static void main(String[] args) {
		Curso javaColecoes = new Curso("Dominando as coleções", "Prof");

		javaColecoes.adiciona(new Aula("Trabalhando com ArrayList", 21));
		javaColecoes.adiciona(new Aula("Criando uma aula", 22));
		javaColecoes.adiciona(new Aula("Modelagem de coleções ", 23));
		
		Aluno a1 = new Aluno("João Ribeiro", 10110);
		Aluno a2 = new Aluno("Gilbertou Man", 32551);
		Aluno a3 = new Aluno("Motocicleberson Faria", 51553);
		
		javaColecoes.matricula(a1);
		javaColecoes.matricula(a2);
		javaColecoes.matricula(a3);
		
		System.out.println("Alunos do curso: " );
		javaColecoes.getAlunos().forEach(a -> {
			System.out.println(a);
		});
		
		Aluno a4 = new Aluno("João Ribeiro", 10110);
		
		System.out.println("O aluno " + a1 + " está matriculado?");
		System.out.println(javaColecoes.estaMatriculado(a4));
		
		System.out.println("a1 equals(modificado) ");
		System.out.println(a1.equals(a4));
		
		System.out.println(a1.hashCode()==a4.hashCode());
		
		

	}

}

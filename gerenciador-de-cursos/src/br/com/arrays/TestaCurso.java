package br.com.arrays;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TestaCurso {
	public static void main(String[] args) {
		Curso javaColecoes = new Curso("Dominando as cole��es", "Prof" );
			
		javaColecoes.adiciona(new Aula("Trabalhando com ArrayList", 21));
		javaColecoes.adiciona(new Aula("Criando uma aula", 22));
		javaColecoes.adiciona(new Aula("Modelagem de cole��es ", 23));
		
		List<Aula> aulasImutaveis = javaColecoes.getAulas();
		System.out.println(aulasImutaveis);
		
		List<Aula> aulas = new ArrayList<>(aulasImutaveis);
		
		Collections.sort(aulas);
		System.out.println(aulas);
		
		System.out.println(javaColecoes.getTempoTotal());
		System.out.println(javaColecoes);
	}

}

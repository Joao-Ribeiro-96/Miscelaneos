package br.com.arrays;

import java.util.ArrayList;
import java.util.Collections;

public class TestandoListas {
	public static void main(String[] args) {
		String aula1 = "conhecendo listas";
		String aula2 = "modelando a classe Aula";
		String aula3 = "Trabalhando com Cursos e Sets";
		
		ArrayList <String> aulas = new ArrayList();
		aulas.add(aula1);
		aulas.add(aula2);
		aulas.add(aula3);
		
		System.out.println(aulas.toString());
		
		aulas.remove(0);
		
		System.out.println(aulas.toString());
		
		for (String aula : aulas) {
			System.out.println("Aula: " + aula);
		}
		
		String primeiraAula = aulas.get(0);
		System.out.println("A primeira aula é" + primeiraAula);
		
		aulas.forEach(aula -> {
			System.out.println("listing ");
			System.out.println("aula"+aula);
			});
		
		aulas.add("Aumentando conhecimentos");
		Collections.sort(aulas); 
		
		
	}

}

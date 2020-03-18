package br.com.arrays;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class TestaListadeAula {
	public static void main(String[] args) {
		Aula a1 = new Aula("Revisitando as Arraylists", 21);
		Aula a2 = new Aula("Listas de Objetos", 19);
		Aula a3 = new Aula("Relacionamento de Listas e Objetos", 15);
		
		ArrayList <Aula> aulas = new ArrayList<>();
		aulas.add(a1);
		aulas.add(a2);
		aulas.add(a3);
		
		Collections.sort(aulas);
	
		aulas.forEach(a ->{
			System.out.println(a.getTitulo() +" "+ a.getTempo() + " minutos")  ;
		});
		
		//Collections.sort(aulas, Comparator.comparing(Aula::getTempo));//comparar por tempo
		
		System.out.println(aulas);
		
		aulas.sort(Comparator.comparing(Aula::getTempo));
	}	
}

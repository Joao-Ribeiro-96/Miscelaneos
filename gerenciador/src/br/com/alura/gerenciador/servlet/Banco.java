package br.com.alura.gerenciador.servlet;

import java.util.ArrayList;
import java.util.List;

public class Banco {
	
	private static List<Empresa> lista = new ArrayList<>();
	
	static {
		Empresa empresa1 = new Empresa();
		empresa1.setNome("Empresa1");
		Empresa empresa2 = new Empresa();
		empresa2.setNome("Empresa2");
		
		lista.add(empresa1);
		lista.add(empresa2);
		
		
	}

	public void adiciona(Empresa empresa) {
		lista.add(empresa);	
		
	}
	public List<Empresa> getEmpresas(){
		return Banco.lista; 
	}

}

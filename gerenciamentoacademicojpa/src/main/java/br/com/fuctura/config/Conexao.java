package br.com.fuctura.config;


import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Conexao {
	
	private EntityManagerFactory emf;
	
	
	public Conexao(String conexao) {
		this.emf = Persistence.createEntityManagerFactory(conexao);
	}
	
	public EntityManagerFactory getEmf() {
		return this.emf;
	}


}

package br.com.fuctura.config;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

public class Emteste {
private EntityManager em;
public Emteste(Conexao conn){
	this.em = conn.getEmf().createEntityManager();
	
}
public EntityManager getEm() {
	return this.em;

}

	
}





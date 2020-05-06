package main;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class TestaConexao {
	public static void main(String[] args) {
		// Criar EntityManagerFactory
		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("Projeto");
		
		EntityManager sessao = fabrica.createEntityManager();
		
		sessao.close();
		
		fabrica.close();

	}
}

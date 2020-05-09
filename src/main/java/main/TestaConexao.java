package main;

import javax.persistence.EntityManager;

import br.com.urbano.util.JPAUtil;

public class TestaConexao {
	public static void main(String[] args) {
		EntityManager sessao = JPAUtil.getEntityManager();
		sessao.close();
	}
}

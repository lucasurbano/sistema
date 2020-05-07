package dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import domain.Usuario;
import util.JPAUtil;

public class UsuarioDAO {

	public void salvar(Usuario usuario) {
		EntityManager sessao = JPAUtil.getEntityManager();
		EntityTransaction transacao = sessao.getTransaction();
		transacao.begin();
		sessao.persist(usuario);
		transacao.commit();
		sessao.close();
	}
}

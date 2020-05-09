package br.com.urbano.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import br.com.urbano.domain.Usuario;
import br.com.urbano.util.JPAUtil;

public class UsuarioDAO {

	public void salvar(Usuario usuario) {
		EntityManager sessao = JPAUtil.getEntityManager();
		EntityTransaction transacao = sessao.getTransaction();
		try {
			transacao.begin();
			sessao.persist(usuario);
			transacao.commit();
		} catch (RuntimeException e) {
			if (transacao != null) {
				transacao.rollback();
				throw e;
			}
		} finally {
			sessao.close();
		}
	}

	public Usuario buscar(Integer codigo) {
		EntityManager sessao = JPAUtil.getEntityManager();
		Usuario usuario = sessao.find(Usuario.class, codigo);
		return usuario;
	}

	public List<Usuario> listar() {
		// String jpql = ("from Usuario u");
		EntityManager sessao = JPAUtil.getEntityManager();
		List<Usuario> resultado = null;
		try {
			// Query consulta = sessao.createQuery("from Usuario u");
			// List<Usuario> resultado = consulta.getResultList();
			resultado = sessao.createQuery("from Usuario u").getResultList();

		} catch (Exception e) {
			System.out.println(e);
		} finally {
		}
		return resultado;
	}

}
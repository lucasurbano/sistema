package dao;

import java.util.List;

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

	public Usuario buscar(Integer codigo) {
		EntityManager sessao = JPAUtil.getEntityManager();
		Usuario usuario = sessao.find(Usuario.class, codigo);
		return usuario;
	}

	public List<Usuario> listar() {
		//String jpql = ("from Usuario u");
		EntityManager sessao = JPAUtil.getEntityManager();
		List<Usuario> resultado = null;
		try {
			//Query consulta = sessao.createQuery("from Usuario u");
			//List<Usuario> resultado = consulta.getResultList();
			resultado = sessao.createQuery("from Usuario u").getResultList();

		} catch (Exception e) {
			System.out.println(e);
		} finally {
		}
		return resultado;
	}

}

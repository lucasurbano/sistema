package dao;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import br.com.urbano.dao.UsuarioDAO;
import br.com.urbano.domain.Usuario;

public class UsuarioDAOTest {
	private UsuarioDAO usuarioDAO;

	@Before
	public void iniciar() {
		usuarioDAO = new UsuarioDAO();
	}

	@Test
	public void salvar() {
//		Usuario u1 = new Usuario();
		// u1(null, "adm", "adm2@ivia.com", "ivia");

//		u1.setNome("adm");
//		u1.setEmail("adm3@ivia.com");
//		u1.setSenha("ivia");

		Usuario u2 = new Usuario(null, "Desenvolvedor", "dev@ivia.com", "81998741290", "sefaz");

		UsuarioDAO usuarioDAO = new UsuarioDAO();
//		usuarioDAO.salvar(u1);
		usuarioDAO.salvar(u2);

	}

	public void buscar() {
		Usuario u1 = usuarioDAO.buscar(20);
		System.out.println(u1);

		Usuario u2 = usuarioDAO.buscar(30);
		System.out.println(u2);
	}

	public void listar() {
		List<Usuario> usuarios = usuarioDAO.listar();

		for (Usuario usuario : usuarios) {
			System.out.println(usuario);
		}
	}

	public void testar() {
		salvar();
		buscar();
		listar();
	}

}

package dao;

import org.junit.Test;

import domain.Usuario;

public class UsuarioDAOTest {
	@Test
	public void salvar() {
		Usuario u1 = new Usuario();
		u1.setCodigo(1);
		u1.setNome("adm");
		u1.setEmail("adm@ivia.com");
		u1.setSenha("ivia");
		
		Usuario u2 = new Usuario(2, "lucas", "lucas@ivia.com", "mysenha");
		

	UsuarioDAO usuarioDAO = new UsuarioDAO();
	usuarioDAO.salvar(u1);
	usuarioDAO.salvar(u2);
	
	}	
}

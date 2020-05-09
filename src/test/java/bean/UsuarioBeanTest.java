package bean;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import br.com.urbano.bean.UsuarioBean;
import br.com.urbano.domain.Usuario;

public class UsuarioBeanTest {
	private UsuarioBean usuarioBean;

	@Before
	public void iniciar() {
		usuarioBean = new UsuarioBean();
	}

	/*
	 * public void salvar() { Usuario u1 = new Usuario();
	 * 
	 * u1(null, "adm", "adm2@ivia.com", "ivia");
	 * 
	 * u1.setNome("adm"); u1.setEmail("adm99@ivia.com"); u1.setSenha("ivia");
	 * 
	 * Usuario u2 = new Usuario(null, "lucas", "lucas99@ivia.com", "mysenha");
	 * 
	 * UsuarioBean usuarioBean = new UsuarioBean(); usuarioBean.salvar(u1);
	 * usuarioBean.salvar(u2);
	 * 
	 * }
	 */

	/*
	 * public void buscar() { Usuario u1 = usuarioBean.buscar(20);
	 * System.out.println(u1);
	 * 
	 * Usuario u2 = usuarioBean.buscar(30); System.out.println(u2); }
	 */
	@Test
	public void listar() {
		usuarioBean.listar();
	}

	public void testar() {
		/*
		 * salvar(); buscar();
		 */
		listar();
	}

}

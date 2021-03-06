package br.com.urbano.bean;

import java.io.Serializable;

import javax.faces.view.ViewScoped;
import javax.inject.Named;

import org.omnifaces.util.Messages;

import br.com.urbano.dao.UsuarioDAO;
import br.com.urbano.domain.Usuario;

@SuppressWarnings("serial")
@Named
@ViewScoped
public class LoginManagedBean implements Serializable {
	private UsuarioDAO usuarioDAO = new UsuarioDAO();
	private Usuario usuario = new Usuario();

	public String envia() {

		usuario = usuarioDAO.getUsuario(usuario.getEmail(), usuario.getSenha());
		if (usuario == null) {
			usuario = new Usuario();
			Messages.addFlashGlobalError("Usuário ou senha incorretos!!");

			return null;
		} else {
			return "/usuario.xhtml";
		}

	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
}

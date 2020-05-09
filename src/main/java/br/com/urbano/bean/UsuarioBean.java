package br.com.urbano.bean;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

import org.omnifaces.util.Messages;

import br.com.urbano.dao.UsuarioDAO;
import br.com.urbano.domain.Usuario;
import lombok.Data;

@SuppressWarnings("serial")
@Named
@ViewScoped
@Data
public class UsuarioBean implements Serializable {

	private Usuario usuario;
	private List<Usuario> usuarios;

	public void salva() {
		System.out.println("Botao cadastrar pressionado");
		Messages.addGlobalInfo("Usuario salvo com sucesso");
	}

	@PostConstruct
	public void listar() {
		novo();
		try {
			UsuarioDAO usuarioDAO = new UsuarioDAO();
			usuarios = usuarioDAO.listar();

		} catch (RuntimeException e) {
			Messages.addGlobalError("Erro ao listar usuários");
			e.printStackTrace();
		}
	}
	
	public void novo() {
		usuario = new Usuario();

	}

	public void salvar() {
		try {

			UsuarioDAO usuarioDAO = new UsuarioDAO();
			usuarioDAO.salvar(usuario);

			novo();
			usuarios = usuarioDAO.listar();

			Messages.addGlobalInfo("Usuario salvo com sucesso");

			System.out.println("Salvo com sucesso");
		} catch (RuntimeException e) {
			System.out.println("Erro ... ");
			e.printStackTrace();
		}
	}

}
package br.com.urbano.bean;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.event.ActionEvent;
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
	private List<Usuario> usuariosFiltrados;

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

			System.out.printf("UsuarioBean-->salvar");

			usuarioDAO.salvar(usuario);

			// novo();
			usuarios = usuarioDAO.listar();

			Messages.addGlobalInfo("Usuario salvo com sucesso");

			System.out.println("Salvo com sucesso");
		} catch (RuntimeException e) {
			System.out.println("Erro ... ");
			Messages.addFlashGlobalError("Ocorreu um erro ao tentar salvar o usuario");
			e.printStackTrace();
		}
	}

	public void excluir(ActionEvent evento) {
		try {
			usuario = (Usuario) evento.getComponent().getAttributes().get("usuarioSelecionado");

			System.out.printf("Codigo do cara %d", usuario.getCodigo());
			System.out.printf("Nome do cara %s", usuario.getNome());

			UsuarioDAO usuarioDAO = new UsuarioDAO();
			usuarioDAO.excluir(usuario);

			usuarios = usuarioDAO.listar();

			Messages.addGlobalInfo("Usuario removido com sucesso");
		} catch (RuntimeException erro) {
			System.out.println("Erro ... ");
			Messages.addFlashGlobalError("Ocorreu um erro ao tentar remover o usuario");
			erro.printStackTrace();
		}
	}

	public void deletarUsuario(int codigoUsuario) {
		System.out.printf("Codigo do usuario %d", codigoUsuario);

		UsuarioDAO usuarioDAO = new UsuarioDAO();
		usuarioDAO.deletarUsuarioId(codigoUsuario);

		listar();

		Messages.addGlobalInfo("Usuario removido com sucesso");
	}

	public void editarUsuario(int codigoUsuario) {
		System.out.printf("Codigo do usuario %d", codigoUsuario);
		try {

			UsuarioDAO usuarioDAO = new UsuarioDAO();
			usuarioDAO.editarUsuarioId(codigoUsuario);
			
			listar();
			
		} catch (RuntimeException erro) {
			Messages.addFlashGlobalError("Ocorreu um erro ao tentar selecionar usuario");
			erro.printStackTrace();
		}
	}

	public void editar(ActionEvent evento) {
		usuario = (Usuario) evento.getComponent().getAttributes().get("usuarioSelecionado");
	}
	
	
		
	   public List<Usuario> getUsuariosFiltrados() {
	        return usuariosFiltrados;
	    }

	    public void setUsuariosFiltrados(List<Usuario> usuariosFiltrados) {
	        this.usuariosFiltrados = usuariosFiltrados;
	    }

}
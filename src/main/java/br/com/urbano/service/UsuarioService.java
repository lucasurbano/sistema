package br.com.urbano.service;

import java.util.ArrayList;
import java.util.List;

import dao.UsuarioDAO;
import domain.Usuario;

public class UsuarioService {
	private static List<Usuario> usuarios = new ArrayList<>();

	public void cadastrar(Usuario usuario) {
		usuarios.add(usuario);
	}

	public List<Usuario> buscarTodosUsuarios() {
		UsuarioDAO usuarioDAO = new UsuarioDAO();
		usuarios = usuarioDAO.listar();
		return usuarios;

	}

	public void excluir(int indice) {
		usuarios.remove(indice);
	}

	public void salvar(Usuario usuario) {
		UsuarioDAO usuarioDAO = new UsuarioDAO();
		usuarioDAO.salvar(usuario);
	}

}

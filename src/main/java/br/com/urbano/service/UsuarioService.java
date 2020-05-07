package br.com.urbano.service;

import java.util.ArrayList;
import java.util.List;

import domain.Usuario;

public class UsuarioService {
	private static List<Usuario> lista = new ArrayList<>();

	public void cadastrar(Usuario usuario) {
		lista.add(usuario);
	}

	public List<Usuario> getTodosUsuarios() {
		return lista;
	}

	public void excluir(int indice) {
		lista.remove(indice);
	}
}


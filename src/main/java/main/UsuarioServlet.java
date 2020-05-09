package main;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.urbano.domain.Usuario;
import br.com.urbano.service.UsuarioService;

@WebServlet(urlPatterns = "/usuario")
public class UsuarioServlet extends HttpServlet {

	UsuarioService usuarioService;

	List<Usuario> lista = new ArrayList<>();

	public UsuarioServlet() {
		System.out.println("Construindo Servlet...");

	}

	@Override
	public void init() throws ServletException {
		usuarioService = new UsuarioService();
		System.out.println("Inicializando Servlet");
		super.init();
	}

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		System.out.println("Chamando o service...");
		super.service(req, resp);
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String i = req.getParameter("i");
		if (i != null && i != "") {
			// usuarioService.excluir(Integer.parseInt(i));
			// }
			usuarioService.excluir(Integer.parseInt(i));
			req.setAttribute("msg", "Excluído com sucesso!");
		}

		RequestDispatcher dispatcher = req.getRequestDispatcher("usuario.jsp");

		req.setAttribute("lista", usuarioService.buscarTodosUsuarios());

		dispatcher.forward(req, resp);

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// String codigo = req.getParameter("id");
		String nome = req.getParameter("nome");
		String email = req.getParameter("email");
		String senha = req.getParameter("senha");

		Usuario usuario = new Usuario(null, nome, email, senha);

		usuarioService.salvar(usuario);

		RequestDispatcher dispatcher = req.getRequestDispatcher("usuario.jsp");
		req.setAttribute("msg", "Cadastrado com sucesso!");
		req.setAttribute("lista", usuarioService.buscarTodosUsuarios());
		dispatcher.forward(req, resp);

	}

	@Override
	public void destroy() {
		System.out.println("Servlet está sendo destruido");
		super.destroy();
	}

}

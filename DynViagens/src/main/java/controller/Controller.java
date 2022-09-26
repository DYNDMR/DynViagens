package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Conexao;
import model.Cliente;
import model.ClienteDAO;

/**
 * Servlet implementation class Controller
 */
@WebServlet(urlPatterns = { "/Controller", "/main", "/confirmar" })
public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;

	Conexao con = new Conexao();
	Cliente cliente = new Cliente();
	ClienteDAO clienteDAO = new ClienteDAO();

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String action = request.getServletPath();

		if (action.equals("/main")) {
			novoCliente(request, response);
		} else if (action.equals("/confirmar")) {
			confirmar(request, response);
		}

		System.out.println(action);
	}

	protected void novoCliente(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// setando as variaveis cliente

		cliente.setNome(request.getParameter("nome"));
		cliente.setEmail(request.getParameter("email"));
		cliente.setCPF(request.getParameter("cpf"));
		cliente.setSenha(request.getParameter("senha"));
		cliente.setSexo(request.getParameter("inlineRadioOptions"));

		///
		System.out.println(cliente.getEmail());
		System.out.println(cliente.getNome());
		System.out.println(cliente.getCPF());
		System.out.println(cliente.getSenha());
		clienteDAO.saveCliente(cliente);

		response.sendRedirect("siteViagens.html");
	}

	protected void confirmar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		System.out.println("Chegou até aqui");
		ClienteDAO clienteDAO = new ClienteDAO();
		String emailDig = request.getParameter("email");
        String senhaDig = request.getParameter("senha");
        
        for(Cliente cliente:clienteDAO.getClientes(emailDig)) {

            if(cliente.getEmail().equals(emailDig)  && cliente.getSenha().equals(senhaDig)) {

                System.out.println("Login efetuado com sucesso");
                response.sendRedirect("siteViagens.html");
            }else if (cliente.getEmail()!=emailDig || cliente.getSenha()!=senhaDig) {
                System.out.println("Usuário não encontrado");
                response.sendRedirect("paginas/login.html");
            }
        }
	}

}

package command;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Aluno;
import to.AlunoTO;


public class CadastrarAluno implements Command {

	@Override
	public void executa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String nome = request.getParameter("tNome");
		String endereco = request.getParameter("tEnd");
		String telefone = request.getParameter("tTel");
		String email = request.getParameter("tEmail");
		String rG = request.getParameter("tRG");
		String cPF = request.getParameter("tCPF");
		String senha = request.getParameter("tPass");
		String usuario= request.getParameter("tUser");
		
		Aluno aluno = new Aluno( 0,nome, endereco, telefone, email, rG, cPF, usuario, senha);
		
		HttpSession session = request.getSession();
		aluno.criar();
		ArrayList<AlunoTO> lista = new ArrayList<>();
		lista.add(aluno.getTo());
		session.setAttribute("lista", lista);
		RequestDispatcher view =  request.getRequestDispatcher("ListarAlunos.jsp");
		view.forward(request, response);
	}

}

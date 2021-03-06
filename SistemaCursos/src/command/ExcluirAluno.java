package command;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Aluno;

public class ExcluirAluno implements Command {

	@Override
	public void executa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String pNome = "";
		String pEnd  = "";
		String pTel  = "";
		String pEmail = "";
		String pRG    = "";
		String pCPF   = request.getParameter("cpf");
		String pUser  = "";
		String pPass  = "";
		
		Aluno aluno = new Aluno(pNome, pEnd, pTel, pEmail, pRG, pCPF, pUser, pPass);
		RequestDispatcher view = null;
		HttpSession session = request.getSession();
		
		aluno.excluir();
		session.setAttribute("lista", null);
		view = request.getRequestDispatcher("GerencAlunos.jsp");
		view.forward(request, response);
	}

}

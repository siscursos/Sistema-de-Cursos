package command;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Aluno;

public class DetalhesAluno implements Command {

	@Override
	public void executa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String pNome = request.getParameter("nome");
		String pEnd  = request.getParameter("end");
		String pTel  = request.getParameter("tel");
		String pEmail = request.getParameter("email");
		String pRg    = request.getParameter("rg");
		String pCpf   = request.getParameter("cpf");
		String pUser   = request.getParameter("user");
		String pPass   = "";
		
		Aluno aluno = new Aluno(pNome, pEnd, pTel, pEmail, pRg, pCpf, pUser, pPass);
		RequestDispatcher view = null;
		aluno.carregar();
		request.setAttribute("aluno", aluno.getTo());
		view = request.getRequestDispatcher("DetalhesAluno.jsp");
		view.forward(request, response);
	}

}
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
		
		aluno.carregar();
		request.setAttribute("aluno", aluno.getTo());
		view = request.getRequestDispatcher("DetalhesAluno.jsp");
		view.forward(request, response);
	}

}

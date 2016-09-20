package command;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Aluno;

public class EditarAluno implements Command {

	@Override
	public void executa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String pNome = request.getParameter("tNome");
		String pEnd  = request.getParameter("tEnd");
		String pTel  = request.getParameter("tTel");
		String pEmail = request.getParameter("tEmail");
		String pRG    = request.getParameter("tRG");
		String pCPF   = request.getParameter("tCPF");
		String pUser  = request.getParameter("tUser");
		String pPass  = request.getParameter("tPass");
		
		Aluno aluno = new Aluno(pNome, pEnd, pTel, pEmail, pRG, pCPF, pUser, pPass);
		RequestDispatcher view = null;
		HttpSession session = request.getSession();
		
		aluno.atualizar();
		session.setAttribute("lista", null);
		request.setAttribute("aluno", aluno.getTo());
		view = request.getRequestDispatcher("DetalhesAluno.jsp");
		view.forward(request, response);
	}

}

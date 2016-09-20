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
		String pNome = request.getParameter("tNome");
		String pEnd  = request.getParameter("tEnd");
		String pTel  = request.getParameter("tTel");
		String pEmail = request.getParameter("tEmail");
		String pRG    = request.getParameter("tRG");
		String pCPF   = request.getParameter("tCPF");
		String pUser  = request.getParameter("tUser");
		String pPass  = request.getParameter("tPass");

		Aluno aluno = new Aluno(pNome, pEnd, pTel, pEmail, pRG, pCPF, pUser, pPass);
		HttpSession session = request.getSession();
		
		aluno.criar();
		ArrayList<AlunoTO> lista = new ArrayList<>();
		lista.add(aluno.getTo());
		session.setAttribute("lista", lista);
		RequestDispatcher view = request.getRequestDispatcher("GerencAlunos.jsp");
		view.forward(request, response);
	}

}

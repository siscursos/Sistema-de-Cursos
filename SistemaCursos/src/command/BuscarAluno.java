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

public class BuscarAluno implements Command {

	@Override
	public void executa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String pesquisa = request.getParameter("pesquisa");
		Aluno aluno = new Aluno();
		ArrayList <AlunoTO> lista = null;
		HttpSession session = request.getSession();
		
		if(pesquisa != null && pesquisa.length() > 0){
			lista = aluno.listarAlunos(pesquisa);
		} else {
			lista = aluno.listarAlunos();
		}
		
		session.setAttribute("lista", lista);
		RequestDispatcher dispatcher = request.getRequestDispatcher("GerencAlunos.jsp");
		dispatcher.forward(request, response);
	}

}

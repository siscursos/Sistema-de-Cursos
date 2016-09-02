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


public class ExcluirAluno implements Command {

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
		boolean excluido = false;
		
		Aluno aluno = new Aluno(pNome, pEnd, pTel, pEmail, pRg, pCpf, pUser, pPass);
		RequestDispatcher view = null;
		HttpSession session = request.getSession();
		aluno.excluir();
		@SuppressWarnings("unchecked")
		ArrayList<AlunoTO> lista = (ArrayList<AlunoTO>) session.getAttribute("lista");
		lista.remove(busca(aluno, lista));
		excluido = true;
		session.setAttribute("lista", lista);
		session.setAttribute("excluido", excluido);
		view = request.getRequestDispatcher("GerencAlunos.jsp");
		view.forward(request, response);

	}
	
	public int busca(Aluno aluno, ArrayList<AlunoTO> lista) {
		AlunoTO to;
		for (int i = 0; i < lista.size(); i++) {
			to = lista.get(i);
			if (to.getCpf() == aluno.getCpf()) {
				return i;
			}
		}
		return -1;
	}

}

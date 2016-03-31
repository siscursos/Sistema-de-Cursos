package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Aluno;


@WebServlet("/manter_aluno.do")
public class ManterAlunoController extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String pNome    = request.getParameter("tNome");
		String pEnd     = request.getParameter("tEnd");
		String pFone    = request.getParameter("tTel");
		String pEmail   = request.getParameter("tEmail");
		String pRG      = request.getParameter("tRG");
		String pCPF     = request.getParameter("tCPF");
		String pUser    = request.getParameter("tUser");
		String pPass    = request.getParameter("tPass");
		String pAcao    = request.getParameter("acao");

		
		Aluno al = new Aluno(pNome, pEnd, pFone, pEmail, pRG, pCPF, pUser, pPass);
		
		if(pAcao.equals("Cadastrar")){
			al.cadastrar();
		} else if(pAcao.equals("Editar")){
			al.alterar();
		} else if(pAcao.equals("Excluir")){
			al.excluir();
		}
		al.consultar();
		
		request.setAttribute("AlunoTO", al.getTO());
		RequestDispatcher dispatcher = request.getRequestDispatcher("AlunoCadastrado.jsp");
		dispatcher.forward(request, response);
	}

}










<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import = "to.AlunoTO" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Aluno Cadastrado</title>
<link rel="stylesheet" href="EstiloForms.css" />
</head>
<body bgcolor="FFFFFF">
	<% 
		AlunoTO to = (AlunoTO)request.getAttribute("AlunoTO");
	%>>
	<h1>Sistema de Cursos</h1>
	<fieldset id="al_cadastrado">
		<legend>Aluno Cadastrado!</legend>
		<p>
			Nome    : <%= to.getNome()%>><br>
			Endereço: <%= to.getEndereco() %><br>
			Telefone: <%= to.getTelefone() %><br>
			E-mail  : <%= to.getEmail()    %><br>
			RG      : <%= to.getRG()       %><br>
			CPF     : <%= to.getCPF()      %><br>
			Usuário : <%= to.getLogin()    %><br>
			Senha   : <%= to.getSenha()    %>
			
		</p>
	</fieldset>>
</body>
</html>
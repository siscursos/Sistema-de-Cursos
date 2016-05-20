<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<%@ page import = "to.AlunoTO" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="pt-br">
<head>
	<!-- start: Meta -->
	<meta charset="utf-8">
	<c:import url="Styles.jsp"/>
	
	<title>Cadastro de Alunos</title>
</head>
<body>

	<!-- start: Header -->
	<c:import url="TopBar.jsp"/>
	<!-- end: Header -->
	
	<div class="container-fluid-full">
		<div class="row-fluid">
			<!-- start: Main Menu -->
			<c:import url="MenuLateral.jsp"/>

			<!-- end: Main Menu -->
		
<!-- --------------------------------------------------------------------------------------------------------------------------------------------------------------->
			<noscript>
				<div class="alert alert-block span10">
					<h4 class="alert-heading">Warning!</h4>
					<p>
						Você precisa ter <a href="http://en.wikipedia.org/wiki/JavaScript" target="_blank">JavaScript</a> habilitado pra usar esse site.
					</p>
				</div>
			</noscript>
			
<!------------------------------------------------------------------------------------------------------------------------------------------------------------------>	
		
			<div id="content" class="span10">
				<ul class="breadcrumb">
				<li>
					<i class="icon-home"></i>
					<a href="index.html">Início</a>
					<i class="icon-angle-right"></i> 
				</li>
				<li>
					<i class="icon-edit"></i>Cadastro de Alunos</a>
				</li>
			</ul>
			
		
			<% 
				AlunoTO to = (AlunoTO)request.getAttribute("AlunoTO");
			%>
			<h1>Sistema de Cursos</h1>
			<fieldset id="al_cadastrado">
				<legend>Aluno Cadastrado!</legend>
				<p>
					Nome    : <%= to.getNome()     %><br>
					Endereço: <%= to.getEnd() %><br>
					Telefone: <%= to.getTel() %><br>
					E-mail  : <%= to.getEmail()    %><br>
					RG      : <%= to.getRg()       %><br>
					CPF     : <%= to.getCpf() 	   %><br>
					Usuário : <%= to.getUser()     %><br>
					Senha   : <%= to.getPass()    %>
			
				</p>
			</fieldset>
			</div>
		</div>
	</div>
	
	<!-- start: JavaScript-->
	<c:import url="Scripts.jsp"/>
	<!-- end: JavaScript-->
</body>
</html>
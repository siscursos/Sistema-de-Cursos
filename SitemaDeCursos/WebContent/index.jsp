<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>       
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>	
	<meta charset="utf-8">
	<title>Sistema de Cursos - Início</title>
	<c:import url="Styles.jsp"/>
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
			
			<noscript>
				<div class="alert alert-block span10">
					<h4 class="alert-heading">Warning!</h4>
					<p>Você precisa ter <a href="http://en.wikipedia.org/wiki/JavaScript" target="_blank">JavaScript</a> habilitado pra usar esse site.</p>
				</div>
			</noscript>
			
			<!-- start: Content -->
			<div id="content" class="span10">
			
			
			<ul class="breadcrumb">
				<li>
					<i class="icon-home"></i>
					<a href="index.html">Início</a> 
				</li>
			</ul>

			
			<div class="row-fluid">
			<h1>Bem vindo ao Sistema de Cursos!<br>
			Selecione a opção desejada no menu à esquerda.</h1>
			</div>
			
			</div>
		</div>
	</div>

				
	<!-- start: JavaScript-->
	<c:import url="Scripts.jsp"/>		

	<!-- end: JavaScript-->
</body>
</html>
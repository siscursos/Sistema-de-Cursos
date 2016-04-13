<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import = "to.AlunoTO" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="pt-br">
<head>
	<!-- start: Meta -->
	<meta charset="utf-8">
	<meta name="description" content="Bootstrap Metro Dashboard">
	<meta name="author" content="Dennis Ji">
	<meta name="keyword"content="Metro, Metro UI, Dashboard, Bootstrap, Admin, Template, Theme, Responsive, Fluid, Retina">
	<!-- end: Meta -->
	<!-- start: Mobile Specific -->
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<!-- end: Mobile Specific -->
	<!-- start: CSS -->
	<link id="bootstrap-style" href="css/bootstrap.min.css" rel="stylesheet">
	<link href="css/bootstrap-responsive.min.css" rel="stylesheet">
	<link id="base-style" href="css/style.css" rel="stylesheet">
	<link id="base-style-responsive" href="css/style-responsive.css" rel="stylesheet">
	<link
		href='http://fonts.googleapis.com/css?family=Open+Sans:300italic,400italic,600italic,700italic,800italic,400,300,600,700,800&subset=latin,cyrillic-ext,latin-ext'
		rel='stylesheet' type='text/css'>
	<!-- end: CSS -->
	<!-- start: Favicon -->
	<link rel="shortcut icon" href="img/favicon.ico">
	<!-- end: Favicon -->
	
	<title>Cadastro de Alunos</title>
</head>
<body>

	<!-- start: Header -->
	<div class="navbar">
		<div class="navbar-inner">
			<div class="container-fluid">
				<a class="btn btn-navbar" data-toggle="collapse"
					data-target=".top-nav.nav-collapse,.sidebar-nav.nav-collapse">
					<span class="icon-bar"></span> 
					<span class="icon-bar"></span> 
					<span class="icon-bar"></span>
				</a> 
				<a class="brand" href="index.html"><span>SisCursos</span></a>

				<!-- start: Header Menu -->
				<div class="nav-no-collapse header-nav">
					<ul class="nav pull-right">
						<!-- start: User Dropdown -->
						<li class="dropdown">
							<a class="btn dropdown-toggle" data-toggle="dropdown" href="#">
								<i class="halflings-icon white user"></i> Nome Usuário <span class="caret"></span>
							</a>
							<ul class="dropdown-menu">
								<li class="dropdown-menu-title">
									<span>Informações da Conta</span>
								</li>
								<li><a href="#"><i class="halflings-icon user"></i> Profile</a></li>
								<li><a href="login.html"><i class="halflings-icon off"></i> Logout</a></li>
							</ul>
						</li>
						<!-- end: User Dropdown -->
					</ul>
				</div>
				<!-- end: Header Menu -->
			</div>
		</div>
	</div>
	<!-- end: Header -->
	
	<div class="container-fluid-full">
		<div class="row-fluid">
			<!-- start: Main Menu -->
			<div id="sidebar-left" class="span2" style="background-color: #004d99">
				<div class="nav-collapse sidebar-nav">
					<ul class="nav nav-tabs nav-stacked main-menu">
						<li><a href="index.html"><i class="icon-bar-chart"></i><span
								class="hidden-tablet"> Página Inicial</span></a></li>
						<li><a class="dropmenu" href="#"><i
								class="icon-folder-close-alt"></i><span class="hidden-tablet">
									Aluno</span>
							<!--  <span class="label label-important"> 3 </span>--></a>
							<ul>
								<li><a class="submenu" href="CadastroDeAlunos.html"><i
										class="icon-edit"></i><span class="hidden-tablet">
											Cadastro de Alunos</span></a></li>
							</ul></li>
						<li><a class="dropmenu" href="#"><i
								class="icon-folder-close-alt"></i><span class="hidden-tablet">
									Cadastro de Cursos</span>
							<span class="label label-important"> 2 </span></a>
							<ul>
								<li><a class="submenu" href="CadastroDeCursosInfo.html"><i
										class="icon-edit"></i><span class="hidden-tablet">
											Informática</span></a>
								</li>
							</ul>
							<ul>
								<li><a class="submenu" href="CadastroDeCursosAt.html"><i
										class="icon-edit"></i><span class="hidden-tablet">
											Artes</span></a>
								</li>
							</ul>
						</li>
					</ul>
				</div>
			</div>

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
					Endereço: <%= to.getEndereco() %><br>
					Telefone: <%= to.getTelefone() %><br>
					E-mail  : <%= to.getEmail()    %><br>
					RG      : <%= to.getrG()       %><br>
					CPF     : <%= to.getcPF() 	   %><br>
					Usuário : <%= to.getUser()     %><br>
					Senha   : <%= to.getSenha()    %>
			
				</p>
			</fieldset>
			</div>
		</div>
	</div>
</body>
</html>
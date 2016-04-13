<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
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
								<li><a class="submenu" href="CadastroDeAlunos.jsp"><i
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
			<!-- start: Content -->
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
				<div class="container">
					<form method="post" id="fcontato" action="manter_aluno.do">

						<h1>Cadastro de Alunos</h1>
						<div class="form-group " >
							<label for="cNome">Nome:</label><input type="text" class="form-control" name="tNome" 
									id="cNome" size="40" maxlength="40" placeholder="Nome" />
						</div>

						<div class="form-group">
							<label for="cEnd">Endereço:</label> <input type="text" class="form-control" name="tEnd" 
								id="cEnd" size="50" maxlength="50" placeholder="Endereço" />
						</div>
						
						<div class="form-group">
							<label for="Tel">Telefone:</label> <input type="number" name="tTel" class="form-control" 
								id="cTel" size="20" maxlength="11" min="0" max="99999999999" placeholder="Telefone" />

							<label for="cEmail"> E-mail:</label> <input type="email" class="form-control" name="tEmail" 
									id="cEmail" size="40" maxlength="40" placeholder="Email" />
						</div>
						<div class="form-group">
							<label for="cRG"> RG:</label><input type="text" class="form-control" name="tRG" 
								id="cRG" size="20" maxlength="9" placeholder="RG" />
						</div>
						<div class="form-group">
							<label for="cCPF">CPF:</label>
							<div class="form-inline">
								<input type="number" class="form-control" name="tCPF" id="cCPF" size="20" maxlenght="11" placeholder="CPF" />
								<input type="submit" name="acao" value="Consultar" class="btn btn-primary"> 
								<input type="submit" name="acao" value="Editar" class="btn btn-primary">

							</div>
						</div>


						<div class="form-group">
							<label for="cUser"> Usuário:</label><input type="text" class="form-control" name="tUser" 
								id="cRG" size="20" maxlenght="9" placeholder="Usuário" /> 
							<label for="cPass">Senha:</label><input type="password" class="form-control" name="tPass" 
								id="cRG" size="35" maxlenght="30" placeholder="Senha" />
						</div>



					<button type="submit" name="acao" class="btn btn-primary">Cadastrar</button>
					<button type="submit" name="acao" class="btn btn-primary">Excluir</button>
					<!--<input type="submit" name="acao" value="Voltar">-->
				</form>
			

			</div>
		</div>
		
	</div>

	</div>



	<!-- start: JavaScript-->
			
	<script src="js/jquery-1.9.1.min.js"></script>
	<script src="js/jquery-migrate-1.0.0.min.js"></script>
	<script src="js/jquery-ui-1.10.0.custom.min.js"></script>
	<script src="js/jquery.ui.touch-punch.js"></script>
	<script src="js/modernizr.js"></script>
	<script src="js/bootstrap.min.js"></script>
	<script src="js/jquery.cookie.js"></script>
	<script src='js/fullcalendar.min.js'></script>
	<script src='js/jquery.dataTables.min.js'></script>
	<script src="js/excanvas.js"></script>
	<script src="js/jquery.flot.js"></script>
	<script src="js/jquery.flot.pie.js"></script>
	<script src="js/jquery.flot.stack.js"></script>
	<script src="js/jquery.flot.resize.min.js"></script>
	<script src="js/jquery.chosen.min.js"></script>
	<script src="js/jquery.uniform.min.js"></script>
	<script src="js/jquery.cleditor.min.js"></script>
	<script src="js/jquery.noty.js"></script>
	<script src="js/jquery.elfinder.min.js"></script>
	<script src="js/jquery.raty.min.js"></script>
	<script src="js/jquery.iphone.toggle.js"></script>
	<script src="js/jquery.uploadify-3.1.min.js"></script>
	<script src="js/jquery.gritter.min.js"></script>
	<script src="js/jquery.imagesloaded.js"></script>
	<script src="js/jquery.masonry.min.js"></script>
	<script src="js/jquery.knob.modified.js"></script>
	<script src="js/jquery.sparkline.min.js"></script>
	<script src="js/counter.js"></script>
	<script src="js/retina.js"></script>
	<script src="js/custom.js"></script>
	<!-- end: JavaScript-->
</body>
</html>
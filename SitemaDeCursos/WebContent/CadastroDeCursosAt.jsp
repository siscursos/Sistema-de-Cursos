<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>   
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<!-- start: Meta -->
<meta charset="utf-8">
<c:import url="Styles.jsp"/>
<title>Cadastro de Cursos</title>
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
						Você precisa ter <a href="http://en.wikipedia.org/wiki/JavaScript"
							target="_blank">JavaScript</a> habilitado pra usar esse site.
					</p>
				</div>
			</noscript>

			<!------------------------------------------------------------------------------------------------------------------------------------------------------------------>
			<!-- start: Content -->
			<div id="content" class="span10" style="background-color: #EFEFEF">
				<ul class="breadcrumb">
					<li><i class="icon-home"></i> <a href="index.html">Início</a>
						<i class="icon-angle-right"></i></li>
					<li><i class="icon-edit"></i>Cadastro de Cursos - Artes</li>
				</ul>
				<div class="container">
					<form method="post" id="fcontato" action="manter_aluno.do">

						<h1>Cadastro de Cursos - Artes</h1>

						<div class="form-group">
							<label for="cId">Id:</label>
							<div class="form-inline">
								<input type="number" class="form-control" name="tId" id="cId"
									size="20" maxlenght="11" placeholder="ID" /> <input
									type="submit" name="acao" value="Consultar"
									class="btn btn-primary"> <input type="submit"
									name="acao" value="Editar" class="btn btn-primary">

							</div>
						</div>



						<div class="form-group">
							<label for="cNome">Nome:</label><input type="text"
								class="form-control" name="tNome" id="cNome" size="40"
								maxlenght="40" placeholder="Nome" />
						</div>
						<div class="form-group">
							<label for="cDtIni">Data de Início:</label> <input type="date"
								name="tDtIni" class="form-control" id="cDtIni" />
						</div>
						<div class="form-group">
							<label for="cDtFim">Data Final:</label> <input type="date"
								name="tDtFim" class="form-control" id="cDtFim" />
						</div>

						<div class="form-group">
							<label for="cHora"> Horário:</label><input type="text"
								class="form-control" name="tHora" id="cHora" size="20"
								maxlenght="15" placeholder="Horário" />
						</div>
						<div class="form-group">
							<label for="cNumVagas"> Número de Vagas:</label><input
								type="number" class="form-control" name="tNumVagas"
								id="cNumVagas" size="4" maxlenght="4" placeholder="Vagas" />
						</div>
						<div class="form-group">
							<label for="cValor"> Valor:</label><input type="number" step=0.01
								class="form-control" name="tValor" id="cValor" size="10"
								maxlenght="10" placeholder="Valor" />
						</div>
						<div class="form-group">
							<label for="cDescSoft"> Materiais/Livros:</label>
							<textarea class="form-control" rows="5" style="width: 30%"
								name="tNumLab" id="cNumLab"></textarea>
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
	<c:import url="Scripts.jsp"/>
	<!-- end: JavaScript-->
</body>
</html>
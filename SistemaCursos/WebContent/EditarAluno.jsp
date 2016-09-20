<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="pt-br">
<head>
	<meta charset="utf-8">
	<c:import url="Styles.jsp"/>
	
	<title>Editar Aluno</title>
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
			<!-- start: Content -->
			<div id="content" class="span10">
				<ul class="breadcrumb">
				<li>
					<i class="icon-home"></i>
					<a href="index.jsp">Início</a>
					<i class="icon-angle-right"></i> 
				</li>
				<li>
					<i class="icon-edit"></i>
					<a href="GerencAlunos.jsp">Gerenciamento de Alunos</a>
					<i class="icon-angle-right"></i>
				</li>
				<li>
					Editar Aluno: ${aluno.nome }
				</li>
				</ul>
				
					<form method="post" action="controller.do">

						<h1>Editar Aluno: ${aluno.nome }</h1>
						
						<div class="form-group" >
							<div class="form-inline">
								<label for="cNome">Nome: </label><input type="text" class="form-control" name="tNome" 
									id="cNome" size="40" maxlength="40" placeholder="Nome" value="${aluno.nome }"/>
								<label for="cEnd">Endereço: </label> <input type="text" class="form-control" name="tEnd" 
									id="cEnd" size="50" maxlength="50" placeholder="Endereço" value="${aluno.end }"/>
							</div>
						</div>
						
						<div class="form-group" style="margin-top: 15px;">
							<div class="form-inline">
								<label for="Tel">Telefone: </label> <input type="number" name="tTel" class="form-control" 
									id="cTel" size="20" maxlength="11" min="0" max="99999999999" placeholder="Telefone" value="${aluno.tel }"/>

								<label for="cEmail"> E-mail: </label> <input type="email" class="form-control" name="tEmail" 
									id="cEmail" size="40" maxlength="40" placeholder="Email" value="${aluno.email }"/>
							</div>
						</div>
						<div class="form-group" style="margin-top: 15px;">
							<div class="form-inline">
								<label for="cRG"> RG: </label><input type="text" class="form-control" name="tRG" 
									id="cRG" size="20" maxlength="9" placeholder="RG" value="${aluno.rg }"/>
								<label for="cCPF">CPF: </label><input type="number" class="form-control" name="tCPF" 
									id="cCPF" size="20" maxlenght="11" placeholder="CPF" value="${ aluno.cpf}"/>
							</div>
						</div>


						<div class="form-group" style="margin-top: 15px;">
							<div class="form-inline">
								<label for="cUser"> Usuário:</label><input type="text" class="form-control" name="tUser" 
									id="cRG" size="20" maxlenght="9" placeholder="Usuário" value="${aluno.user }"/> 
								<label for="cPass">Senha:</label><input type="password" class="form-control" name="tPass" 
									id="cRG" size="35" maxlenght="30" placeholder="Senha" value="${aluno.pass }"/>
							</div>
						</div>

					<hr />
					<button type="submit" class="btn btn-primary" name="command" value="EditarAluno">Salvar</button>
					<a class="btn btn-primary" name="voltar" href="GerencAlunos.jsp">Voltar</a>
				</form>
				
			

			
		</div>
		
	</div>

	</div>



	<!-- start: JavaScript-->
	<c:import url="Scripts.jsp"/>
	<!-- end: JavaScript-->
</body>
</html>
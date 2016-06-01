<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="pt-br">
<head>
	<meta charset="utf-8">
	<c:import url="Styles.jsp"/>
	
	<title>Gerenciamento de Alunos</title>
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
					<a href="index.html">Início</a>
					<i class="icon-angle-right"></i> 
				</li>
				<li>
					<i class="icon-edit"></i>Gerenciamento de Alunos
				</li>
				</ul>
					<div class="row-fluid">
						<h1>Gerenciamento de Alunos</h1>
					</div>
					
					<form action="controller.do" method="post">
						<div class="col-md-6">
							<div class="input-append" style="margin-top: 15px;">
								<input size="100" type="text" placeholder="Digite o nome do aluno(Deixe vazio para pesquisar todos)">
								<button class="btn" type="button" >Pesquisar</button>
							</div>
						</div>
					<div class="col-md-3">
                           <a href="CadastroDeAlunos.jsp" class="btn btn-primary pull-right h2">Cadastrar Aluno</a>
                    </div>
                    </form>
                    
					<c:if test="${not empty lista}">
                <div id="list" class="row">

                    <div class="table-responsive col-md-12">
                        <table class="table table-striped" cellspacing="0" cellpadding="0">
                            <thead>
                                <tr>
                                    <th>Nome</th>
                                    <th>CPF</th>
                                    <th>E-mail</th>
                                    <th class="actions"></th>
                                </tr>
                            </thead>
                            <tbody>
          					<c:forEach var="aluno" items="${lista }">
                                       <tr>
                                            <td>
                                               ${aluno.nome }
                                            </td>
                                            <td>
                                                ${aluno.cpf }
                                            </td>
                                            <td>
                                                ${aluno.email }
                                            </td>
                                            <td class="actions">
                                                <a class="btn btn-success btn-xs" href="controller.do?command=DetalhesAluno&id=${aluno.cpf }">Detalhes</a>
                                                <a class="btn btn-warning btn-xs" href="controller.do?command=EditarCliente&id=${aluno.cpf }">Editar</a>
                                             	<!-- <button id="btn${cliente.id }%>" type="button" class="btn btn-danger btn-xs" data-toggle="modal" data-target="#delete-modal" data-cliente="${cliente.id }">Excluir</button> -->
                                            </td>
                                        </tr>             
                            </c:forEach>

                            </tbody>
                        </table>

                    </div>
                </div>
                <!-- /#list -->

                <div id="bottom" class="row">
                    <div class="col-md-12">
                        <!-- paginação ainda não foi implementada -->
                        <ul class="pagination">
                            <li class="disabled"><a>&lt; Anterior</a>
                            </li>
                            <li class="disabled"><a>1</a>
                            </li>
                            <li><a href="#">2</a>
                            </li>
                            <li><a href="#">3</a>
                            </li>
                            <li class="next"><a href="#" rel="next">Próximo &gt;</a>
                            </li>
                        </ul>
                        <!-- /.pagination -->
                    </div>
                </div>
                </c:if>
                  
			</div>
		</div>
		
	</div>

	</div>



	<!-- start: JavaScript-->
	<c:import url="Scripts.jsp"/>
	<!-- end: JavaScript-->
</body>
</html>
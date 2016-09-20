<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="pt-br">
<head>
	<meta charset="utf-8">
	<c:import url="Styles.jsp"/>
	
	<title>Detalhes do Aluno</title>
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
			<!-- start: Modal -->
                <div class="modal fade" id="delete-modal" tabindex="-1" role="dialog" aria-labelledby="modalLabel">
                    <div class="modal-dialog" role="document">
                        <div class="modal-content">
                            <div class="modal-header">
                                <button type="button" class="close" data-dismiss="modal" aria-label="Fechar"><span aria-hidden="true">&times;</span>
                                </button>
                                <h4 class="modal-title" id="modalLabel">Excluir Aluno</h4>
                            </div>
                            <div class="modal-body">
                                Deseja realmente excluir o aluno ${aluno.nome } ?
                            </div>
                            <div class="modal-footer">
                                <form action="controller.do" method="post">
                                    <input type="hidden" name="cpf" value="${aluno.cpf }" />
                                    <button type="submit" class="btn btn-primary" name="command" value="ExcluirAluno">Sim</button>
                                    <button type="button" class="btn btn-default" data-dismiss="modal">Não</button>
                                </form>
                            </div>
                        </div>
                    </div>
                </div>
                <!-- end: modal -->
			
			
			<!-- start: Content -->
			<div  id="content" class="row-fluid">
				
				<ul class="breadcrumb">
				<li>
					<i class="icon-home"></i>
					<a href="index.html">Início</a>
					<i class="icon-angle-right"></i> 
				</li>
				<li>
					<i class="icon-edit"></i>
					<a href="index.html">Gerenciamento de Alunos</a>
					<i class="icon-angle-right"></i>
				</li>

				<li>
					Detalhes do Aluno: ${aluno.nome}
				</li>
				</ul>
					<div class="row-fluid" style="padding: 30px" >
					
						<h1>Detalhes do Aluno: ${aluno.nome } </h1>
						
						
                    		
                    		<div class="row">
                        		<div class="col-md-6">
                            		<p><strong>Nome: </strong></p>
                            		<p> ${aluno.nome }</p>
                        		</div>
                        		<div class="col-md-6">
                            		<p><strong>Endereço:</strong></p>
                            		<p> ${aluno.end }</p>
                        		</div>
                    		</div>
                    		<div class="row">
                        		<div class="col-md-6">
                            		<p><strong>Telefone: </strong></p>
                            		<p> ${aluno.tel}</p>
                        		</div>
                        		<div class="col-md-6">
                            		<p><strong>E-mail: </strong></p>
                            		<p> ${aluno.email}</p>
                        		</div>
                    		</div>
                    		<div class="row">
                        		<div class="col-md-6">
                            		<p><strong>RG: </strong></p>
                            		<p> ${aluno.rg}</p>
                        		</div>
                        		<div class="col-md-6">
                            		<p><strong>CPF: </strong></p>
                            		<p> ${aluno.cpf}</p>
                        		</div>
                    		</div>
                    		<div class="row">
                        		<div class="col-md-6">
                            		<p><strong>Usuário: </strong></p>
                            		<p> ${aluno.user}</p>
                        		</div>
                        		<div class="col-md-6">
                            		<p><strong>Senha: </strong></p>
                            		<p> ${aluno.pass}</p>
                        		</div>
                    		</div>
                    
                    
                    	<hr />
                    	<div id="actions" class="row">
                        <div class="col-md-12">
                            <a href="controller.do?command=EdicaoAluno&cpf=${aluno.cpf }" class="btn btn-primary">Editar</a>
                            <a href="#" class="btn btn-danger" data-toggle="modal" data-target="#delete-modal">Excluir</a>
                            <a href="GerencAlunos.jsp" class="btn btn-default">Voltar</a>
                        </div>
                    </div>
               
						
						
						</div>
					</div>
					
			</div>
		</div>
	
	<c:import url="Footer.jsp"/>



	<!-- start: JavaScript-->
	<c:import url="Scripts.jsp"/>
	<!-- end: JavaScript-->
</body>
</html>
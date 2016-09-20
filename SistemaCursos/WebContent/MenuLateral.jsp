<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

	
	<div id="sidebar-left" class="span2" style="background-color: #004d99">
				<div class="nav-collapse sidebar-nav">
					<ul class="nav nav-tabs nav-stacked main-menu">
						<li><a href="index.jsp"><i class="icon-bar-chart"></i><span
								class="hidden-tablet"> Página Inicial</span></a></li>
						<li><a class="dropmenu" href="#"><i
								class="icon-folder-close-alt"></i><span class="hidden-tablet">
									Aluno</span>
							<!--  <span class="label label-important"> 3 </span>--></a>
							<ul>
								<li><a class="submenu" href="controller.do?command=ListarAlunos"><i
										class="icon-edit"></i><span class="hidden-tablet">
											Gerenciamento de Alunos</span></a></li>
							</ul></li>
						<li><a class="dropmenu" href="#"><i
								class="icon-folder-close-alt"></i><span class="hidden-tablet">
									Cadastro de Cursos</span>
							<span class="label label-important"> 2 </span></a>
							<ul>
								<li><a class="submenu" href="CadastroDeCursosInfo.jsp"><i
										class="icon-edit"></i><span class="hidden-tablet">
											Informática</span></a>
								</li>
							</ul>
							<ul>
								<li><a class="submenu" href="CadastroDeCursosAt.jsp"><i
										class="icon-edit"></i><span class="hidden-tablet">
											Artes</span></a>
								</li>
							</ul>
						</li>
					</ul>
				</div>
	</div>
			

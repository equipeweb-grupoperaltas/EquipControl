<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
 <html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Controle de Equipamentos - Grupo Peraltas</title>
		<script type="text/javascript" src="<c:url value="/javascripts/jquery-1.8.3.js"/>"></script>
		<script type="text/javascript" src="<c:url value="/javascripts/jquery-ui-1.9.2.custom.min.js"/>"></script>
		<script type="text/javascript" src="<c:url value="/javascripts/jquery.jqGrid.src.js"/>"></script>
		<script type="text/javascript" src="<c:url value="/javascripts/i18n/grid.locale-pt-br.js"/>"></script>
		
		<link href="<c:url value="/stylesheet/jqueryUi/redmond/jquery-ui-1.9.2.custom.css"/>" rel="stylesheet" type="text/css" media="screen" />
		<link href="<c:url value="/stylesheet/jqueryUi/ui.jqgrid.css"/>" rel="stylesheet" type="text/css" media="screen" />
		<link href="<c:url value="/stylesheet/master.css"/>" rel="stylesheet" type="text/css" media="screen" />
		
		
	  <fmt:setLocale value="pt_br" />
	</head>
  <body>
  	<section id="header">
	    <div id="cabecalho">
			<div class="logo">
			<a href="<c:url value="/"/>">
				<img src="<c:url value="/images/logotipo.png"/>" />
				</a>
			</div>
			<div class="userLogado">
				<c:choose>
					<c:when test="${userSession.user.nome != null}">
						<p>
							<img src="<c:url value="/images/icons/user-black.png"/>" />
							${userSession.user.nome} <a href="logout">Sair</a> <br /> <br />
							Seja bem vindo!
						</p>
					</c:when>
					<c:otherwise>
						<p>
							<br /> <img src="<c:url value="/images/icons/user-black.png"/>" />
							Bem vindo visitante! <a href="login">Entrar</a> <br /> <br />
						</p>
					</c:otherwise>
				</c:choose>
	
			</div>
		</div>
	</section>
	
<c:if test="${userSession.user.nome != null}">
	<section id="menu-restrict">
			
			<div id="menu-interno">
				<ul>
					<li>
						<a href="<c:url value="/usuarios"/>">
							<img src="<c:url value="/images/icons/user.png"/>" /> 
							<p>Usuarios</p>
						</a>
					</li>
					<li>
						<a href="<c:url value="/fabricantes"/>">
							<img src="<c:url value="/images/icons/brick.png"/>" /> 
							<p>Fabricantes</p>
						</a>
					</li>
					<li>
						<a href="<c:url value="/modelos"/>">
							<img src="<c:url value="/images/icons/bricks.png"/>" /> 
							<p>Modelos</p>
						</a>
					</li>
					<li>
						<a href="<c:url value="/locais"/>">
							<img src="<c:url value="/images/icons/house_link.png"/>" /> 
							<p>Locais</p>
						</a>
					</li>
					<li>
						<a href="<c:url value="/equipamentos"/>">
							<img src="<c:url value="/images/icons/monitor_add.png"/>" /> 
							<p>Equipamentos</p>
						</a>
					</li>
					
				</ul>
			</div>
	</section>
	</c:if>
	
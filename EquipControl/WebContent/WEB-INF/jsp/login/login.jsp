<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<c:import url="/layout/header.jsp"></c:import>
<script type="text/javascript">
	$(document).ready(function() {
		$("#submit").click(function() {
			var usuario = $("#usuario").val();
			var password = $("#password").val();
			if (usuario == "") {
				alert("Usuario é obrigatorio!");
				return false;
			} else if (password == "") {
				alert("Senha é obrigatorio!");
				return false;
			} else {
				return true;
			}
		});
	});
</script>
<div id="conteudo" style="text-align: center;">

	<c:if test="${error != null}">
		<div class="ui-widget"
			style="width: 545px; text-align: center; margin-left: auto; margin-right: auto; margin-bottom: 6px;">
			<div class="ui-state-error ui-corner-all" style="padding: 0 .7em;">
				<p>
					<span class="ui-icon ui-icon-alert"
						style="float: left; margin-right: .3em;"></span> <strong>Erro:</strong>
					${error}
				</p>
			</div>
		</div>
	</c:if>
	<form id="login-form" method="post" action="autenticar">

		<div class="field">
			<label for="usuario">Usuario:</label> 
				<input type="text" class="input" name="usuario.usuario" value="${usuario.usuario}" id="usuario" />
			<p class="hint">Entre com seu usuario.</p>
		</div>
		
		<div class="field">
			<label for="senha">Senha:</label> 
				<input type="password" class="input" name="usuario.password" id="password" />
			<p class="hint">Entre com sua senha.</p>
		</div>
		
		<input type="submit" name="Submit" id="submit" class="button" value="Entrar" />
	</form>
</div>
<c:import url="/layout/footer.jsp"></c:import>
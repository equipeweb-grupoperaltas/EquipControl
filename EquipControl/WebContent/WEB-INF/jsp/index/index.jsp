<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<c:import url="/layout/header.jsp"></c:import>
<div id="conteudo">
	<table id="monitora" cellpadding="0" cellspacing="0">
		<thead>
			<tr>
				<th>Local</th>
				<th>Equipamento</th>
				<th>IP</th>
				<th>Status</th>
				<th>Acessar</th>
			</tr>
		</thead>
	<tbody>
	<c:forEach var="resultado" items="${resultsArray}">
		<tr>
			<td>${resultado.local}</td>
			<td>${resultado.equipamento}</td>
			<td>${resultado.ip}</td>
			<td>
				${resultado.status}
			</td>
			<td>
				<a href="http://${resultado.ip}">Acessar</a>
			</td>
		</tr>
	</c:forEach>
	</tbody>
	</table>
</div>
<c:import url="/layout/footer.jsp"></c:import>
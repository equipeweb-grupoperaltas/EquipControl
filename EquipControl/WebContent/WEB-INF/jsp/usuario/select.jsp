<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<select name="usuario" id="usuario">
  <c:forEach var="usuario" items= "${usuariosArray}">  
  	<option value="${usuario.id}">${usuario.nome}</option>
  </c:forEach>
</select>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<select name="modelo" id="modelo">
  <c:forEach var="modelo" items= "${modeloArray}">  
  	<option value="${modelo.id}">${modelo.modelo}</option>
  </c:forEach>
</select>

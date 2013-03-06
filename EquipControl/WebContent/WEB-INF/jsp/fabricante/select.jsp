<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<select name="fabricante.fabricante" id="fabricantes">
  <c:forEach var="fabricante" items= "${fabricantesArray}">  
  	<option value="${fabricante.id}">${fabricante.fabricante}</option>
  </c:forEach>
</select>

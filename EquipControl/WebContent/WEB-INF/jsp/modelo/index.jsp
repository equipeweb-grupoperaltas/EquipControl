<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<c:import url="/layout/header.jsp"></c:import>

<div id="conteudo">
	<table id="tbl-modelo"></table>
	<div id="pg-modelo"></div>
</div>

<script type="text/javascript">

/** 
	<c:url value="/usuarios/usuario.json"/> */
	$(function() {

		$("#tbl-modelo")
				.jqGrid(
						{
							url : '<c:url value="/modelos/modelos.json"/>',
							editurl : '<c:url value="/modelos/actionGrid"/>',
							datatype : "json",
							autowidth : true,
							colNames : [ 'Código', 'Fabricante', 'Modelo' ],
							colModel : [
									{
										name : 'id',
										index : 'id',
										width : 55,
										sorttype : "long",
										align : "center"
									},
									{
										name : 'fabricante.fabricante',
										index : 'fabricante.fabricante',
										width : 300,
										editable : true,
										sorttype : "string",
										edittype : "select",
										editoptions : {
											dataUrl : '<c:url value="/fabricantes/select"/>'}
									},
									{
										name : 'modelo',
										index : 'modelo',
										sorttype : "string",
										width : 400,
										editable : true
									}, ],
							rowNum : 40,
							pager : '#pg-modelo',
							height : 500,
							viewrecords : true,
							sortname : 'fabricante',
							sortorder : "desc",
							caption : "Lista de Modelos",
							jsonReader : {
								root : "rows", //array containing actual data    
								page : "page", //current page    
								total : "total", //total pages for the query    
								records : "records", //total number of records
								repeatitems : false,
								id : "id"
							}
						});

		$("#tbl-modelo").jqGrid('navGrid', '#pg-modelo', {
			edit : true,
			add : true,
			del : true,
			search : false
		});
	});
</script>
<c:import url="/layout/footer.jsp"></c:import>
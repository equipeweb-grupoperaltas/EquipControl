<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<c:import url="/layout/header.jsp"></c:import>

<div id="conteudo">
	<table id="tbl-locais"></table>
	<div id="pg-locais"></div>
</div>

<script type="text/javascript">
/** 
	<c:url value="/usuarios/usuario.json"/> */
	$(function() {

		$("#tbl-locais")
				.jqGrid(
						{
							url : '<c:url value="/locais/locais.json"/>',
							editurl : '<c:url value="/locais/actionGrid"/>',
							datatype : "json",
							autowidth : true,
							colNames : [ 'Código', 'Local Fisico', 'Obs.' ],
							colModel : [
									{
										name : 'id',
										index : 'id',
										width : 55,
										sorttype : "long",
										align : "center"
									},
									{
										name : 'local',
										index : 'local',
										editable : true,
										sorttype : "string",
										edittype : "text",
									},	
									{
										name : 'obs',
										index : 'obs',
										sorttype : "textbox",
										width : 200,
										editable : true
									}, ],
							rowNum : 40,
							pager : '#pg-locais',
							height : 500,
							viewrecords : true,
							sortname : 'local',
							sortorder : "desc",
							caption : "Lista de Locais",
							jsonReader : {
								root : "rows", //array containing actual data    
								page : "page", //current page    
								total : "total", //total pages for the query    
								records : "records", //total number of records
								repeatitems : false,
								id : "id"
							}
						});

		$("#tbl-locais").jqGrid('navGrid', '#pg-locais', {
			edit : true,
			add : true,
			del : true,
			search : false
		});
	});
</script>
<c:import url="/layout/footer.jsp"></c:import>
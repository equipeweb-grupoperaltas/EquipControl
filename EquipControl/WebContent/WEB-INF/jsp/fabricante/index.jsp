<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<c:import url="/layout/header.jsp"></c:import>

<div id="conteudo">
	<table id="tbl-fabricante"></table>
	<div id="pg-fabricante"></div>
</div>

<script type="text/javascript">
/** <c:url value="/usuarios/usuario.json"/> */
$(function(){
    $("#tbl-fabricante").jqGrid({
        url : '<c:url value="/fabricantes/fabricante.json"/>',
        editurl:'<c:url value="/fabricantes/actionGrid"/>',
        datatype : "json", 
        autowidth: true,
        colNames : [ 'Código', 'Fabricante'],
        colModel : [ 
        	{name:'id',index:'id', width:55, sorttype:"long", align:"center"},
            {name:'fabricante',index:'fabricante', sorttype:"string", width: 400, editable: true},
        ],
        rowNum : 40,
        pager : '#pg-fabricante',
        height : 500,
        viewrecords : true,
        sortname: 'fabricante',
        sortorder : "desc",
        caption : "Lista de Fabricantes",
        jsonReader : {
        	 root: "rows", //array containing actual data    
        	 page: "page", //current page    
        	 total: "total", //total pages for the query    
        	 records: "records", //total number of records    
        	 repeatitems: false,  
        	 id: "id"  
        }
    });
     
    $("#tbl-fabricante").jqGrid('navGrid','#pg-fabricante',{edit:true,add:true,del:true,search:false});
});
</script>
<c:import url="/layout/footer.jsp"></c:import>
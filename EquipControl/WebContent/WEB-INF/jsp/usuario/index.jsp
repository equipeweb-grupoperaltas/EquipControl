<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<c:import url="/layout/header.jsp"></c:import>

<div id="conteudo">
	<table id="tbl-usuario"></table>
	<div id="pg-usuario"></div>
</div>

<script type="text/javascript">
/** <c:url value="/usuarios/usuario.json"/> */
$(function(){
    $("#tbl-usuario").jqGrid({
        url : '<c:url value="/usuarios/usuario.json"/>',
        editurl:'<c:url value="/usuarios/actionGrid"/>',
        datatype : "json", 
        autowidth: true,
        colNames : [ 'Código', 'Nome', 'E-mail','Celular','Administrador', 'Usuario', 'Password' ],
        colModel : [ 
        	{name:'id',index:'id', width:55, sorttype:"int", align:"center"},
            {name:'nome',index:'nome', width: 200, editable: true},
            {name:'email',index:'email', width: 200, align:"center", editable: true},
            {name:'celular',index:'celular', width: 100, align:"center", editable: true},
            {name:'adm',index:'adm', sorttype:"boolean", editable: true, edittype : "select",formatter:'select', editoptions:{value:{1:'Sim',2:'Não'}}},
            {name:'usuario',index:'usuario', width: 100, editable: true},
            {name:'password',index:'password', width: 200, editable: true}
        ],
        rowNum : 40,
        pager : '#pg-usuario',
        height : 500,
        viewrecords : true,
        sortname: 'nome',
        sortorder : "desc",
        caption : "Lista de Usuários",
        jsonReader : {
        	 root: "rows", //array containing actual data    
        	 page: "page", //current page    
        	 total: "total", //total pages for the query    
        	 records: "records", //total number of records    
        	 repeatitems: false,  
        	 id: "id"  
        }
    });
     
    $("#tbl-usuario").jqGrid('navGrid','#pg-usuario',{edit:true,add:true,del:true,search:false});
});
</script>
<c:import url="/layout/footer.jsp"></c:import>
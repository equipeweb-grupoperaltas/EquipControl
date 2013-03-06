<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<c:import url="/layout/header.jsp"></c:import>

<div id="conteudo">
	<table id="tbl-equipamentos"></table>
	<div id="pg-equipamentos"></div>
</div>

<script type="text/javascript">
$(function(){
    $("#tbl-equipamentos").jqGrid({
        url : '<c:url value="/equipamentos/equipamentos.json"/>',
        editurl:'<c:url value="/equipamentos/actionGrid"/>',
        datatype : "json", 
        autowidth: true,
        colNames : [ 'Código', 'Fabricante','Modelo','Local','IP','Ativo','Monitora','Usuario','Obs.'],
        colModel : [ 
        	{name:'id',index:'id', width:55, sorttype:"long", align:"center"},
            {name:'fabricante.fabricante',index:'fabricante.fabricante', sorttype:"string",edittype : "select",
        		editoptions : {dataUrl : '<c:url value="/fabricantes/select"/>',
        		dataEvents: [
						        {  type: 'change',
       							          fn: function(e) {
											var idd = (this.value);
											$.getJSON('<c:url value="/modelos/select"/>',{id: idd}, function(data){
												 var options = '';
											      for (var i = 0; i < data.list.length; i++) {
											        options += '<option value="' + data.list[i].id + '">' + data.list[i].modelo + '</option>';
											      }
											      $("#modelo\\.modelo").html(options);
											    });
									}
							      } 
						  ]},
        		editable: true},
            {name:'modelo.modelo',index:'modelo.modelo', sorttype:"string", editable: true, edittype: "select",formoptions:{},editoptions:{dataUrl : '<c:url value="/modelos/selectAll"/>'}},
            {name:'local.local',index:'local.local', sorttype:"string",edittype : "select",editoptions : {dataUrl : '<c:url value="/locais/select"/>'}, editable: true},
            {name:'ip',index:'ip', sorttype:"float", editable: true},
            {name:'ativo',index:'ativo', sorttype:"boolean", editable: true, edittype : "select",formatter:'select', editoptions:{value:{1:'Sim',2:'Não'}}},
            {name:'monitora',index:'monitora', sorttype:"boolean", editable: true,edittype : "select",formatter:'select', editoptions:{value:{1:'Sim',2:'Não'}}},
            {name:'usuario.nome',index:'usuario.nome', sorttype:"string",edittype : "select",editoptions : {dataUrl : '<c:url value="/usuarios/select"/>'}, editable: true},
            {name:'obs',index:'obs', sorttype:"string", editable: true}
        ],
        rowNum : 40,
        pager : '#pg-equipamentos',
        height : 500,
        viewrecords : true,
        sortname: 'ativo',
        sortorder : "desc",
        caption : "Lista de Equipamentos",
        jsonReader : {
        	 root: "rows", //array containing actual data    
        	 page: "page", //current page    
        	 total: "total", //total pages for the query    
        	 records: "records", //total number of records    
        	 repeatitems: false,  
        	 id: "id"  
        }
    });
     
    $("#tbl-equipamentos").jqGrid('navGrid','#pg-equipamentos',{edit:true,add:true,del:true,search:false});
});
</script>
<c:import url="/layout/footer.jsp"></c:import>
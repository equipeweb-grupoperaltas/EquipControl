package br.com.grupoperaltas.equipcontrol.controllers;

import java.util.Collection;

import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.view.Results;
import br.com.grupoperaltas.equipcontrol.dao.FabricanteDao;
import br.com.grupoperaltas.equipcontrol.dao.ModeloDao;
import br.com.grupoperaltas.equipcontrol.infra.Public;
import br.com.grupoperaltas.equipcontrol.models.Fabricante;
import br.com.grupoperaltas.equipcontrol.models.Modelo;
import br.com.grupoperaltas.equipcontrol.utils.JQgrid;

/**
 * @classname ModeloController
 * @package   br.com.grupoperaltas.equipcontrol.controllers
 *
 * @author Fabio Pratta <fabiobrotas@hotmail.com>
 * @data 10/01/2013
 * @version 1.0
 * 
 */

@Resource
public class ModeloController {

	private Result result;
	private ModeloDao dao;
	private FabricanteDao fabdao;
	
	public ModeloController(Result result, ModeloDao dao,FabricanteDao fabdao) {
		this.result = result;
		this.dao = dao;
		this.fabdao = fabdao;
	}
	
	@Path ("/modelos")
	public void index(){}
	
	@Path("/modelos/actionGrid")
	public void actionGrid(String oper, String modelo, Long fabricante,String id){
	
		
		Modelo model = new Modelo();
		
		

		//edit
		if(oper.equals("edit")){
			model.setModelo(modelo);
			//get Fabricante
			Fabricante fabn = fabdao.find(fabricante);
			model.setFabricante(fabn);
			model.setId(Long.valueOf(id));
			dao.update(model);
			System.out.print("Editado com Sucesso!");
		}
		
		//Delete
		if(oper.equals("del")){
			model.setId(Long.valueOf(id));
			dao.delete(model);
			System.out.print("Delete com Sucesso!");	
		}
		
		//add
		if(oper.equals("add")){
			model.setModelo(modelo);
			//get Fabricante
			Fabricante fabn = fabdao.find(fabricante);
			model.setFabricante(fabn);
			dao.insert(model);
			System.out.print("Cadastrado com Sucesso!");
		}
		
		result.redirectTo(this).index();
		
	}
	
	@Public
	@Get @Path("/modelos/modelos.json")
	 public void loadGrid(Integer page, Integer rows, String sidx, String sord){
		   @SuppressWarnings("unchecked")
			Collection<Modelo> model = dao.fetchGrid(sidx,sord,page,rows); 
		    Collection<Modelo> modelAll = dao.fetchAll();
	        JQgrid<Modelo> JQgrid = new JQgrid<Modelo>();
	        JQgrid.setPage(page);
	        JQgrid.setRecords(modelAll.size());
	        JQgrid.setTotal((int)Math.ceil((double)modelAll.size() / (double)rows));
	        JQgrid.setRows(model);
	        //result.use(Results.json()).withoutRoot().from(JQgrid).recursive().include("rows").serialize(); 
	       result.use(Results.json()).withoutRoot().from(JQgrid).recursive().serialize();
    }
	
	
	@Get @Path ("/modelos/select")
	public void select(Long id){
		result.use(Results.json()).from(dao.findFabricante(id)).recursive().serialize();
	}
	
	@Get @Path ("/modelos/selectAll")
	public void selectAll(){
		result.include("modeloArray", dao.fetchAll());
	}
}

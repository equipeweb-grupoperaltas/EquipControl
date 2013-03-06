package br.com.grupoperaltas.equipcontrol.controllers;

import java.util.Collection;

import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.Validator;
import br.com.caelum.vraptor.view.Results;
import br.com.grupoperaltas.equipcontrol.dao.FabricanteDao;
import br.com.grupoperaltas.equipcontrol.infra.Public;
import br.com.grupoperaltas.equipcontrol.models.Fabricante;
import br.com.grupoperaltas.equipcontrol.utils.JQgrid;

/**
 * @classname FabricanteController
 * @package   br.com.grupoperaltas.equipcontrol.controllers
 *
 * @author Fabio Pratta <fabiobrotas@hotmail.com>
 * @data 09/01/2013
 * @version 1.0
 * 
 */

@Resource
public class FabricanteController {

	private final Result result;
	private FabricanteDao dao;
	
	
	public FabricanteController(Result result, FabricanteDao dao, Validator validator) {
		this.result = result;
		this.dao = dao;
	}
	
	
	@Path("/fabricantes")
	public void index(){}
	
	
	
	@Path("/fabricantes/actionGrid")
	public void actionGrid(String oper,String fabricante,String id){
		
		System.out.print("Operação:"+oper+"Fabricante:"+fabricante+"ID:"+id);
		
		Fabricante fab = new Fabricante();	

		//edit
		if(oper.equals("edit")){
			fab.setFabricante(fabricante);	 
			fab.setId(Long.valueOf(id));
			dao.update(fab);
			System.out.print("Editado com Sucesso!");
		}
		
		//Delete
		if(oper.equals("del")){
			fab.setId(Long.valueOf(id));
			dao.delete(fab);
			System.out.print("Delete com Sucesso!");	
		}
		
		//add
		if(oper.equals("add")){
			fab.setFabricante(fabricante);	 
			dao.insert(fab);
			System.out.print("Cadastrado com Sucesso!");
		}
		
		result.redirectTo(this).index();
		
	}
	
	@Public
	@Get @Path("/fabricantes/fabricante.json")
	 public void loadGrid(Integer page, Integer rows, String sidx, String sord){
		   @SuppressWarnings("unchecked")
			Collection<Fabricante> fabricante = dao.fetchGrid(sidx, sord,page,rows);
		    Collection<Fabricante> fabricanteAll = dao.fetchAll();
	        JQgrid<Fabricante> JQgrid = new JQgrid<Fabricante>();
	        JQgrid.setPage(page);
	        JQgrid.setRecords(fabricanteAll.size());
	        JQgrid.setTotal((int)Math.ceil((double)fabricanteAll.size() / (double)rows));
	        JQgrid.setRows(fabricante);
	        result.use(Results.json()).withoutRoot().from(JQgrid).include("rows").serialize();
    }
	
	
	@Get @Path ("/fabricantes/select")
	public void select(){
		result.include("fabricantesArray", dao.fetchAll());
	}
}

package br.com.grupoperaltas.equipcontrol.controllers;

import java.util.Collection;

import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.view.Results;
import br.com.grupoperaltas.equipcontrol.dao.LocalFisicoDao;
import br.com.grupoperaltas.equipcontrol.infra.Public;
import br.com.grupoperaltas.equipcontrol.models.LocalFisico;
import br.com.grupoperaltas.equipcontrol.utils.JQgrid;

/**
 * @classname LocaisController
 * @package   br.com.grupoperaltas.equipcontrol.controllers
 *
 * @author Fabio Pratta <fabiobrotas@hotmail.com>
 * @data 04/02/2013
 * @version 1.0
 * 
 */

@Resource
public class LocaisController {

	private final Result result;
	private LocalFisicoDao dao;
	
	
	public LocaisController(Result result, LocalFisicoDao dao){
		this.result = result;
		this.dao = dao;
	}
	
	@Path("/locais")
	public void index(){}
	
	//Action for save and edit or delete
	@Path("/locais/actionGrid")
	public void actionGrid(String oper, String local, String obs,String id){
	
		LocalFisico localFisico = new LocalFisico();
		
	
		//edit
		if(oper.equals("edit")){
			localFisico.setLocal(local);
			localFisico.setObs(obs);
			localFisico.setId(Long.valueOf(id));
			dao.update(localFisico);
			System.out.print("Editado com Sucesso!");
		}
		
		//Delete
		if(oper.equals("del")){
			localFisico.setId(Long.valueOf(id));
			dao.delete(localFisico);
			System.out.print("Delete com Sucesso!");	
		}
		
		//add
		if(oper.equals("add")){
			localFisico.setLocal(local);
			localFisico.setObs(obs);
			dao.insert(localFisico);
			System.out.print("Cadastrado com Sucesso!");
		}
		
		result.redirectTo(this).index();
		
	}
	
	
	//get Json List
	@Public
	@Get @Path("/locais/locais.json")
	 public void loadGrid(Integer page, Integer rows, String sidx, String sord){
		   @SuppressWarnings("unchecked")
			Collection<LocalFisico> localFisico = dao.fetchGrid(sidx, sord,page,rows);
		    Collection<LocalFisico> localFisicoAll = dao.fetchAll();
	        JQgrid<LocalFisico> JQgrid = new JQgrid<LocalFisico>();
	        JQgrid.setPage(page);
	        JQgrid.setRecords(localFisicoAll.size());
	        JQgrid.setTotal((int)Math.ceil((double)localFisicoAll.size() / (double)rows));
	        JQgrid.setRows(localFisico);
	        result.use(Results.json()).withoutRoot().from(JQgrid).include("rows").serialize();
    }
	
	
	@Get @Path ("/locais/select")
	public void select(){
		result.include("locaisArray", dao.fetchAll());
	}
}

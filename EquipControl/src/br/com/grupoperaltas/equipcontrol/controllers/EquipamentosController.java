package br.com.grupoperaltas.equipcontrol.controllers;

import java.util.Collection;

import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.view.Results;
import br.com.grupoperaltas.equipcontrol.dao.EquipamentoDao;
import br.com.grupoperaltas.equipcontrol.dao.FabricanteDao;
import br.com.grupoperaltas.equipcontrol.dao.LocalFisicoDao;
import br.com.grupoperaltas.equipcontrol.dao.ModeloDao;
import br.com.grupoperaltas.equipcontrol.dao.UsuariosDao;
import br.com.grupoperaltas.equipcontrol.infra.Public;
import br.com.grupoperaltas.equipcontrol.models.Equipamento;
import br.com.grupoperaltas.equipcontrol.models.Fabricante;
import br.com.grupoperaltas.equipcontrol.models.LocalFisico;
import br.com.grupoperaltas.equipcontrol.models.Modelo;
import br.com.grupoperaltas.equipcontrol.models.Usuario;
import br.com.grupoperaltas.equipcontrol.utils.JQgrid;

/**
 * @classname EquipamentosController
 * @package   br.com.grupoperaltas.equipcontrol.controllers
 *
 * @author Fabio Pratta <fabiobrotas@hotmail.com>
 * @data 04/02/2013
 * @version 1.0
 * 
 */

@Resource
public class EquipamentosController {

	private final Result result;
	private EquipamentoDao dao;
	private FabricanteDao fabdao;
	private ModeloDao moddao;
	private LocalFisicoDao locdao;
	private UsuariosDao userdao;
	
	
	/**
	 * Construct
	 */
	public EquipamentosController(Result result, EquipamentoDao dao, FabricanteDao fabdao, ModeloDao moddao, LocalFisicoDao locdao, UsuariosDao userdao) {
	 this.result = result;
	 this.dao = dao;
	 this.fabdao = fabdao;
	 this.locdao = locdao;
	 this.moddao = moddao;
	 this.userdao = userdao;
	}
	
	
	//Index Action
	@Path("/equipamentos")
	public void index(){}
	
	
	//Save and Edit or Delete
	@Path("/equipamentos/actionGrid")
	public void actionGrid(String oper,String fabricante,String modelo,String local, String ip, String ativo, String monitora, Long usuario, String obs,String id){
		
		//set obj
		Equipamento equipamento = new Equipamento();
		
		
		//edit
		if(oper.equals("edit")){
			//get Fabricante
			Fabricante fabn = fabdao.find(Long.valueOf(fabricante));
			//get Local
			LocalFisico loc = locdao.find(Long.valueOf(local));
			//get modelo
			Modelo mod = moddao.find(Long.valueOf(modelo));
			//get user
			Usuario usr = userdao.find(usuario);
			//set params
			equipamento.setFabricante(fabn);
			equipamento.setModelo(mod);
			equipamento.setLocal(loc);
			equipamento.setIp(ip);
			//check
			equipamento.setAtivo(Integer.valueOf(ativo));	
			equipamento.setMonitora(Integer.valueOf(monitora));
			equipamento.setUsuario(usr);
			equipamento.setObs(obs);
			equipamento.setId(Long.valueOf(id));
			dao.update(equipamento);
			System.out.print("Editado com Sucesso!");
		}
		
		//Delete
		if(oper.equals("del")){
			equipamento.setId(Long.valueOf(id));
			dao.delete(equipamento);
			System.out.print("Delete com Sucesso!");	
		}
		
		//add
		if(oper.equals("add")){
			//get Fabricante
			Fabricante fabn = fabdao.find(Long.valueOf(fabricante));
			//get Local
			LocalFisico loc = locdao.find(Long.valueOf(local));
			//get modelo
			Modelo mod = moddao.find(Long.valueOf(modelo));
			//get user
			Usuario usr = userdao.find(usuario);
			//set params
			equipamento.setFabricante(fabn);
			equipamento.setModelo(mod);
			equipamento.setLocal(loc);
			equipamento.setIp(ip);
			//check
			equipamento.setAtivo(Integer.valueOf(ativo));	
			equipamento.setMonitora(Integer.valueOf(monitora));
			equipamento.setUsuario(usr);
			equipamento.setObs(obs);
			dao.insert(equipamento);
			System.out.print("Cadastrado com Sucesso!");
		}
		
		result.redirectTo(this).index();
		
	}
	
	//Get Equipaments for List
	@Public
	@Get @Path("/equipamentos/equipamentos.json")
	 public void loadGrid(Integer page, Integer rows, String sidx, String sord){
		   @SuppressWarnings("unchecked")
			Collection<Equipamento> equipamento = dao.fetchGrid(sidx, sord,page,rows);
		    Collection<Equipamento> equipamentoAll = dao.fetchAll();
	        JQgrid<Equipamento> JQgrid = new JQgrid<Equipamento>();
	        JQgrid.setPage(page);
	        JQgrid.setRecords(equipamentoAll.size());
	        JQgrid.setTotal((int)Math.ceil((double)equipamentoAll.size() / (double)rows));
	        JQgrid.setRows(equipamento);
	        result.use(Results.json()).withoutRoot().from(JQgrid).recursive().serialize();
    }
	
	
	
	
}

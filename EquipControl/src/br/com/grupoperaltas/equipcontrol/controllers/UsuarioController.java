package br.com.grupoperaltas.equipcontrol.controllers;

import java.util.Collection;

import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.view.Results;
import br.com.grupoperaltas.equipcontrol.dao.UsuariosDao;
import br.com.grupoperaltas.equipcontrol.infra.Public;
import br.com.grupoperaltas.equipcontrol.models.Usuario;
import br.com.grupoperaltas.equipcontrol.utils.JQgrid;

/**
 * @classname UsuarioController
 * @package   br.com.grupoperaltas.equipcontrol.controllers
 *
 * @author Fabio Pratta <fabiobrotas@hotmail.com>
 * @data 08/01/2013
 * @version 1.0
 * 
 */

@Resource
public class UsuarioController {
	
	private final Result result;
	private UsuariosDao dao;
	
	public UsuarioController(Result result, UsuariosDao dao) {
		this.result= result;
		this.dao = dao;
	}
	
	
	@Path("/usuarios")
	public void index(){}
	
	@Path("/usuarios/actionGrid")
	public void actionGrid(String oper, String nome,String celular, String adm, String email, String usuario, String password,String id){
		Usuario user = new Usuario();
		
		user.setEmail(email);
		user.setNome(nome);
		user.setUsuario(usuario);
		user.setCelular(celular);
		user.setAdm(adm);
		

		//edit
		if(oper.equals("edit")){
			user.setPassword(password);
			user.setId(Long.valueOf(id));
			dao.update(user);
			System.out.print("Editado com Sucesso!");
		}
		
		//Delete
		if(oper.equals("del")){
			user.setId(Long.valueOf(id));
			dao.delete(user);
			System.out.print("Delete com Sucesso!");	
		}
		
		//add
		if(oper.equals("add")){
			user.setPassword(password);
			dao.insert(user);
			System.out.print("Cadastrado com Sucesso!");
		}
		
		result.redirectTo(this).index();
		
	}
	
	@Public
	@Get @Path("/usuarios/usuario.json")
	 public void loadGrid(Integer page, Integer rows, String sidx, String sord){
		   @SuppressWarnings("unchecked")
			Collection<Usuario> users = dao.fetchGrid(sidx, sord,page,rows);
		    Collection<Usuario> usersAll = dao.fetchAll();
	        JQgrid<Usuario> JQgrid = new JQgrid<Usuario>();
	        JQgrid.setPage(page);
	        JQgrid.setRecords(usersAll.size());
	        JQgrid.setTotal((int)Math.ceil((double)usersAll.size() / (double)rows));
	        JQgrid.setRows(users);
	        result.use(Results.json()).withoutRoot().from(JQgrid).include("rows").serialize();
    }
	
	
	@Get @Path ("/usuarios/select")
	public void select(){
		result.include("usuariosArray", dao.fetchAll());
	}
}

package br.com.grupoperaltas.equipcontrol.dao;


import java.util.Collection;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import br.com.caelum.vraptor.ioc.Component;
import br.com.grupoperaltas.equipcontrol.models.Usuario;

/**
 * @classname UsuariosDao
 * @package   br.com.grupoperaltas.equipcontrol,.dao
 *
 * @author Fabio Pratta <fabiobrotas@hotmail.com>
 * @data 11/12/2012
 * @version 1.0
 * 
 */


@Component
public class UsuariosDao {

	
	
	private final Session session;
	
    
	public UsuariosDao(Session session) {
        this.session = session;
    }
	
	/**
	 * INSERT
	 * @param usuario
	 */
	public void insert(Usuario usuario){
		Transaction tx = session.beginTransaction();
        session.save(usuario);
        tx.commit();	
	}
	
	
	/**
	 * UPDATE
	 * @param usuario
	 */
	public void update(Usuario usuario){
		Transaction tx = session.beginTransaction();
        session.update(usuario);
        tx.commit();	
	}
	
	
	/**
	 * DELETE
	 * @param usuario
	 */
	
	public void delete(Usuario usuario){
		Transaction tx = session.beginTransaction();
        session.delete(usuario);
        tx.commit();	
	}
	
	/**
	 * FIND
	 * @param id
	 * @return
	 */
	public Usuario find(Long id) {
	       return (Usuario) this.session.load(Usuario.class, id);
	}
	
	
	/**
	 * FETCHALL
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<Usuario>  fetchAll(){
		return session.createCriteria(Usuario.class).list();	
	}
	
	
	/**
	 * Fetch Grid
	 */
	
	@SuppressWarnings("rawtypes")
	public Collection fetchGrid(String sidx, String sord,Integer page_p,Integer rows_p){
		
		Integer firstResult;
		
		if(page_p == 1){
			firstResult = 0;
		}else{
			firstResult = (page_p * rows_p) - 1;
		}
		
		//set order
		Order order;
		if(sord.equals("asc")){
			 order = Order.asc(sidx);
		}else{
			 order = Order.desc(sidx);
		}
		return session.createCriteria(Usuario.class).addOrder(order).setMaxResults(rows_p).setFirstResult(firstResult).list();
	}
	
 
    /**
     * AUTENTICAR
     * @param usuario
     * @param password
     * @return
     */
	public Usuario autenticar(String usuario, String password) {
		       return (Usuario) session.createCriteria(Usuario.class)
		    		   .add(Restrictions.eq("usuario", usuario))
		    		   .add(Restrictions.eq("password", password))
		    		   .uniqueResult();
 	}
	
	
	

}

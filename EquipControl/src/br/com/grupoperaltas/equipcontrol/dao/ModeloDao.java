package br.com.grupoperaltas.equipcontrol.dao;

import java.util.Collection;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import br.com.caelum.vraptor.ioc.Component;
import br.com.grupoperaltas.equipcontrol.models.Modelo;

/**
 * @classname ModeloDao
 * @package   br.com.grupoperaltas.equipcontrol.dao
 *
 * @author Fabio Pratta <fabiobrotas@hotmail.com>
 * @data 08/01/2013
 * @version 1.0
 * 
 */


@Component
public class ModeloDao {

	private Session session;
	
	public ModeloDao(Session session){
		this.session = session;
	}
	
	/**
	 * Insert 
	 * @param modelo
	 */
	
	public void insert(Modelo modelo){
		Transaction tx = session.beginTransaction();
		session.save(modelo);
		tx.commit();
	}
	
	/**
	 * Update
	 * @param modelo
	 */
	public void update(Modelo modelo){
		Transaction tx = session.beginTransaction();
		session.update(modelo);
		tx.commit();
	}
	
	/**
	 * Delete
	 * @param modelo
	 */
	public void delete(Modelo modelo){
		Transaction tx = session.beginTransaction();
		session.delete(modelo);
		tx.commit();
	}
	
	
	/**
	 * FIND
	 * @param id
	 * @return
	 */
	public Modelo find(Long id) {
	       return (Modelo) this.session.load(Modelo.class, id);
	}
	
	
	/**
	 * FETCHALL
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<Modelo> fetchAll(){
		return session.createCriteria(Modelo.class).list();
	}
	
	
	/**
	 * Find Fabricante
	 * @param id
	 * @return 
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	public List findFabricante(Long id) {
		return this.session.createCriteria(Modelo.class).add(Restrictions.eq("fabricante.id", id)).list();
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
		return session.createCriteria(Modelo.class).addOrder(order).setMaxResults(rows_p).setFirstResult(firstResult).list();
	}
}

package br.com.grupoperaltas.equipcontrol.dao;

import java.util.Collection;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Order;

import br.com.caelum.vraptor.ioc.Component;
import br.com.grupoperaltas.equipcontrol.models.Fabricante;

/**
 * @classname FabricanteDao
 * @package   br.com.grupoperaltas.equipcontrol.dao
 *
 * @author Fabio Pratta <fabiobrotas@hotmail.com>
 * @data 08/01/2013
 * @version 1.0
 * 
 */

@Component
public class FabricanteDao {

	private final Session session;
	
	public FabricanteDao(Session session){
		this.session = session;
	}
	
	/**
	 * Insert
	 * @param fabricante
	 */
	public void insert(Fabricante fabricante){
		Transaction tx = session.beginTransaction();
        session.save(fabricante);
        tx.commit();	
	}
	
	
	/**
	 * update
	 * @param fabricante
	 */
	public void update(Fabricante fabricante){
		Transaction tx = session.beginTransaction();
        session.update(fabricante);
        tx.commit();	
	}
	
	
	/**
	 * delete
	 * @param fabricante
	 */
	
	public void delete(Fabricante fabricante){
		Transaction tx = session.beginTransaction();
        session.delete(fabricante);
        tx.commit();	
	}
	
	/**
	 * FIND
	 * @param id
	 * @return
	 */
	public Fabricante find(Long id) {
	       return (Fabricante) this.session.load(Fabricante.class, id);
	}
	
	
	/**
	 * FETCHALL
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<Fabricante> fetchAll(){
		return session.createCriteria(Fabricante.class).list();
		
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
		return session.createCriteria(Fabricante.class).addOrder(order).setMaxResults(rows_p).setFirstResult(firstResult).list();
	}
	
}

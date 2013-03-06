package br.com.grupoperaltas.equipcontrol.dao;

import java.util.Collection;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Order;

import br.com.caelum.vraptor.ioc.Component;
import br.com.grupoperaltas.equipcontrol.models.LocalFisico;

/**
 * @classname LocalFisicoDao
 * @package   br.com.grupoperaltas.equipcontrol.dao
 *
 * @author Fabio Pratta <fabiobrotas@hotmail.com>
 * @data 08/01/2013
 * @version 1.0
 * 
 */

@Component
public class LocalFisicoDao {

	private Session session;
	
	public LocalFisicoDao(Session session){
		this.session = session;
	}
	
	
	/**
	 * Insert
	 * @param fabricante
	 */
	public void insert(LocalFisico localFisico){
		Transaction tx = session.beginTransaction();
        session.save(localFisico);
        tx.commit();	
	}
	
	
	/**
	 * update
	 * @param fabricante
	 */
	public void update(LocalFisico localFisico){
		Transaction tx = session.beginTransaction();
        session.update(localFisico);
        tx.commit();	
	}
	
	
	/**
	 * delete
	 * @param fabricante
	 */
	
	public void delete(LocalFisico localFisico){
		Transaction tx = session.beginTransaction();
        session.delete(localFisico);
        tx.commit();	
	}
	
	/**
	 * FIND
	 * @param id
	 * @return
	 */
	public LocalFisico find(Long id) {
	       return (LocalFisico) this.session.load(LocalFisico.class, id);
	}
	
	
	/**
	 * FETCHALL
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<LocalFisico> fetchAll(){
		return session.createCriteria(LocalFisico.class).list();
		
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
		return session.createCriteria(LocalFisico.class).addOrder(order).setMaxResults(rows_p).setFirstResult(firstResult).list();
	}
}

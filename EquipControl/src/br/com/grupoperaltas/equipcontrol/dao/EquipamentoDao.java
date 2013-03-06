package br.com.grupoperaltas.equipcontrol.dao;

import java.util.Collection;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Order;

import br.com.caelum.vraptor.ioc.Component;
import br.com.grupoperaltas.equipcontrol.models.Equipamento;

/**
 * @classname EquipamentoDao
 * @package   br.com.grupoperaltas.equipcontrol.dao
 *
 * @author Fabio Pratta <fabiobrotas@hotmail.com>
 * @data 08/01/2013
 * @version 1.0
 * 
 */
@Component
public class EquipamentoDao {

	private Session session;
	
	/**
	 * Construct
	 * @param session
	 */
	public EquipamentoDao(Session session) {
		this.session = session;
	}
	
	
	/**
	 * Insert
	 * @param equipamento
	 */
	public void insert(Equipamento equipamento){
		Transaction tx = session.beginTransaction();
        session.save(equipamento);
        tx.commit();	
	}
	
	
	/**
	 * update
	 * @param equipamento
	 */
	public void update(Equipamento equipamento){
		Transaction tx = session.beginTransaction();
        session.update(equipamento);
        tx.commit();	
	}
	
	
	/**
	 * delete
	 * @param equipamento
	 */
	
	public void delete(Equipamento equipamento){
		Transaction tx = session.beginTransaction();
        session.delete(equipamento);
        tx.commit();	
	}
	
	/**
	 * FIND
	 * @param id
	 * @return
	 */
	public Equipamento find(Long id) {
	       return (Equipamento) this.session.load(Equipamento.class, id);
	}
	
	
	/**
	 * FETCHALL
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<Equipamento> fetchAll(){
		return session.createCriteria(Equipamento.class).list();
		
	}
	
	
	/**
	 * Return Fetch for JqGrid
	 * @param sidx
	 * @param sord
	 * @param page_p
	 * @param rows_p
	 * @return
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
		return session.createCriteria(Equipamento.class).addOrder(order).setMaxResults(rows_p).setFirstResult(firstResult).list();
	}
}

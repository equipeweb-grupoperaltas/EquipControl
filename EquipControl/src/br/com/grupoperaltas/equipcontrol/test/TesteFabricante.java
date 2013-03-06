package br.com.grupoperaltas.equipcontrol.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import br.com.grupoperaltas.equipcontrol.dao.FabricanteDao;
import br.com.grupoperaltas.equipcontrol.infra.SessionFactoryMysql;
import br.com.grupoperaltas.equipcontrol.infra.SessionMysql;
import br.com.grupoperaltas.equipcontrol.models.Fabricante;

/**
 * @classname TesteFabricante
 * @package   br.com.grupoperaltas.equipcontrol.test
 *
 * @author Fabio Pratta <fabiobrotas@hotmail.com>
 * @data 08/01/2013
 * @version 1.0
 * 
 */
public class TesteFabricante {

	public static void main(String[] args) {
		
		Fabricante fabricante = new Fabricante();
		
		fabricante.setFabricante("Teste Aqui");
		
		SessionFactory factory = new SessionFactoryMysql().getInstance();
		Session session = new SessionMysql(factory).getInstance();
		
		//insert
		
		FabricanteDao dao = new FabricanteDao(session);
		dao.insert(fabricante);
		
	}
}

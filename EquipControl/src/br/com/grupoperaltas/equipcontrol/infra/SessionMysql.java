package br.com.grupoperaltas.equipcontrol.infra;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import br.com.caelum.vraptor.ioc.Component;
import br.com.caelum.vraptor.ioc.ComponentFactory;
/**
 * @classname SessionMysql
 * @package   br.com.grupoperaltas.equipcontrol.infra
 *
 * @author Fabio Pratta <fabiobrotas@hotmail.com>
 * @data 02/01/2013
 * @version 1.0
 * 
 */

@Component
public class SessionMysql implements ComponentFactory<Session> {

	private final SessionFactory factory;
	private Session session;

	public SessionMysql(SessionFactory factory) {
		this.factory = factory;
	}

	@PostConstruct
	public void abre() {
		this.session = factory.openSession();
	}

	public Session getInstance() {
		return this.session;
	}

	@PreDestroy
	public void fecha() {
		this.session.close();
	}

}

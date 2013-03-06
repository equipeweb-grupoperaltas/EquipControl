package br.com.grupoperaltas.equipcontrol.infra;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

import br.com.caelum.vraptor.ioc.ApplicationScoped;
import br.com.caelum.vraptor.ioc.Component;
import br.com.caelum.vraptor.ioc.ComponentFactory;

/**
 * @classname SessionFactoryMysql
 * @package   br.com.grupoperaltas.equipcontrol.infra
 *
 * @author Fabio Pratta <fabiobrotas@hotmail.com>
 * @data 02/01/2013
 * @version 1.0
 * 
 */

@SuppressWarnings("deprecation")
@Component
@ApplicationScoped
public class SessionFactoryMysql implements ComponentFactory<SessionFactory> {

	private SessionFactory factory;
	
    @PostConstruct
    public void abre() {
        AnnotationConfiguration configuration = new AnnotationConfiguration();
        configuration.configure("mysql.cfg.xml");
        this.factory = configuration.buildSessionFactory();;
    }
    
    
    public SessionFactory getInstance() {
        return this.factory;
    }
    
    
    @PreDestroy
    public void fecha() {
        this.factory.close();
    }

}

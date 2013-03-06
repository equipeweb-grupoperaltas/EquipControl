package br.com.grupoperaltas.equipcontrol.infra;

import java.io.Serializable;

import br.com.caelum.vraptor.ioc.Component;
import br.com.caelum.vraptor.ioc.SessionScoped;
import br.com.grupoperaltas.equipcontrol.models.Usuario;
/**
 * @classname UserSession
 * @package   br.com.grupoperaltas.equipcontrol.infra
 *
 * @author Fabio Pratta <fabiobrotas@hotmail.com>
 * @data 02/01/2013
 * @version 1.0
 * 
 */
@Component
@SessionScoped
public class UserSession implements Serializable {
	 
	private static final long serialVersionUID = 1L;
	private Usuario user;
	
	public boolean isLogged() {
		 return user != null;
	}
		
    public void logout() {
		 user = null;
    }

	public Usuario getUser() {
		return user;
	}

	public void setUser(Usuario user) {
		this.user = user;
	}

    

}

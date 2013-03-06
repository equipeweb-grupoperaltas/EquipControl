package br.com.grupoperaltas.equipcontrol.utils;

import br.com.caelum.vraptor.Intercepts;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.core.InterceptorStack;
import br.com.caelum.vraptor.interceptor.Interceptor;
import br.com.caelum.vraptor.resource.ResourceMethod;
import br.com.grupoperaltas.equipcontrol.controllers.LoginController;
import br.com.grupoperaltas.equipcontrol.infra.Public;
import br.com.grupoperaltas.equipcontrol.infra.UserSession;

/**
 * @classname LoginInterceptor
 * @package   br.com.grupoperaltas.equipcontrol.utils
 *
 * @author Fabio Pratta <fabiobrotas@hotmail.com>
 * @data 02/01/2013
 * @version 1.0
 * 
 */

@Intercepts
public class LoginInterceptor implements Interceptor {

	    private Result result;
	    private UserSession userSession;

	    public LoginInterceptor(Result result, UserSession userSession) {
	        this.result = result;
	        this.userSession = userSession;
	    }

	    public boolean accepts(ResourceMethod method) {
	        return
	            !(method.getMethod().isAnnotationPresent(Public.class) ||
	            method.getResource().getType().isAnnotationPresent(Public.class));
	    }

	    public void intercept(InterceptorStack stack, ResourceMethod method, Object resourceInstance) {
	        if (userSession.isLogged()) {
	            stack.next(method, resourceInstance);
	        } else {
	            result.redirectTo(LoginController.class).login();
	        }
	    }

}

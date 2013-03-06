package br.com.grupoperaltas.equipcontrol.controllers;

import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;
import br.com.grupoperaltas.equipcontrol.dao.UsuariosDao;
import br.com.grupoperaltas.equipcontrol.infra.Public;
import br.com.grupoperaltas.equipcontrol.infra.UserSession;
import br.com.grupoperaltas.equipcontrol.models.Usuario;
/**
 * @classname LoginController
 * @package   br.com.grupoperaltas.equipcontrol.controllers
 *
 * @author Fabio Pratta <fabiobrotas@hotmail.com>
 * @data 11/12/2012
 * @version 1.0
 * 
 */
@Resource
public class LoginController {

    private Result result;
    private UserSession userSession;
    private UsuariosDao business;

    public LoginController(Result result, UserSession userSession, UsuariosDao dao) {
        this.result = result;
        this.userSession = userSession;
        this.business = dao;
    }

    @Public
    @Get("/login")
    public void login() {

    }

    @Public
    @Post("/autenticar")
    public void autenticar(Usuario usuario) {
    	System.out.println(usuario.getUsuario() + usuario.getPassword());
        Usuario user = business.autenticar(usuario.getUsuario(), usuario.getPassword());
        if (user != null) {
            userSession.setUser(user);
            result.redirectTo(IndexController.class).index();
        } else {
            result.include("error", "Usuario ou senha incorreta!").redirectTo(this).login();
            result.include(usuario);
            
        }
    }

    @Get("/logout")
    public void logout() {
        userSession.logout();
        result.redirectTo(this).login();
    }


}

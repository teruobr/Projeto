/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import bean.Usuario;
import facade.UsuarioFacade;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author Thiago
 */
@Stateless(mappedName = "ejb/RUsuario")
public class RUsuario implements RUsuarioRemote{
    
    @EJB
    UsuarioFacade facade;

    @Override
    public List<Usuario> consultarUsuario(Usuario usuario) {
         return facade.getConsultaUsuario(usuario);
    }
    
    @Override
    public Usuario consultaUsuario(long id) {
        return facade.getConsultaUsuarioID(id);
    }
    
}

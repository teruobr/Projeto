/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import bean.Usuario;
import java.util.List;
import javax.ejb.Remote;

/**
 *
 * @author Thiago
 */
@Remote
public interface RUsuarioRemote {
    
        public List<Usuario> consultarUsuario(Usuario usuario);
        
        public Usuario consultaUsuario(long id);
    
}

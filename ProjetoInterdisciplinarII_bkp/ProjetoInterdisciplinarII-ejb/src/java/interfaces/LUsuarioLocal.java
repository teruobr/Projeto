/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import bean.Usuario;
import javax.ejb.Local;

/**
 *
 * @author 31049184
 */
@Local
public interface LUsuarioLocal {
    
    public void incluir(Usuario pessoa);
    public void alterar(Usuario pessoa);
    public void excluir(Usuario pessoa);
    
    
}

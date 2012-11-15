/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import bean.Universidade;
import java.util.List;
import javax.ejb.Remote;

/**
 *
 * @author Administrator
 */

@Remote
public interface RUniversidadeRemote {
    
    public void incluir(Universidade area);

    public void alterar(Universidade area);

    public void excluir(Universidade area);

    public List<Universidade> consultar();
}

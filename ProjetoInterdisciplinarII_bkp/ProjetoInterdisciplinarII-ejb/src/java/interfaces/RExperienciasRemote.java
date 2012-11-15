/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import bean.Experiencias;
import java.util.List;
import javax.ejb.Remote;

/**
 *
 * @author U0155712/Administrator
 */
@Remote
public interface RExperienciasRemote {
    
    public void incluir(Experiencias experiencias);
    
    public void alterar(Experiencias experiencias);
    
    public void excluir(Experiencias experiencias);
    
    public List<Experiencias> consultar(Experiencias experiencias);
    
    public List<Experiencias> consultarCnpjEmpresa(Experiencias experiencias);
            
}

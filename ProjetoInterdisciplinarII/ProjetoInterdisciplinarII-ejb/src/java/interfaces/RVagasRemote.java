/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import bean.Vagas;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Remote;

/**
 *
 * @author 31049184
 */
@Remote
public interface RVagasRemote {
    
    public void incluir(Vagas vaga);
    public void alterar(Vagas vaga);
    public void excluir(Vagas vaga);
    public Vagas consultarID(Vagas vaga);
    public List<Vagas> consultar(Vagas vaga);
    public List<Vagas> consultarWeb(Vagas vaga);
    
}

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import bean.Experiencias;
import facade.ExperienciasFacade;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author U0155712/Administrator
 */
@Stateless(mappedName = "RExperiencias")
public class RExperiencias implements RExperienciasRemote {
    
    @EJB
    ExperienciasFacade facade;

    @Override
    public void incluir(Experiencias experiencias) {
        facade.create(experiencias);
    }

    @Override
    public void alterar(Experiencias experiencias) {
       facade.edit(experiencias);
    }

    @Override
    public void excluir(Experiencias experiencias) {
         facade.remove(experiencias);
    }

    @Override
    public List<Experiencias> consultar(Experiencias experiencias) {
           return facade.getExp(experiencias);
    }
    
    @Override
    public List<Experiencias> consultarCnpjEmpresa(Experiencias experiencias) {
        return facade.getCNPJEmpresa(experiencias);
    }      
    
}

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import bean.AreaAtuacao;
import bean.Universidade;
import facade.AreaAtuacaoFacade;
import facade.UniversidadeFacade;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author Administrator
 */
@Stateless(mappedName = "RUniversidade")
public class RUniversidade implements RUniversidadeRemote {
    
    @EJB
    UniversidadeFacade facade;
    
    @Override
    public void incluir(Universidade uni) {
        facade.create(uni);
    }

    @Override
    public void alterar(Universidade uni) {
        facade.edit(uni);
    }

    @Override
    public void excluir(Universidade uni) {
        facade.remove(uni);
    }

    @Override
    public List<Universidade> consultar() {
       return facade.getConsultaUniversidade();
    }    
}

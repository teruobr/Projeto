/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import bean.AreaAtuacao;
import facade.AreaAtuacaoFacade;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
/**
 *
 * @author 31010296
 */
@Stateless(mappedName = "RAreaAtuacao")
public class RAreaAtuacao implements RAreaAtuacaoRemote {
    
    @EJB
    AreaAtuacaoFacade facade;

    @Override
    public void incluir(AreaAtuacao area) {
        facade.create(area);
    }

    @Override
    public void alterar(AreaAtuacao area) {
        facade.edit(area);
    }

    @Override
    public void excluir(AreaAtuacao area) {
        facade.remove(area);
    }

    @Override
    public List<AreaAtuacao> consultar() {
       return facade.getConsultaAreaAtuacao();
    }    
}

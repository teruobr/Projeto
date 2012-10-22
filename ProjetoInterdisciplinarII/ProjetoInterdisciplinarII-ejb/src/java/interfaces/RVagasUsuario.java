/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import bean.VagasUsuario;
import facade.VagasUsuarioFacade;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author Felipe
 */
@Stateless(mappedName = "RVagasUsuario")
public class RVagasUsuario implements RVagasUsuarioRemote {
    
    @EJB
    VagasUsuarioFacade facade;

    @Override
    public void incluir(VagasUsuario vaga) {
        facade.create(vaga);
    }

    @Override
    public void alterar(VagasUsuario vaga) {
        facade.edit(vaga);
    }

    @Override
    public void excluir(VagasUsuario vaga) {
        facade.remove(vaga);
    }

    @Override
    public VagasUsuario consultarID(VagasUsuario vaga) {
        return facade.getConsultaVagaUsuarioID(vaga.getId());
    }
    @Override
    public VagasUsuario validaUsuarioVaga(VagasUsuario vaga) {
        return facade.validaVagaUsuario(vaga);
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    
}

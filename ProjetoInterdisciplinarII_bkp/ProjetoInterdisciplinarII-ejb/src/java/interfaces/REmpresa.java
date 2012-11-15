/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import bean.Empresa;
import facade.EmpresaFacade;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author Administrator
 */
    
@Stateless(mappedName = "REmpresa")
public class REmpresa implements REmpresaRemote {

    @EJB
    EmpresaFacade facade;

    @Override
    public void incluir(Empresa empresa) {
        facade.create(empresa);

    }

    @Override
    public void alterar(Empresa empresa) {
        facade.edit(empresa);
    }

    @Override
    public void excluir(Empresa empresa) {
        facade.remove(empresa);
    }

    @Override
    public Empresa consultar(Empresa empresa) {
       return facade.getEmail(empresa.getCnpj());

    }
    @Override
    public Empresa consultarID(Empresa empresa) {
       return facade.getID(empresa.getId());

    }
    
    @Override
    public List<Empresa> consultarTodas() {
       return facade.getEmpresas();

    }

    @Override
    public Empresa pegarDados(Empresa empresa) {
        return facade.getLogin(empresa.getCnpj(), empresa.getSenha());
    }
}

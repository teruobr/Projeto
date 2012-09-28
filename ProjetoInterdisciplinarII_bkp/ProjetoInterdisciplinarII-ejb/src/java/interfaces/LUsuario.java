/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import bean.Usuario;
import facade.UsuarioFacade;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author 31049184
 */
@Stateless(mappedName = "ejb/LUsuario")
public class LUsuario implements LUsuarioLocal {

    @EJB
    UsuarioFacade facade;

    @Override
    public void incluir(Usuario pessoa) {
        facade.create(pessoa);

    }

    @Override
    public void alterar(Usuario pessoa) {
        facade.edit(pessoa);
    }

    @Override
    public void excluir(Usuario pessoa) {
        facade.remove(pessoa);
    }

    @Override
    public Usuario consultar(Usuario pessoa) {
       return facade.getEmail(pessoa.getEmail());

    }

    @Override
    public Usuario pegarDados(Usuario pessoa) {
        return facade.getLogin(pessoa.getEmail(), pessoa.getSenha());
    }
}

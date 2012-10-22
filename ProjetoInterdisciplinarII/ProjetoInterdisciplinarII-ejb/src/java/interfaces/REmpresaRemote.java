/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import bean.Empresa;
import javax.ejb.Remote;

/**
 *
 * @author Administrator
 */
@Remote
public interface REmpresaRemote {
    
    public void incluir(Empresa empresa);
    public void alterar(Empresa empresa);
    public void excluir(Empresa empresa);
    public Empresa consultar(Empresa empresa);
    public Empresa consultarID(Empresa empresa);
    public Empresa pegarDados(Empresa empresa);
}

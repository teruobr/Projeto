/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import bean.VagasUsuario;
import java.util.List;
import javax.ejb.Remote;

/**
 *
 * @author Felipe
 */
@Remote
public interface RVagasUsuarioRemote {
    
    public void incluir(VagasUsuario vaga);
    public void alterar(VagasUsuario vaga);
    public void excluir(VagasUsuario vaga);
    public VagasUsuario consultarID(VagasUsuario vaga);
    public VagasUsuario validaUsuarioVaga(VagasUsuario vaga);
    public List<VagasUsuario> buscarVagasUsuario (VagasUsuario vaga);
    public List<VagasUsuario> buscarUsuariosVaga (long vaga);    
    
}

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import bean.AreaAtuacao;
import java.util.List;
import javax.ejb.Remote;

/**
 *
 * @author 31010296
 */
@Remote
public interface RAreaAtuacaoRemote {

    public void incluir(AreaAtuacao area);

    public void alterar(AreaAtuacao area);

    public void excluir(AreaAtuacao area);

    public List<AreaAtuacao> consultar();
}

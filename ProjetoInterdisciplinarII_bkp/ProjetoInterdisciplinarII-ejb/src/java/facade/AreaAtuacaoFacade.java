/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package facade;

import bean.AreaAtuacao;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author 31010296
 */
@Stateless
public class AreaAtuacaoFacade extends AbstractFacade<AreaAtuacao> {
    @PersistenceContext(unitName = "ProjetoInterdisciplinarII-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public AreaAtuacaoFacade() {
        super(AreaAtuacao.class);
    }
    
    public List<AreaAtuacao> getConsultaAreaAtuacao() {
        try {
            return (List<AreaAtuacao>) em.createQuery("SELECT OBJECT(u) FROM AreaAtuacao u ORDER BY u.nome").getResultList();
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
    }
    
    public AreaAtuacao getAreaAtuacao(AreaAtuacao nome) {
        try {
            return (AreaAtuacao) em.createQuery("SELECT OBJECT(u) FROM AreaAtuacao where UPPER(u.nome) like" + "UPPER(%" + nome.getNome().trim() + "%)").getSingleResult();
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
    }
    
}

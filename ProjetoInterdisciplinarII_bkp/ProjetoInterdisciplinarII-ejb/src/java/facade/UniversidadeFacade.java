/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package facade;

import bean.Universidade;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Administrator
 */
@Stateless
public class UniversidadeFacade extends AbstractFacade<Universidade>{
    
    @PersistenceContext(unitName = "ProjetoInterdisciplinarII-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public UniversidadeFacade() {
        super(Universidade.class);
    }
    
    public List<Universidade> getConsultaUniversidade() {
        try {
            return (List<Universidade>) em.createQuery("SELECT OBJECT(u) FROM Universidade u ORDER BY u.nome").getResultList();
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
    }
    
    public Universidade getUniversidade(Universidade nome) {
        try {
            return (Universidade) em.createQuery("SELECT OBJECT(u) FROM Universidade where UPPER(u.nome) like" + "UPPER(%" + nome.getNome().trim() + "%)").getSingleResult();
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
    }
 
}

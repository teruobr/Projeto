/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package facade;


import bean.Experiencias;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author U0155712
 */
@Stateless
public class ExperienciasFacade extends AbstractFacade<Experiencias> {
    @PersistenceContext(unitName = "ProjetoInterdisciplinarII-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ExperienciasFacade() {
        super(Experiencias.class);
    }
    
    public List<Experiencias> getExp(Experiencias experiencias){
        try {
            return (List<Experiencias>) em.createQuery("SELECT OBJECT(u) FROM Experiencias u WHERE  u.idUsuario='" + experiencias.getIdUsuario() + "' ORDER BY u.Status" ).getResultList();
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
    }
    
    public List<Experiencias> getCNPJEmpresa(Experiencias experiencias){
        try {
            return (List<Experiencias>) em.createQuery("SELECT OBJECT(u) FROM Experiencias u WHERE  u.CNPJ='" + experiencias.getCNPJ() + "' ORDER BY u.Status").getResultList();
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
    }             
}

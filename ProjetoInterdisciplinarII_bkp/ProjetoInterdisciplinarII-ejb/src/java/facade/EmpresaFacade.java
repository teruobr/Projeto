/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package facade;

import bean.Empresa;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Thiago
 */
@Stateless
public class EmpresaFacade extends AbstractFacade<Empresa>{
    @PersistenceContext(unitName = "ProjetoInterdisciplinarII-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public EmpresaFacade() {
        super(Empresa.class);
    }
    
   public Empresa getLogin(String cnpj, String senha){
       
        try {
            return (Empresa) em.createQuery("SELECT OBJECT(u) FROM Empresa u  WHERE  u.cnpj='" + cnpj + "' and u.senha ='" + senha + "'" ).getSingleResult();
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
    }
   
    public Empresa getEmail(String cnpj){
       
        try {
            return (Empresa) em.createQuery("SELECT OBJECT(u) FROM Empresa u  WHERE  u.cnpj='" + cnpj + "'").getSingleResult();
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
    }
    
    public Empresa getID(long id){
       
        try {
            return (Empresa) em.createQuery("SELECT OBJECT(u) FROM Empresa u  WHERE  u.id='" + id + "'").getSingleResult();
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
    }
    
    public List<Empresa> getEmpresas(){
       
        try {
            return (List<Empresa>) em.createQuery("SELECT OBJECT(u) FROM Empresa u order by u.nome").getResultList();
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
    }
}

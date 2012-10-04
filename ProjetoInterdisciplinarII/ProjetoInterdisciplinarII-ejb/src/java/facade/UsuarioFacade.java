/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package facade;

import bean.Usuario;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Felipe
 */
@Stateless
public class UsuarioFacade extends AbstractFacade<Usuario> {
    @PersistenceContext(unitName = "ProjetoInterdisciplinarII-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public UsuarioFacade() {
        super(Usuario.class);
    }
    
   public Usuario getLogin(String email, String senha){
       
        try {
            return (Usuario) em.createQuery("SELECT OBJECT(u) FROM Usuario u  WHERE  u.email='" + email + "' and u.senha ='" + senha + "'" ).getSingleResult();
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
    }
   
    public Usuario getEmail(String email){
       
        try {
            return (Usuario) em.createQuery("SELECT OBJECT(u) FROM Usuario u  WHERE  u.email='" + email + "'").getSingleResult();
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
    }

   /*/ public List<Temp> candidatoList() {
        return (List<Temp>) em.createQuery("SELECT NEW entidade.Temp(c.areaatuacao, count(c.id)) FROM Candidato c GROUP BY c.areaatuacao").getResultList();
    }*/
    
}

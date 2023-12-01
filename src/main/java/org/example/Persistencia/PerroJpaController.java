package org.example.Persistencia;

import org.example.Entidades.Perro;
import org.example.Persistencia.Exceptions.NonexistentEntityException;

import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.Persistence;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;



public class PerroJpaController implements Serializable {

    public PerroJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public PerroJpaController() {
        emf = Persistence.createEntityManagerFactory("TrabajoFinal");
    }
    public void create(Perro perro) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(perro);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Perro perro) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            perro = em.merge(perro);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                int id = (int) perro.getId();
                if (findPerro(id) == null) {
                    throw new NonexistentEntityException("The perro with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(int id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Perro perro;
            try {
                perro = em.getReference(Perro.class, id);
                perro.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The perro with id " + id + " no longer exists.", enfe);
            }
            em.remove(perro);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Perro> findPerroEntities() {
        return findPerroEntities(true, -1, -1);
    }

    public List<Perro> findPerroEntities(int maxResults, int firstResult) {
        return findPerroEntities(false, maxResults, firstResult);
    }

    private List<Perro> findPerroEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Perro.class));
            Query q = em.createQuery(cq);
            if (!all) {
                q.setMaxResults(maxResults);
                q.setFirstResult(firstResult);
            }
            return q.getResultList();
        } finally {
            em.close();
        }
    }

    public Perro findPerro(int id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Perro.class, id);
        } finally {
            em.close();
        }
    }

    public int getPerroCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Perro> rt = cq.from(Perro.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }

}

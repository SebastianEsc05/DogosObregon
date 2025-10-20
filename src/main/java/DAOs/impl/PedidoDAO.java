package DAOs.impl;

import DAOs.IPedidoDAO;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import entities.Pedido;

import java.util.List;

public class PedidoDAO implements IPedidoDAO {
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("DogosObregonPU");
    EntityManager em;

    public PedidoDAO() {
        em = emf.createEntityManager();
    }

    @Override
    public boolean create(Pedido pedido) {
        try {
            em.getTransaction().begin();
            em.persist(pedido);
            em.getTransaction().commit();
            return true;
        } catch (Exception ex) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
        }
        return false;
    }

    @Override
    public Pedido findById(long id) {
        try {
            em.getTransaction().begin();
            return em.find(Pedido.class, id);
        } catch (Exception ex) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
        }
        return null;
    }

    @Override
    public List<Pedido> getAllPedidos() {
        try {
            return em.createQuery("Select p from Pedido p limit 100", Pedido.class).getResultList();
        } catch (Exception ex) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
        }
        return null;
    }

    @Override
    public boolean update(Pedido pedido) {
        try {
            em.getTransaction().begin();
            em.merge(pedido);
            em.getTransaction().commit();
            return true;
        } catch (Exception ex) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
        }
        return false;
    }

    @Override
    public boolean delete(long id) {
        try {
            em.getTransaction().begin();
            Pedido pedido = em.find(Pedido.class, id);
            if (pedido != null) {
                em.remove(pedido);
                em.getTransaction().commit();
                return true;
            }
        } catch (Exception ex) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
        }
        return false;
    }
}

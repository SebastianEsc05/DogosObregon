package DAOs.impl;

import DAOs.IClienteDAO;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import entities.Cliente;

import java.util.List;

public class ClienteDAO implements IClienteDAO{
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("DogosObregonPU");
    EntityManager em;

    public ClienteDAO(){
        em = emf.createEntityManager();
    }

    @Override
    public boolean create(Cliente cliente) {
        try{
            em.getTransaction().begin();
            em.persist(cliente);
            em.getTransaction().commit();
            return true;
        }catch(Exception ex){
            if(em.getTransaction().isActive()){
                em.getTransaction().rollback();
            }
        }
        return false;
    }

    @Override
    public Cliente findById(long id) {
        try{
            em.getTransaction().begin();
            return em.find(Cliente.class,id);
        }catch (Exception ex){
            if(em.getTransaction().isActive()){
                em.getTransaction().rollback();
            }
        }
        return null;
    }

    @Override
    public List<Cliente> getAllClientes() {
        try{
            return em.createQuery("Select c from Cliente c limit 100", Cliente.class).getResultList();
        }catch (Exception ex){
            if(em.getTransaction().isActive()){
                em.getTransaction().rollback();
            }
        }
        return null;
    }

    @Override
    public boolean update(Cliente cliente) {
        try{
            em.getTransaction().begin();
            em.merge(cliente);
            em.getTransaction().commit();
            return true;
        }catch(Exception ex){
            if(em.getTransaction().isActive()){
                em.getTransaction().rollback();
            }
        }
        return false;
    }

    @Override
    public boolean delete(long id) {
        try{
            em.getTransaction().begin();
            Cliente cliente = em.find(Cliente.class, id);
            if(cliente != null){
                em.remove(cliente);
                em.getTransaction().commit();
                return true;
            }
        }catch (Exception ex){
            if(em.getTransaction().isActive()){
                em.getTransaction().rollback();
            }
        }
        return false;
    }

    @Override
    public List<Object[]> findClientesConMayorGasto() {
//        try {
//            String jpql = "SELECT c.nombre, c.apePaterno, SUM(p.totalPagar) as gastoTotal " +
//                    "FROM Pedido p JOIN p.cliente c " +
//                    "GROUP BY c.id ORDER BY gastoTotal DESC";
//            return em.createQuery(jpql, Object[].class).setMaxResults(5).getResultList();
//        } finally {
//            em.close();
//        } LA CONCHA DE TU MADRE
        return List.of();
    }

    @Override
    public List<Cliente> findClientesSinCompras() {
        return List.of();
    }

    @Override
    public List<Cliente> findClientesPorPreferencia(String preferencia) {
        return List.of();
    }

    @Override
    public List<Cliente> findClientesRecomendadosPor(Integer recomendadorId) {
        return List.of();
    }

    @Override
    public Object findUltimoPedidoPorCliente(Integer clienteId) {
        return null;
    }
}

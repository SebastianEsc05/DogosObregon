package DAOs.impl;

import DAOs.IHotdogDAO;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import entities.HotDog;

import java.util.List;

public class HotdogDAO implements IHotdogDAO {
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("DogosObregonPU");
    EntityManager em;

    public HotdogDAO(){
        em = emf.createEntityManager();
    }

    @Override
    public boolean create(HotDog hotDog) {
        try{
            em.getTransaction().begin();
            em.persist(hotDog);
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
    public HotDog findById(long id) {
        try{
            em.getTransaction().begin();
            return em.find(HotDog.class,id);
        }catch (Exception ex){
            if(em.getTransaction().isActive()){
                em.getTransaction().rollback();
            }
        }
        return null;
    }

    @Override
    public List<HotDog> getAllHotdogs() {
        try{
            return em.createQuery("Select h from HotDog h limit 100", HotDog.class).getResultList();
        }catch (Exception ex){
            if(em.getTransaction().isActive()){
                em.getTransaction().rollback();
            }
        }
        return null;
    }

    @Override
    public boolean update(HotDog hotDog) {
        try{
            em.getTransaction().begin();
            em.merge(hotDog);
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
            HotDog hotDog = em.find(HotDog.class, id);
            if(hotDog != null){
                em.remove(hotDog);
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
}

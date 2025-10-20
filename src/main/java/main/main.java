package main;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import service.IClienteService;
import service.impl.ClienteService;

public class main {
    public static void main(String[] args){
            EntityManagerFactory emf = Persistence.createEntityManagerFactory("DogosObregonPU");
            EntityManager em = emf.createEntityManager();

        // Instanciar servicios
        IClienteService clienteService = new ClienteService();


    }
}

package service.impl;

import DAOs.impl.HotdogDAO;
import entities.HotDog;
import service.IHotDogService;
import java.math.BigDecimal;
import java.util.List;

public class HotdogService implements IHotDogService {
    private HotdogDAO hotdogDAO;

    public HotdogService(){
        this.hotdogDAO = new HotdogDAO();
    }

    @Override
    public boolean create(String nombre, BigDecimal precio, BigDecimal iva) {
        if(nombre == null || nombre.trim().isEmpty()){
            System.out.println("El nombre es invalido");
            return false;
        }
        if(precio == null || precio.compareTo(BigDecimal.ZERO) > 0){
            System.out.println("El precio es invalido");
            return false;
        }
        if(iva == null || iva.compareTo(BigDecimal.ZERO) > 0){
            System.out.println("El iva es invalido");
            return false;
        }
        HotDog hotDog = new HotDog(nombre,precio,iva);
        return hotdogDAO.create(hotDog);
    }

    @Override
    public HotDog findById(long id) {
        if(id < 0){
            System.out.println("el id no puede ser negativo");
            return null;
        }
        
        HotDog hotDog = hotdogDAO.findById(id);
        if(hotDog == null){
            System.out.printf("No se encontro registro del hotdog");
            return null;
        }
        return hotDog;
    }

    @Override
    public List<HotDog> getAllHotdogs() {
        List<HotDog> lista = hotdogDAO.getAllHotdogs();
        if (lista.isEmpty()){
            System.out.println("La lista esta vacia");
            return null;
        }
        return lista;
    }

    @Override
    public boolean update(Long id, String nombre, BigDecimal precio, BigDecimal iva) {
        if(id < 0 ){
            System.out.println("El id no puede ser negativo");
            return false;
        }
        if(nombre == null || nombre.trim().isEmpty()){
            System.out.println("El nombre es invalido");
            return false;
        }
        if(precio == null || precio.compareTo(BigDecimal.ZERO) > 0){
            System.out.println("El precio es invalido");
            return false;
        }
        if(iva == null || iva.compareTo(BigDecimal.ZERO) > 0){
            System.out.println("El iva es invalido");
            return false;
        }
        HotDog hotDog = new HotDog(nombre,precio,iva);
        return hotdogDAO.update(hotDog);
    }

    @Override
    public boolean delete(long id) {
        if(id < 0){
            System.out.println("El id no puede ser negativo");
            return false;
        }

        boolean hotdogDao = hotdogDAO.delete(id);
        if(hotdogDao){
            return true;
        }else{
            System.out.println("No se encontro registro");
            return false;
        }
    }
}

package service;

import entities.HotDog;

import java.math.BigDecimal;
import java.util.List;

public interface IHotDogService {
    boolean create(String nombre, BigDecimal precio, BigDecimal iva);
    HotDog findById(long id);
    List<HotDog> getAllHotdogs();
    boolean update(Long id, String nombre, BigDecimal precio, BigDecimal iva);
    boolean delete(long id);
}

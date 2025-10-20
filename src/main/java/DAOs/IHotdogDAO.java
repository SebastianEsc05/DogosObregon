package DAOs;

import entities.HotDog;

import java.util.List;

public interface IHotdogDAO {
    boolean create(HotDog hotDog);
    HotDog findById(long id);
    List<HotDog> getAllHotdogs();
    boolean update(HotDog hotDog);
    boolean delete(long id);
}

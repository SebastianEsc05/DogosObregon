package DAOs;

import entities.Cliente;

import java.util.List;

public interface IClienteDAO {
    boolean create(Cliente cliente);
    Cliente findById(long id);
    List<Cliente> getAllClientes();
    boolean update(Cliente cliente);
    boolean delete(long id);
}

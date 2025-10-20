package DAOs;

import entities.Cliente;

import java.util.List;

public interface IClienteDAO {
    boolean create(Cliente cliente);

    Cliente findById(long id);

    List<Cliente> getAllClientes();

    boolean update(Cliente cliente);

    boolean delete(long id);

    //Consultas adicionales
    List<Object[]> findClientesConMayorGasto();

    List<Cliente> findClientesSinCompras();

    List<Cliente> findClientesPorPreferencia(String preferencia); // Criteria API

    List<Cliente> findClientesRecomendadosPor(Integer recomendadorId);

    Object findUltimoPedidoPorCliente(Integer clienteId);
}

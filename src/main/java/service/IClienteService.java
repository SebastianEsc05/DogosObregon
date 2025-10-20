package service;

import entities.Cliente;

import java.util.List;

public interface IClienteService {
    void registrarCliente(Cliente cliente);
    Cliente obtenerCliente(Integer id);
    List<Cliente> listarClientes();
    void actualizarDatosCliente(Cliente cliente);
    void eliminarCliente(Integer id);

}

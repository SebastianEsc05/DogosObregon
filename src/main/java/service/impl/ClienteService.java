package service.impl;

import DAOs.IClienteDAO;
import DAOs.impl.ClienteDAO;
import entities.Cliente;
import service.IClienteService;

import java.time.LocalDate;
import java.util.List;

public class ClienteService implements IClienteService {
    private final IClienteDAO clienteDAO = new ClienteDAO();


    @Override
    public void registrarCliente(Cliente cliente) {
        validarCliente(cliente);
        clienteDAO.create(cliente);
    }

    @Override
    public Cliente obtenerCliente(Integer id) {
        if (id == null || id <= 0) {
            return null;
        }
        return clienteDAO.findById(id);
    }

    @Override
    public List<Cliente> listarClientes() {
        return clienteDAO.getAllClientes();
    }

    @Override
    public void actualizarDatosCliente(Cliente cliente) {
        if (cliente == null || cliente.getId() == null) {
            throw new IllegalArgumentException("Se requiere un cliente con ID para actualizar.");
        }
        validarCliente(cliente);
        clienteDAO.update(cliente);
    }

    @Override
    public void eliminarCliente(Integer id) {
        if (id == null || id <= 0) {
            throw new IllegalArgumentException("El ID para eliminar no es válido.");
        }
        clienteDAO.delete(id);
    }

    private void validarCliente(Cliente cliente) {
        if (cliente == null) {
            throw new IllegalArgumentException("El objeto cliente no puede ser nulo.");
        }
        if (cliente.getNombre() == null || cliente.getNombre().trim().isEmpty()) {
            throw new IllegalArgumentException("El nombre del cliente es obligatorio.");
        }
        if (cliente.getApePaterno() == null || cliente.getApePaterno().trim().isEmpty()) {
            throw new IllegalArgumentException("El apellido paterno es obligatorio.");
        }
        if (cliente.getFecha_nacimiento() == null) {
            throw new IllegalArgumentException("La fecha de nacimiento es obligatoria.");
        }
        if (cliente.getFecha_nacimiento().isAfter(LocalDate.now())) {
            throw new IllegalArgumentException("La fecha de nacimiento no puede ser una fecha futura.");
        }
    }
}
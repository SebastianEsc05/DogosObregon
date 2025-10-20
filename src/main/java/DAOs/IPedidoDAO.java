package DAOs;

import entities.Pedido;

import java.util.List;

public interface IPedidoDAO {
    boolean create(Pedido pedido);
    Pedido findById(long id);
    List<Pedido> getAllPedidos();
    boolean update(Pedido pedido);
    boolean delete(long id);
}

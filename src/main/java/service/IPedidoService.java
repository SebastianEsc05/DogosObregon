package service;

import entities.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

public interface IPedidoService {
    boolean create(Cliente cliente, LocalDateTime fecha, MetodoPago metodoPago, Set<PedidoDetalle> detalle);
    Pedido findById(long id);
    List<Pedido> getAllPedidos();
    boolean update(Long id, Cliente cliente, LocalDateTime fecha, MetodoPago metodoPago, Set<PedidoDetalle> detalle);
    boolean delete(long id);
}

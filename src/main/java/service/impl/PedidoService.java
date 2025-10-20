package service.impl;

import DAOs.impl.PedidoDAO;
import entities.*;
import service.IPedidoService;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

public class PedidoService implements IPedidoService {
    private PedidoDAO pedidoDAO;

    public PedidoService(){
        this.pedidoDAO = new PedidoDAO();
    }

    @Override
    public boolean create(Cliente cliente, LocalDateTime fecha, MetodoPago metodoPago, Set<PedidoDetalle> detalle) {
        if(cliente == null){
            System.out.println("El cliente no puede ser null");
            return false;
        }
        if(fecha == null || fecha.isAfter(LocalDateTime.now())){
            System.out.println("La fecha es invalida");
            return false;
        }
        if(metodoPago == null){
            System.out.println("El metodo de pago no puede ser null");
            return false;
        }
        if(detalle == null){
            System.out.println("Los detalles no pueden ser nulos");
            return false;
        }
        Pedido pedido = new Pedido(cliente,fecha, metodoPago,detalle);
        return pedidoDAO.create(pedido);
    }

    @Override
    public Pedido findById(long id) {
        if(id < 0){
            System.out.println("el id no puede ser negativo");
            return null;
        }

        Pedido pedido = pedidoDAO.findById(id);
        if(pedido == null){
            System.out.printf("No se encontro registro del hotdog");
            return null;
        }
        return pedido;
    }

    @Override
    public List<Pedido> getAllPedidos() {
        List<Pedido> lista = pedidoDAO.getAllPedidos();
        if (lista.isEmpty()){
            System.out.println("La lista esta vacia");
            return null;
        }
        return lista;
    }

    @Override
    public boolean update(Long id, Cliente cliente, LocalDateTime fecha, MetodoPago metodoPago, Set<PedidoDetalle> detalle) {
        if(id < 0 ){
            System.out.println("El id no puede ser negativo");
            return false;
        }
        if(cliente == null){
            System.out.println("El cliente no puede ser null");
            return false;
        }
        if(fecha == null || fecha.isAfter(LocalDateTime.now())){
            System.out.println("La fecha es invalida");
            return false;
        }
        if(metodoPago == null){
            System.out.println("El metodo de pago no puede ser null");
            return false;
        }
        if(detalle == null){
            System.out.println("Los detalles no pueden ser nulos");
            return false;
        }
        Pedido pedido = new Pedido(cliente,fecha, metodoPago,detalle);
        return pedidoDAO.update(pedido);
    }

    @Override
    public boolean delete(long id) {
        if(id < 0){
            System.out.println("El id no puede ser negativo");
            return false;
        }

        boolean pedido = pedidoDAO.delete(id);
        if(pedido){
            return true;
        }else{
            System.out.println("No se encontro registro");
            return false;
        }
    }
}

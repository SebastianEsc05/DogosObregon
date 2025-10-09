package models;

import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
public class PedidoDetalle {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @ManyToOne
    @JoinColumn(name = "pedido_id")
    private Pedido pedido;

    @ManyToOne
    @JoinColumn(name = "hotdog_id")
    private HotDog hotDog;

    private int cantidad;

    @Column(name = "precio_venta")
    private BigDecimal precioVenta;

    @Column(name = "sub_total")
    private BigDecimal sub_total;

    public PedidoDetalle() {
    }

    public PedidoDetalle(long id, Pedido pedido, HotDog hotDog, int cantidad, BigDecimal precioVenta, BigDecimal sub_total) {
        this.id = id;
        this.pedido = pedido;
        this.hotDog = hotDog;
        this.cantidad = cantidad;
        this.precioVenta = precioVenta;
        this.sub_total = sub_total;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Pedido getPedido() {
        return pedido;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }

    public HotDog getHotDog() {
        return hotDog;
    }

    public void setHotDog(HotDog hotDog) {
        this.hotDog = hotDog;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public BigDecimal getPrecioVenta() {
        return precioVenta;
    }

    public void setPrecioVenta(BigDecimal precioVenta) {
        this.precioVenta = precioVenta;
    }

    public BigDecimal getSub_total() {
        return sub_total;
    }

    public void setSub_total(BigDecimal sub_total) {
        this.sub_total = sub_total;
    }

    @Override
    public String toString() {
        return "PedidoDetalle{" +
                "id=" + id +
                ", pedido=" + pedido +
                ", hotDog=" + hotDog +
                ", cantidad=" + cantidad +
                ", precioVenta=" + precioVenta +
                ", sub_total=" + sub_total +
                '}';
    }

}

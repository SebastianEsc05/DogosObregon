package entities;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.util.Set;

@Entity
//@Table(name = "hotdogs")
public class HotDog {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String nombre;

    private BigDecimal precio;

    private BigDecimal IVA;

    @OneToMany(mappedBy = "hotDog", cascade = CascadeType.ALL)
    private Set<PedidoDetalle> detalles;

    public HotDog() {
    }

    public HotDog(String nombre, BigDecimal precio, BigDecimal iva){
        this.nombre = nombre;
        this.precio = precio;
        this.IVA = iva;
    }
    public HotDog(long id, String nombre, BigDecimal precio, BigDecimal IVA, Set<PedidoDetalle> detalles) {
        this.id = id;
        this.nombre = nombre;
        this.precio = precio;
        this.IVA = IVA;
        this.detalles = detalles;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public BigDecimal getPrecio() {
        return precio;
    }

    public void setPrecio(BigDecimal precio) {
        this.precio = precio;
    }

    public BigDecimal getIVA() {
        return IVA;
    }

    public void setIVA(BigDecimal IVA) {
        this.IVA = IVA;
    }

    public Set<PedidoDetalle> getDetalles() {
        return detalles;
    }

    public void setDetalles(Set<PedidoDetalle> detalles) {
        this.detalles = detalles;
    }

}
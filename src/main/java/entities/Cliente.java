package entities;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.time.Period;
import java.util.Set;

@Entity
//@Table(name = "clientes")
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String nombre;

    @Column(name = "apellido_paterno")
    private String apePaterno;

    @Column(name = "apellido_materno")
    private String apeMaterno;

    @Column(name = "fecha_nacimiento")
    private LocalDate fecha_nacimiento;

    @OneToOne
    @JoinColumn(name = "cliente_recomienda_id", referencedColumnName = "id")
    private Cliente cliente_recomienda;

    @ElementCollection
    @CollectionTable(name = "cliente_telefonos", joinColumns = @JoinColumn(name = "cliente_id"))
    @Column(name = "telefono")
    private Set<String> telefonos;

    @ElementCollection
    @CollectionTable(name = "cliente_preferencias", joinColumns = @JoinColumn(name = "cliente_id"))
    @Column(name = "preferencia")
    private Set<String> preferencias;

    @OneToMany(mappedBy = "cliente", cascade = CascadeType.ALL)
    private Set<Pedido> pedidos;

    public Cliente() {
    }

    public Cliente(Long id, String nombre, String apePaterno, String apeMaterno, LocalDate fecha_nacimiento, Cliente cliente_recomienda, Set<String> telefonos, Set<String> preferencias, Set<Pedido> pedidos) {
        this.id = id;
        this.nombre = nombre;
        this.apePaterno = apePaterno;
        this.apeMaterno = apeMaterno;
        this.fecha_nacimiento = fecha_nacimiento;
        this.cliente_recomienda = cliente_recomienda;
        this.telefonos = telefonos;
        this.preferencias = preferencias;
        this.pedidos = pedidos;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApePaterno() {
        return apePaterno;
    }

    public void setApePaterno(String apePaterno) {
        this.apePaterno = apePaterno;
    }

    public String getApeMaterno() {
        return apeMaterno;
    }

    public void setApeMaterno(String apeMaterno) {
        this.apeMaterno = apeMaterno;
    }

    public LocalDate getFecha_nacimiento() {
        return fecha_nacimiento;
    }

    public void setFecha_nacimiento(LocalDate fecha_nacimiento) {
        this.fecha_nacimiento = fecha_nacimiento;
    }

    public Cliente getCliente_recomienda() {
        return cliente_recomienda;
    }

    public void setCliente_recomienda(Cliente cliente_recomienda) {
        this.cliente_recomienda = cliente_recomienda;
    }

    public Set<String> getTelefonos() {
        return telefonos;
    }

    public void setTelefonos(Set<String> telefonos) {
        this.telefonos = telefonos;
    }

    public Set<String> getPreferencias() {
        return preferencias;
    }

    public void setPreferencias(Set<String> preferencias) {
        this.preferencias = preferencias;
    }

    public Set<Pedido> getPedidos() {
        return pedidos;
    }

    public void setPedidos(Set<Pedido> pedidos) {
        this.pedidos = pedidos;
    }

    public Integer getEdad() {
        if (this.fecha_nacimiento != null) {
            return Period.between(this.fecha_nacimiento, LocalDate.now()).getYears();
        }
        return null;
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", apePaterno='" + apePaterno + '\'' +
                ", apeMaterno='" + apeMaterno + '\'' +
                ", fecha_nacimiento=" + fecha_nacimiento +
                ", cliente_recomienda=" + cliente_recomienda +
                ", telefonos=" + telefonos +
                ", preferencias=" + preferencias +
                ", pedidos=" + pedidos +
                '}';
    }
}

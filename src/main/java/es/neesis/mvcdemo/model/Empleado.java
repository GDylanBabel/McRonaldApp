package es.neesis.mvcdemo.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
public class Empleado {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String nombre;
    @OneToMany(mappedBy = "empleado", cascade = CascadeType.ALL)
    private List<Pedido> pedidosAsignados;

    public String toString() {
        return nombre;
    }
}

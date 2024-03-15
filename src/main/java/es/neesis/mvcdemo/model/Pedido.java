package es.neesis.mvcdemo.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
public class Pedido {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String identificador;
    @ManyToOne
    private Empleado empleado;
    @OneToMany(mappedBy = "pedido", cascade = CascadeType.ALL)
    private List<ProductoPedido> productos;
    private Double precioTotal;
}

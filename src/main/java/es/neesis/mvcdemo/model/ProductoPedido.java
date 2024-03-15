package es.neesis.mvcdemo.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class ProductoPedido {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @OneToOne
    private ProductoCarta productoCarta;
    @ManyToOne
    private Pedido pedido;
    private Integer productAmount;
}

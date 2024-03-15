package es.neesis.mvcdemo.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class ProductoCarta {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @OneToOne
    private Producto producto;
    private Double precio;
}

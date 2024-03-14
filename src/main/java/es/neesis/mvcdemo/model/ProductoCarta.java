package es.neesis.mvcdemo.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name="carta")
@Data
public class ProductoCarta {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Producto producto;
    private Double precio;
}

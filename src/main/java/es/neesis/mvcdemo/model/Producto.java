package es.neesis.mvcdemo.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name="producto")
@Data
public class Producto {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String nombre;
    private Integer stockDisponible;
}
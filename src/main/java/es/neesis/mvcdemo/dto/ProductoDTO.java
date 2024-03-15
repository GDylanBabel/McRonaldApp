package es.neesis.mvcdemo.dto;

import lombok.Data;

@Data
public class ProductoDTO {

    private Long id;
    private String nombre;
    private Integer stockDisponible;

}

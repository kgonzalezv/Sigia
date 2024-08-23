package com.ltp.sigia.model;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.Date;

@Getter
@Setter
@Entity
@Table(name = "producto")
public class Product {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @GenericGenerator(name = "native", strategy = "native")
    private Long id;

    @NotBlank(message = "Nombre no puede estar en blanco")
    private String nombre;

    @NotBlank(message = "Debe asignar una descripción")
    private String descripcion;

    @NotNull(message = "Debe asignar un precio")
    private BigDecimal precio;

    @NotNull(message = "Debe asignar una cantidad")
    private Integer cantidad;

    @NotNull(message = "Debe asignar una categoria")
    @ManyToOne
    private Category categoria;

    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaRegistro;

    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaActualizacion;

    @PrePersist
    protected void onCreate() {
        fechaRegistro = new Date();
    }

    @PreUpdate
    protected void onUpdate() {
        fechaActualizacion = new Date();
    }
}

package com.ihl95.GuitarWorld.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Producto {

      @Id
    @GeneratedValue
    private Long id;

    @NotBlank(message = "El nombre del producto es obligatorio")
    @Size(max = 100, message = "El nombre del producto debe tener un máximo de 100 caracteres")
    private String nombre;

    @DecimalMin(value = "0.01", message = "El precio del producto debe ser mayor o igual a 0.01")
    private float precio;

    @NotBlank(message = "La imagen del producto es obligatoria")
    @Size(max = 255, message = "La URL de la imagen debe tener un máximo de 255 caracteres")
    private String imagen;

    @ManyToOne
    private Usuario propietario;

    @ManyToOne
    private Compra compra;
  
}

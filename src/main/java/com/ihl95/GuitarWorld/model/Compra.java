package com.ihl95.GuitarWorld.model;

import java.sql.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
/*
 La anotación `@EntityListeners(AuditingEntityListener.class)` en la clase `Compra` se usa para
 especificar la clase de escucha de entidad que será notificada de los eventos del ciclo de vida en
 instancias de la entidad `Compra`. En este caso, se está utilizando la clase
 `AuditingEntityListener`, que es una entidad de escucha de Spring Data JPA que proporciona
 capacidades de auditoría, como completar automáticamente campos relacionados con la auditoría, como
 la fecha de creación, la fecha de la última modificación, etc.
 */
// TODO: Añadir la información de las anotaciones al README.md
@EntityListeners(AuditingEntityListener.class)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Compra {

  @Id
  @GeneratedValue
  private Long id;

  @CreatedDate
  @Temporal(TemporalType.TIMESTAMP)
  private Date fechaCompra;

  @OneToMany(mappedBy = "compra")
  private List<Producto> productos;

  @ManyToOne
  private Usuario propietario;
  
}

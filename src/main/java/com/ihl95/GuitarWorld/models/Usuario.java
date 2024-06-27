package com.ihl95.GuitarWorld.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@EntityListeners(AuditingEntityListener.class)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Usuario {
  
  @Id
  @GeneratedValue
  private Long id;

  @NotBlank(message = "El nombre no puede estar vacío")
  @Size(max = 50, message = "El nombre no puede tener más de 50 caracteres")
  private String nombre;

  @NotBlank(message = "Los apellidos no pueden estar vacíos")
  @Size(max = 100, message = "Los apellidos no pueden tener más de 100 caracteres")
  private String apellidos;

  private String avatar;

  @CreatedDate
  @Temporal(TemporalType.TIMESTAMP)
  private Date fechaAlta;

  @NotBlank(message = "El email no puede estar vacío")
  @Email(message = "El email no es válido")
  @Column(unique=true)
  private String email;

  @NotBlank(message = "La contraseña no puede estar vacía")
  @Size(min = 8, max = 20, message = "La contraseña debe tener entre 8 y 20 caracteres")
  private String password;

}

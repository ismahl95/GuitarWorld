package com.ihl95.GuitarWorld.models;

import java.util.Date;

import org.springframework.data.annotation.CreatedDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Usuario {
  
  @Id 
  @GeneratedValue
  private Long id;

  private String nombre;

  private String apellidos;

  private String avatar;

  @CreatedDate
  @Temporal(TemporalType.TIMESTAMP)
  private Date fechaAlta;

  private String email;

  private String password;

}

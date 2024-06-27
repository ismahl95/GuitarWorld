package com.ihl95.GuitarWorld.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ihl95.GuitarWorld.models.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
  
  Usuario findFirstByEmail(String email);

}

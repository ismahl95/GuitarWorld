package com.ihl95.GuitarWorld.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ihl95.GuitarWorld.model.Usuario;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
  
  Usuario findFirstByEmail(String email);

}

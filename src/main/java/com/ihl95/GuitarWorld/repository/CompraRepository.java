package com.ihl95.GuitarWorld.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ihl95.GuitarWorld.model.Compra;
import com.ihl95.GuitarWorld.model.Usuario;

@Repository
public interface CompraRepository extends JpaRepository<Compra, Long> {

  List<Compra> findByPropietario(Usuario propietario);
  
}

package com.ihl95.GuitarWorld.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ihl95.GuitarWorld.models.Compra;
import com.ihl95.GuitarWorld.models.Producto;
import com.ihl95.GuitarWorld.models.Usuario;

public interface ProductoRepository extends JpaRepository<Producto, Long> {

  List<Producto> findByPropietario(Usuario propietario);

  List<Producto> findByCompra(Compra compra);

  List<Producto> findByCompraIsNull();

  List<Producto> findByNombreContainsIgnoreCaseAndCompraIsNull(String nombre);

  List<Producto> findByNombreContainsIgnoreCaseAndPropietario(String nombre, Usuario propietario);
  
}

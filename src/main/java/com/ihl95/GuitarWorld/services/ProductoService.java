package com.ihl95.GuitarWorld.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ihl95.GuitarWorld.model.Compra;
import com.ihl95.GuitarWorld.model.Producto;
import com.ihl95.GuitarWorld.model.Usuario;
import com.ihl95.GuitarWorld.repository.ProductoRepository;

@Service
public class ProductoService {
  
  @Autowired
  private ProductoRepository productoRepository;

  public Producto insertar(Producto producto) {
    return this.productoRepository.save(producto);
  }

  public void borrar(Long id) {
    this.productoRepository.deleteById(id);
  }

  public void borrar(Producto producto) {
    this.productoRepository.delete(producto);
  }

  public Producto editar(Producto producto) {
    return this.productoRepository.save(producto);
  }

  public Producto findById(Long id) {
    return this.productoRepository.findById(id).orElse(null);
  }

  public List<Producto> findAll() {
    return this.productoRepository.findAll();
  }

  public void ProductosDeUnPropietario(Usuario propietario) {
    this.productoRepository.findByPropietario(propietario);
  }

  public void ProductosDeUnaCompra(Compra compra) {
    this.productoRepository.findByCompra(compra);
  }

  public void ProductosSinVender() {
    this.productoRepository.findByCompraIsNull();
  }

  public List<Producto> buscar(String query) {
    return this.productoRepository.findByNombreContainsIgnoreCaseAndCompraIsNull(query);
  }

  public List<Producto> buscarMisProductos(String query, Usuario propietario) {
    return this.productoRepository.findByNombreContainsIgnoreCaseAndPropietario(query, propietario);
  }

  public List<Producto> variosPorIds(List<Long> ids) {
    return this.productoRepository.findAllById(ids);
  }

}

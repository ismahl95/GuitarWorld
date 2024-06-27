package com.ihl95.GuitarWorld.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ihl95.GuitarWorld.model.Compra;
import com.ihl95.GuitarWorld.model.Producto;
import com.ihl95.GuitarWorld.model.Usuario;
import com.ihl95.GuitarWorld.repository.CompraRepository;

@Service
public class CompraService {
  
  @Autowired
  private CompraRepository compraRepository;

  @Autowired
  private ProductoService productoService;

  public Compra insertar(Compra compra, Usuario propietario) {
    compra.setPropietario(propietario);
    return this.compraRepository.save(compra);
  }

  public Compra insertar(Compra compra) {
    return this.compraRepository.save(compra);
  }

  public Producto addProductoCompra(Producto producto, Compra compra) {
    producto.setCompra(compra);
    return productoService.editar(producto);
  }

  public Compra buscarPorId(Long id) {
    return this.compraRepository.findById(id).orElse(null);
  }

  public List<Compra> todas() {
    return this.compraRepository.findAll();
  }

  public List<Compra> porPropietario(Usuario propietario) {
    return this.compraRepository.findByPropietario(propietario);
  }

}

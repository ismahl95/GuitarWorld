package com.ihl95.GuitarWorld.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.ihl95.GuitarWorld.model.Usuario;
import com.ihl95.GuitarWorld.repository.UsuarioRepository;

@Service
public class UsuarioService {

  @Autowired
  private UsuarioRepository usuarioRepository;

  @Autowired
  BCryptPasswordEncoder bCryptPasswordEncoder;

  public Usuario registrar(Usuario usuario) {
    usuario.setPassword(bCryptPasswordEncoder.encode(usuario.getPassword()));
    return this.usuarioRepository.save(usuario);
  }

  public Usuario findById(Long id) {
    return this.usuarioRepository.findById(id).orElse(null);
  }

  public Usuario findByEmail(String email) {
    return this.usuarioRepository.findFirstByEmail(email);
  }
  
}

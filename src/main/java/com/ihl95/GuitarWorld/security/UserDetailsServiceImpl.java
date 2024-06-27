package com.ihl95.GuitarWorld.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.core.userdetails.User.UserBuilder;

import com.ihl95.GuitarWorld.models.Usuario;
import com.ihl95.GuitarWorld.repository.UsuarioRepository;

public class UserDetailsServiceImpl implements UserDetailsService {

  @Autowired
  UsuarioRepository usuarioRepository;

  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

    Usuario user = usuarioRepository.findFirstByEmail(username);

    UserBuilder builder = null;
    if (user != null) {
      
      builder = User.withUsername(username);
      builder.disabled(false);
      builder.password(user.getPassword());
      builder.authorities(new SimpleGrantedAuthority("RULE_USER"));

    } else {
      throw new UsernameNotFoundException("User not found.");
    }
    return builder.build();
  }
  
}

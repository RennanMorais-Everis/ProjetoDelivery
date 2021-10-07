package com.everis.delivery.service;

import com.everis.delivery.model.Usuario;
import java.util.List;

public interface UsuarioService {

    List<Usuario> findAll();
    Usuario findById(Long id);
    Usuario save(Usuario usuario);
}

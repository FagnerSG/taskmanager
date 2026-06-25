package com.fagnersgx.taskmanager.service;

import com.fagnersgx.taskmanager.dto.UserDto;
import com.fagnersgx.taskmanager.entity.UsuarioEntity;
import com.fagnersgx.taskmanager.repository.UsuarioRepository;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {

    private UsuarioRepository usuarioRepository;

    public UsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    public UsuarioEntity salvar(UserDto createUsuarioDto) {
        UsuarioEntity salvarUsuario = new UsuarioEntity();
        salvarUsuario.setUsername(createUsuarioDto.username());
        salvarUsuario.setEmail(createUsuarioDto.email());
        salvarUsuario.setSenha(createUsuarioDto.senha());
        return usuarioRepository.save(salvarUsuario);
    }
}

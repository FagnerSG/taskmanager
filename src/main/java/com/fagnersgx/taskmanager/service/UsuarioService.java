package com.fagnersgx.taskmanager.service;

import com.fagnersgx.taskmanager.dto.UserDto;
import com.fagnersgx.taskmanager.entity.UsuarioEntity;
import com.fagnersgx.taskmanager.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public UsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    public UsuarioEntity salvarUsuario(UserDto createUsuarioDto) {
        UsuarioEntity salvarUsuario = new UsuarioEntity();
        salvarUsuario.setUsername(createUsuarioDto.username());
        salvarUsuario.setEmail(createUsuarioDto.email());
        salvarUsuario.setSenha(createUsuarioDto.senha());
        return usuarioRepository.save(salvarUsuario);
    }

    public List<UserDto> listarTodosUsuarios() {
        List<UsuarioEntity> todosUsuarios = usuarioRepository.findAll();
        return todosUsuarios.stream().map(usuario -> new UserDto(
                usuario.getUsername(),
                usuario.getEmail(),
                usuario.getSenha())).collect(Collectors.toList());
    }

    public UserDto atualizarUsuario(Long id, UserDto usuarioDto) {
        UsuarioEntity usuario = usuarioRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));

        usuario.setUsername(usuarioDto.username());
        usuario.setEmail(usuarioDto.email());
        usuario.setSenha(usuarioDto.senha());

        UsuarioEntity usuarioAtualizado = usuarioRepository.save(usuario);

        return new UserDto(
                usuarioAtualizado.getUsername(),
                usuarioAtualizado.getEmail(),
                usuarioAtualizado.getSenha()
        );
    }

    public void deletarUsuario(Long id) {
        UsuarioEntity usuario = usuarioRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));
        usuarioRepository.delete(usuario);
    }
}

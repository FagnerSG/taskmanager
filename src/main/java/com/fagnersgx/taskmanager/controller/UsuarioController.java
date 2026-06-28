package com.fagnersgx.taskmanager.controller;

import com.fagnersgx.taskmanager.dto.UserDto;
import com.fagnersgx.taskmanager.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.fagnersgx.taskmanager.entity.UsuarioEntity;

import java.util.List;

@RestController
@RequestMapping("/v1/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @PostMapping(path="/add")
    public ResponseEntity<UsuarioEntity> criarUsuario(@RequestBody UserDto createUsuarioDto) {
        UsuarioEntity novoUsuario = usuarioService.salvarUsuario(createUsuarioDto);
        return ResponseEntity.status(201).body(novoUsuario);
    }

    @GetMapping
    public ResponseEntity<List<UserDto>> getAllUsuarios() {
        List<UserDto> listUsuarios = usuarioService.listarTodosUsuarios();
        return ResponseEntity.ok().body(listUsuarios);
    }

    @PutMapping("/{id}")
    public ResponseEntity<UserDto> atualizarUsuario(@PathVariable Long id, @RequestBody UserDto usuarioDto) {
        UserDto usuarioAtualizado = usuarioService.atualizarUsuario(id, usuarioDto);
        return ResponseEntity.ok(usuarioAtualizado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarUsuario(@PathVariable Long id) {
        usuarioService.deletarUsuario(id);
        return ResponseEntity.noContent().build();
    }
    
}

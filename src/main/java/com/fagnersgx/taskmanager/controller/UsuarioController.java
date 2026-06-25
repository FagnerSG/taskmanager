package com.fagnersgx.taskmanager.controller;

import com.fagnersgx.taskmanager.dto.UserDto;
import com.fagnersgx.taskmanager.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fagnersgx.taskmanager.entity.UsuarioEntity;

import java.net.URI;

@RestController
@RequestMapping("/v1/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @PostMapping(path="/add")
    public ResponseEntity<UsuarioEntity> criarUsuario(@RequestBody UserDto createUsuarioDto) {
        UsuarioEntity novoUsuario = usuarioService.salvar(createUsuarioDto);
        return ResponseEntity.status(201).body(novoUsuario);
    }
    
}

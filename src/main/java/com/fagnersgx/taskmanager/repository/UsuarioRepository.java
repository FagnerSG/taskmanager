package com.fagnersgx.taskmanager.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fagnersgx.taskmanager.entity.UsuarioEntity;

@Repository
public interface UsuarioRepository extends JpaRepository<UsuarioEntity, Long> {
    
    List<UsuarioEntity> findList(String name);

    UsuarioEntity findById(long id);
}

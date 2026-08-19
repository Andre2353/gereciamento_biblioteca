package com.huariservice.gerenciamento_bibliotece.repository;

import com.huariservice.gerenciamento_bibliotece.entities.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario,Long> {
}

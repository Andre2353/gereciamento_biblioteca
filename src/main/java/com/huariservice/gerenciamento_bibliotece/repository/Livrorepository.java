package com.huariservice.gerenciamento_bibliotece.repository;

import com.huariservice.gerenciamento_bibliotece.entities.Livro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Livrorepository extends JpaRepository<Livro, Long> {
}

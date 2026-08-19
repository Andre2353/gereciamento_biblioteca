package com.huariservice.gerenciamento_bibliotece.repository;

import com.huariservice.gerenciamento_bibliotece.entities.Emprestimos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmprestimoRepository extends JpaRepository<Emprestimos, Long> {
}

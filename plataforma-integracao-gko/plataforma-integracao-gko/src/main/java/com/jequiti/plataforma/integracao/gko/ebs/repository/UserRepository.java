package com.jequiti.plataforma.integracao.gko.ebs.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jequiti.plataforma.integracao.gko.ebs.entity.Usuario;

@Repository
public interface UserRepository extends JpaRepository<Usuario, Long> {
	
	Optional<Usuario> findByFantasia(String fantasia);
}

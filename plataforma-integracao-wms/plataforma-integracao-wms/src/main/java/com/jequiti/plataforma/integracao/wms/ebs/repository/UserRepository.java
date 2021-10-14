package com.jequiti.plataforma.integracao.wms.ebs.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jequiti.plataforma.integracao.wms.ebs.entity.Usuario;

@Repository
public interface UserRepository extends JpaRepository<Usuario, Long> {
	
	Optional<Usuario> findByFantasia(String fantasia);
}

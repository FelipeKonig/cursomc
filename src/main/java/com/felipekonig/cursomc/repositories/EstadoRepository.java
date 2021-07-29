package com.felipekonig.cursomc.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.felipekonig.cursomc.domain.Estado;

@Repository
@Transactional(readOnly = true)
public interface EstadoRepository extends JpaRepository<Estado, Integer>{

	public Optional<Estado> findById(Integer id);
	public List<Estado> findAllByOrderByNome();
}

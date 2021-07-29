package com.felipekonig.cursomc.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.felipekonig.cursomc.domain.Estado;
import com.felipekonig.cursomc.repositories.EstadoRepository;
import com.felipekonig.cursomc.services.exceptions.ObjectNotFoundException;

@Service
public class EstadoService {
	
	@Autowired
	private EstadoRepository repo;
	
	public Estado find(Integer id) {
		Optional<Estado> cat = repo.findById(id);
		return cat.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Estado.class.getName()));
	}
	
	public List<Estado> findAll(){
		return repo.findAll();
	}

}

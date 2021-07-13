package com.felipekonig.cursomc.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.felipekonig.cursomc.domain.Produto;
import com.felipekonig.cursomc.repositories.ProdutoRepository;

@Service
public class ProdutoService {

	@Autowired
	private ProdutoRepository repo;

	public Produto buscar(Integer id) {
		Optional<Produto> cat = repo.findById(id);
		return cat.orElse(null);
	}
}

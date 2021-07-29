package com.felipekonig.cursomc.resources;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.felipekonig.cursomc.domain.Cidade;
import com.felipekonig.cursomc.domain.Estado;
import com.felipekonig.cursomc.dto.CidadeDTO;
import com.felipekonig.cursomc.dto.EstadoDTO;
import com.felipekonig.cursomc.services.CidadeService;
import com.felipekonig.cursomc.services.EstadoService;

@RestController
@RequestMapping("/estados")
public class EstadoResource {

	@Autowired
	private CidadeService service;

	@Autowired
	private EstadoService estadoService;

	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<EstadoDTO>> findAll() {

		List<Estado> list = estadoService.findAll();
		List<EstadoDTO> listDTO = list.stream().map(obj -> new EstadoDTO(obj)).collect(Collectors.toList());

		return ResponseEntity.ok().body(listDTO);
	}

	@RequestMapping(value = ("/{estadoId}/cidades"), method = RequestMethod.GET)
	public ResponseEntity<List<CidadeDTO>> findAll(@PathVariable Integer estadoId) {

		List<Cidade> list = service.findByEstado(estadoId);
		List<CidadeDTO> listDTO = list.stream().map(obj -> new CidadeDTO(obj)).collect(Collectors.toList());

		return ResponseEntity.ok().body(listDTO);
	}
}

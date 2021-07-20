package com.felipekonig.cursomc.domain;

import javax.persistence.Entity;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonTypeName;
import com.felipekonig.cursomc.domain.enums.EstadoPagamento;

@Entity
@JsonTypeName("pagamentoComCartao")
@Table(name = "tb_pagamento_cartao")
public class PagamentoComCartao extends Pagamento {
	private static final long serialVersionUID = 1L;

	private Integer numeroDeParcelas;

	public PagamentoComCartao() {
	}

	public PagamentoComCartao(Integer id, EstadoPagamento estado, Pedido pedido, Integer numeroDeParcelas) {
		super(id, estado, pedido);
		this.numeroDeParcelas = numeroDeParcelas;
	}

	public Integer getNumeroDeParcelas() {
		return numeroDeParcelas;
	}

	public void setNumeroDeParcelas(Integer numeroDeParcelas) {
		this.numeroDeParcelas = numeroDeParcelas;
	}

}

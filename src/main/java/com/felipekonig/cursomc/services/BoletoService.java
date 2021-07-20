package com.felipekonig.cursomc.services;

import java.util.Calendar;
import java.util.Date;

import org.springframework.stereotype.Service;

import com.felipekonig.cursomc.domain.PagamentoComBoleto;

@Service
public class BoletoService {

	public void preencherPagamentoComBoleto(PagamentoComBoleto pagto,Date instanteDoPedido) {
		
		Calendar cal = Calendar.getInstance();
		cal.setTime(instanteDoPedido);
		cal.add(Calendar.DAY_OF_WEEK, 7);
		pagto.setDataVencimento(cal.getTime());
	}
}

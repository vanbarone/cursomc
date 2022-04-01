package com.vanbarone.cursomc.domain;

import java.util.Date;

import javax.persistence.Entity;

import com.vanbarone.cursomc.domain.enuns.EstadoPagamento;

@Entity
public class PagamentoComBoleto extends Pagamento {
	private static final long serialVersionUID = 1L;

	private Date dtVencimento;
	private Date dtPagamento;
	
	public PagamentoComBoleto() {
	}
	
	public PagamentoComBoleto(Integer id, EstadoPagamento status, Pedido pedido, Date dtVencimento, Date dtPagamento) {
		super(id, status, pedido);
		this.dtVencimento = dtVencimento;
		this.dtPagamento = dtPagamento;
	}

	public Date getDtVencimento() {
		return dtVencimento;
	}

	public void setDtVencimento(Date dtVencimento) {
		this.dtVencimento = dtVencimento;
	}

	public Date getdtPagamento() {
		return dtPagamento;
	}

	public void setdtPagamento(Date dtPagamento) {
		this.dtPagamento = dtPagamento;
	}
	
}

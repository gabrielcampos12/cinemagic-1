package com.cinemagic.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.cinemagic.domain.Enums.StatusCompra;
import com.cinemagic.domain.Enums.TipoIngresso;
import com.cinemagic.domain.Enums.TipoPagamento;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Compra implements Serializable{

	private static final long serialVersionUID = 1L;
	
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@JsonFormat(pattern = "dd/MM/yyyy HH:mm")
	private Date instante;
	
	private Integer statusCompra;
	
	private Integer tipoPagamento;
	
	
	@OneToMany(mappedBy = "compra",cascade = CascadeType.ALL)
	private List<Ingresso> ingressos = new ArrayList<>();
	
	@ManyToOne()
	@JoinColumn(name = "cliente_id")
	private Cliente cliente;
	
	public Compra() {
		
	}

	private Compra(Integer id, Date instante,Cliente cliente,TipoPagamento tipoPagamento) {
		super();
		this.id = id;
		this.instante = instante;
		this.cliente = cliente;
		this.tipoPagamento = tipoPagamento == null? null : tipoPagamento.getCod() ;
		this.statusCompra = 2;
	}
	
	public static class CompraBuilder{
		private Integer id;
		private Date instante;
		private Cliente cliente;
		private TipoPagamento tipoPagamento;
		private Integer statusCompra;
		private List<Ingresso> ingressos = new ArrayList<>();
		public CompraBuilder() {
			statusCompra = 2;
		}
		public CompraBuilder id (Integer id) {
			this.id = id;
			return this;
		}
		public CompraBuilder instante (Date instante) {
			this.instante = instante;
			return this;
		}
		public CompraBuilder cliente (Cliente cliente) {
			this.cliente = cliente;
			return this;
		}
		public CompraBuilder tipoPagamento (TipoPagamento tipoPagamento) {
			this.tipoPagamento = tipoPagamento;
			return this;
		}
		public CompraBuilder ingressos(List<Ingresso> ingressos) {
			this.ingressos = ingressos;
			return this;
		}
		
		public Compra getCompra() {
			Compra compra = new Compra(id,instante,cliente,tipoPagamento);
			compra.setIngressos(ingressos);
			return compra;
		}
		
		
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getInstante() {
		return instante;
	}

	public void setInstante(Date instante) {
		this.instante = instante;
	}

	public double getValor() {
		double valor = 0;
		for(Ingresso i: ingressos) {
			if(i.getTipoIngresso() == TipoIngresso.INTEIRA) {
				valor += i.getSessao().getValorInteira();
			}
			else {
				valor += i.getSessao().getValorMeia();
			}
		}
		return valor;
		
	}
	
	


	

	public List<Ingresso> getIngressos() {
		return ingressos;
	}

	public void setIngressos(List<Ingresso> ingressos) {
		this.ingressos = ingressos;
	}

	
	
	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	
	

	public TipoPagamento getTipoPagamento() {
		return TipoPagamento.toEnum(tipoPagamento);
	}

	public void setTipoPagamento(TipoPagamento tipoPagamento) {
		this.tipoPagamento = tipoPagamento.getCod();
	}
	public StatusCompra getStatusCompra() {
		return StatusCompra.toStatusCompra(statusCompra);
	}
	public void setStatusCompra(StatusCompra statusCompra) {
		this.statusCompra = statusCompra.getCod();
	}

	@JsonIgnore
	public int getIngressosInteira() {
		int i = 0;
		for(Ingresso x : ingressos) {
			if(x.getTipoIngresso() == TipoIngresso.INTEIRA) {
				i++;
			}
		}
		return i;
	}
	@JsonIgnore
	public int getIngressosMeia() {
		int i = 0;
		for(Ingresso x: ingressos) {
			if(x.getTipoIngresso() == TipoIngresso.MEIA) {
				i++;
			}
		}
		return i;
	}
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Compra other = (Compra) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}


	
	
	
	
}

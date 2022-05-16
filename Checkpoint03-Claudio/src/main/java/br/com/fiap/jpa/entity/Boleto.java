package br.com.fiap.jpa.entity;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "tb_boleto")
@SequenceGenerator(name = "boleto", sequenceName = "SQ_TB_BOLETO", allocationSize = 1)
public class Boleto implements Serializable{

	public Boleto() {
		super();
	}
	
	public Boleto(Long id, String nossoNumero, LocalDateTime dataVencimento, Double valor, String codigoBarras) {
		super();
		this.id = id;
		this.nossoNumero = nossoNumero;
		this.dataVencimento = dataVencimento;
		this.valor = valor;
		this.codigoBarras = codigoBarras;
	}

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "boleto")
	private Long id;
	
	@Column(name = "nr_nossoNumero")
	private String nossoNumero;
	
	@Column(name = "dt_vencimento")
	private LocalDateTime dataVencimento;
	
	@Column(name = "nr_valor")
	private Double valor;
	
	@Column(name = "nr_codigoBarras")
	private String codigoBarras;
	
	//Relacao
	@OneToOne(mappedBy = "boleto", cascade = CascadeType.ALL)
	@PrimaryKeyJoinColumn
	private Pedido Pedido;
	
	
	//Getter e setter
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNossoNumero() {
		return nossoNumero;
	}

	public void setNossoNumero(String nossoNumero) {
		this.nossoNumero = nossoNumero;
	}

	public LocalDateTime getDataVencimento() {
		return dataVencimento;
	}

	public void setDataVencimento(LocalDateTime dataVencimento) {
		this.dataVencimento = dataVencimento;
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}

	public String getCodigoBarras() {
		return codigoBarras;
	}

	public void setCodigoBarras(String codigoBarras) {
		this.codigoBarras = codigoBarras;
	}

	@Override
	public String toString() {
		return "Boleto [id=" + id + ", nossoNumero=" + nossoNumero + ", dataVencimento=" + dataVencimento + ", valor="
				+ valor + ", codigoBarras=" + codigoBarras + "]";
	}
	
}

package br.com.fiap.jpa.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "tb_pedido")
@SequenceGenerator(name = "pedido", sequenceName = "SQ_TB_PEDIDO", allocationSize = 1)
public class Pedido implements Serializable{

	public Pedido() {
		super();
	}
	
	public Pedido(Long id, String cpf, String numeroPedido, int valorTotal) {
		super();
		this.id = id;
		this.cpf = cpf;
		this.numeroPedido = numeroPedido;
		this.valorTotal = valorTotal;
	}

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "pedido")
	private Long id;

	@Column(name = "nr_cpf")
	private String cpf;
	
	@Column(name = "nr_pedido")
	private String numeroPedido;
	
	@Column(name = "vl_total")
	private int valorTotal;
	
	//Relacao
	@OneToOne(optional = false)
	@JoinColumn(name = "boleto_id")
	private Boleto boleto;
	
	@OneToMany(mappedBy = "pedido")
	private List<ItemPedido> itemPedido;
	
	//getters e setters
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getNumeroPedido() {
		return numeroPedido;
	}

	public void setNumeroPedido(String numeroPedido) {
		this.numeroPedido = numeroPedido;
	}


	public int getValorTotal() {
		return valorTotal;
	}

	public void setValorTotal(int valorTotal) {
		this.valorTotal = valorTotal;
	}

	@Override
	public String toString() {
		return "Pedido [id=" + id + ", cpf=" + cpf + ", numeroPedido=" + numeroPedido + ", valorTotal=" + valorTotal
				+ "]";
	}
	
}

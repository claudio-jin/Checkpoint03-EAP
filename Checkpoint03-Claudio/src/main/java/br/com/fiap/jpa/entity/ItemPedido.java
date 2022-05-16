package br.com.fiap.jpa.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "tb_itemPedido")
@SequenceGenerator(name = "itemPedido", sequenceName = "SQ_TB_ITEMPEDIDO", allocationSize = 1)
public class ItemPedido implements Serializable{

	public ItemPedido() {
		super();
	}

	public ItemPedido(Long id, int quantidade) {
		super();
		this.id = id;
		this.quantidade = quantidade;
	}

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "itemPedido")
	private Long id;
	
	@Column(name = "nr_quantidade")
	private int quantidade;
	//Relacao
	
	@ManyToOne
	@JoinColumn(name = "pedido_id")
	private Pedido pedido;
	
	@ManyToOne
	@JoinColumn(name = "produto_id")
	private Produto produto;
	
	
	//Getter e setters
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

	@Override
	public String toString() {
		return "ItemPedido [id=" + id + ", quantidade=" + quantidade + "]";
	}
	
	

}

package br.com.fiap.jpa;

import br.com.fiap.jpa.service.impl.BoletoServiceImpl;
import br.com.fiap.jpa.service.impl.ItemPedidoServiceImpl;
import br.com.fiap.jpa.service.impl.PedidoServiceImpl;
import br.com.fiap.jpa.service.impl.ProdutoServiceImpl;

public class App {

	public static void main(String[] args) {
		
		ProdutoServiceImpl produtoService = ProdutoServiceImpl.getInstance();
		
		BoletoServiceImpl boletoService = BoletoServiceImpl.getInstance();
		
		PedidoServiceImpl pedidoService = PedidoServiceImpl.getInstance();
		
		ItemPedidoServiceImpl itemPedidoService = ItemPedidoServiceImpl.getInstance();
		
		System.out.println("listar produtos");
		produtoService.listar().forEach(System.out::println);
		
		System.out.println("listar boleto");
		boletoService.listar().forEach(System.out::println);
		
		System.out.println("listar pedido");
		pedidoService.listar().forEach(System.out::println);
		
		System.out.println("listar item Pedido");
		itemPedidoService.listar().forEach(System.out::println);
		
		
		System.out.println("Listar pedidos por cpf");
		pedidoService.listarPorCpf("111.111.111-11").forEach(System.out::println);

		System.out.println("Listar valor maior");
		produtoService.listarValorMaior(100.00).forEach(System.out::println);
		
		System.out.println("Listar pedidos com boleto");
		pedidoService.listarPedidosComBoleto().forEach(System.out::println);
		
		System.out.println("Listar produto por nome");
		produtoService.listarPorNome("caneta").forEach(System.out::println);
		
		System.out.println("Listar por valor");
		produtoService.listarPorValor(150.00).forEach(System.out::println);
		
		
	}
}

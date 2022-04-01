package com.vanbarone.cursomc;

import java.text.SimpleDateFormat;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.vanbarone.cursomc.domain.Categoria;
import com.vanbarone.cursomc.domain.Cidade;
import com.vanbarone.cursomc.domain.Cliente;
import com.vanbarone.cursomc.domain.Endereco;
import com.vanbarone.cursomc.domain.Estado;
import com.vanbarone.cursomc.domain.ItemPedido;
import com.vanbarone.cursomc.domain.Pagamento;
import com.vanbarone.cursomc.domain.PagamentoComBoleto;
import com.vanbarone.cursomc.domain.PagamentoComCartao;
import com.vanbarone.cursomc.domain.Pedido;
import com.vanbarone.cursomc.domain.Produto;
import com.vanbarone.cursomc.domain.enuns.EstadoPagamento;
import com.vanbarone.cursomc.domain.enuns.TipoCliente;
import com.vanbarone.cursomc.repositories.CategoriaRepository;
import com.vanbarone.cursomc.repositories.CidadeRepository;
import com.vanbarone.cursomc.repositories.ClienteRepository;
import com.vanbarone.cursomc.repositories.EnderecoRepository;
import com.vanbarone.cursomc.repositories.EstadoRepository;
import com.vanbarone.cursomc.repositories.PagamentoRepository;
import com.vanbarone.cursomc.repositories.PedidoRepository;
import com.vanbarone.cursomc.repositories.ProdutoRepository;

@SpringBootApplication
public class CursomcApplication implements CommandLineRunner{
	
	@Autowired
	private CategoriaRepository categoriaRepo;

	@Autowired
	private ProdutoRepository produtoRepo;
	
	@Autowired
	private EstadoRepository estadoRepo;
	
	@Autowired
	private CidadeRepository cidadeRepo;
	
	@Autowired
	private EnderecoRepository enderecoRepo;
	
	@Autowired
	private ClienteRepository clienteRepo;
	
	@Autowired
	private PedidoRepository pedidoRepo;
	
	@Autowired
	private PagamentoRepository pagamentoRepo;
	
	//@Autowired
	//private ItemPedidoRepository itemPedidoRepo;
	
	
	public static void main(String[] args) {
		SpringApplication.run(CursomcApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy hh:mm");
		
		Categoria cat1 = new Categoria(null, "Informática");
		Categoria cat2 = new Categoria(null, "Escritório");
		
		Produto p1 = new Produto(null, "Computador", 2000.0);
		Produto p2 = new Produto(null, "Impressora", 800.0);
		Produto p3 = new Produto(null, "Mouse", 80.0);
		
		//cat1.getProdutos().addAll(Arrays.asList(p1,p2,p3));
		//cat2.getProdutos().addAll(Arrays.asList(p2));
		
		cat1.setProdutos(Arrays.asList(p1,p2,p3));
		cat2.setProdutos(Arrays.asList(p2));
		
		//p1.getCategorias().addAll(Arrays.asList(cat1));
		//p2.getCategorias().addAll(Arrays.asList(cat1,cat2));
		//p3.getCategorias().addAll(Arrays.asList(cat1));
		
		p1.setCategorias(Arrays.asList(cat1));
		p2.setCategorias(Arrays.asList(cat1,cat2));
		p3.setCategorias(Arrays.asList(cat1));
		
		categoriaRepo.saveAll(Arrays.asList(cat1,cat2));
		produtoRepo.saveAll(Arrays.asList(p1,p2,p3));
		
		Estado e1 = new Estado(null, "Minas Gerais");
		Estado e2 = new Estado(null, "São Paulo");
		
		Cidade c1 = new Cidade(null, "Uberlândia", e1);
		Cidade c2 = new Cidade(null, "São Paulo", e2);
		Cidade c3 = new Cidade(null, "Campinas", e2);
		
		
		estadoRepo.saveAll(Arrays.asList(e1,e2));
		cidadeRepo.saveAll(Arrays.asList(c1,c2,c3));
		
		Cliente cli1 = new Cliente(null, "Maria Silva", "maria@gmail.com", "3637892377", TipoCliente.PESSOA_FISICA);
		
		cli1.getTelefones().addAll(Arrays.asList("27363323","93838393"));
		
		clienteRepo.save(cli1);
		
		Endereco end1 = new Endereco(null, "Rua Flores", "300" , "Apto 203", "Jardim", "38220834", cli1, c1);
		Endereco end2 = new Endereco(null, "Av. Matos", "105" , "Sala 800", "Centro", "38777012", cli1, c2);
		
		enderecoRepo.saveAll(Arrays.asList(end1,end2));
		
		Pedido ped1 = new Pedido(null, sdf.parse( "30/09/2017 10:32"), cli1, end1);
		Pedido ped2 = new Pedido(null,sdf.parse( "10/10/2017 19:35"), cli1, end2);
		
		Pagamento pagto1 = new PagamentoComCartao(null, EstadoPagamento.QUITADO, ped1, 6);
		ped1.setPagamento(pagto1);
		
		Pagamento pagto2 = new PagamentoComBoleto(null, EstadoPagamento.PENDENTE, ped2, sdf.parse("20/10/2017 10:30"), null);
		ped2.setPagamento(pagto2);
		
		pedidoRepo.saveAll(Arrays.asList(ped1, ped2));
		pagamentoRepo.saveAll(Arrays.asList(pagto1, pagto2));
				
		ItemPedido item1 = new ItemPedido(ped1, p1, 1, 2000.0, 0.0);
		ItemPedido item2 = new ItemPedido(ped1, p3, 2, 80.0, 0.0);
		ItemPedido item3 = new ItemPedido(ped2, p2, 1, 800.0, 100.0);
		
		//itemPedidoRepo.saveAll(Arrays.asList(item1,item2,item3));
		
	}

}

package com.vanbarone.cursomc;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.vanbarone.cursomc.domain.Categoria;
import com.vanbarone.cursomc.domain.Cidade;
import com.vanbarone.cursomc.domain.Estado;
import com.vanbarone.cursomc.domain.Produto;
import com.vanbarone.cursomc.repositories.CategoriaRepository;
import com.vanbarone.cursomc.repositories.CidadeRepository;
import com.vanbarone.cursomc.repositories.EstadoRepository;
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
	
	
	public static void main(String[] args) {
		SpringApplication.run(CursomcApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
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
		
		Cidade c1 = new Cidade(null, "São Paulo", e2);
		Cidade c2 = new Cidade(null, "Campinas", e2);
		Cidade c3 = new Cidade(null, "Uberlândia", e1);
		
		estadoRepo.saveAll(Arrays.asList(e1,e2));
		cidadeRepo.saveAll(Arrays.asList(c1,c2,c3));
				
	}

}

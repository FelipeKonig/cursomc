package com.felipekonig.cursomc;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.felipekonig.cursomc.domain.Categoria;
import com.felipekonig.cursomc.domain.Cidade;
import com.felipekonig.cursomc.domain.Cliente;
import com.felipekonig.cursomc.domain.Endereco;
import com.felipekonig.cursomc.domain.Estado;
import com.felipekonig.cursomc.domain.Produto;
import com.felipekonig.cursomc.domain.enums.TipoCliente;
import com.felipekonig.cursomc.repositories.CategoriaRepository;
import com.felipekonig.cursomc.repositories.CidadeRepository;
import com.felipekonig.cursomc.repositories.ClienteRepository;
import com.felipekonig.cursomc.repositories.EnderecoRepository;
import com.felipekonig.cursomc.repositories.EstadoRepository;
import com.felipekonig.cursomc.repositories.ProdutoRepository;

@SpringBootApplication
public class CursomcApplication implements CommandLineRunner {

	@Autowired
	private CategoriaRepository repoCategoria;

	@Autowired
	private ProdutoRepository repoProduto;

	@Autowired
	private CidadeRepository repoCidade;

	@Autowired
	private EstadoRepository repoEstado;
	
	@Autowired
	private ClienteRepository repoCliente;
	
	@Autowired
	private EnderecoRepository repoEndereco;

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

		cat1.getProdutos().addAll(Arrays.asList(p1, p2, p3));
		cat2.getProdutos().add(p1);

		p1.getCategorias().add(cat1);
		p2.getCategorias().addAll(Arrays.asList(cat1, cat2));
		p3.getCategorias().add(cat1);

		repoCategoria.saveAll(Arrays.asList(cat1, cat2));
		repoProduto.saveAll(Arrays.asList(p1, p2, p3));

		Estado est1 = new Estado(null, "Minas Gerais");
		Estado est2 = new Estado(null, "São Paulo");

		Cidade c1 = new Cidade(null, "Uberlândia", est1);
		Cidade c2 = new Cidade(null, "São Paulo", est2);
		Cidade c3 = new Cidade(null, "Campinas", est2);

		est1.getCidades().add(c1);
		est2.getCidades().addAll(Arrays.asList(c2, c3));

		repoEstado.saveAll(Arrays.asList(est1, est2));
		repoCidade.saveAll(Arrays.asList(c1, c2, c3));

		Cliente cli1 = new Cliente(null, "Maria Silva", "maria@gmail.com", "3637411891", TipoCliente.PESSOAFISICA);
		
		cli1.getTelefones().addAll(Arrays.asList("11981645", "19813187"));
		
		Endereco e1 = new Endereco(null, "Rua Flores", "300", "Apto 300", "Jardim", "395651", cli1, c1);
		Endereco e2 = new Endereco(null, "Avenida Matos", "105", "Sal 800", "Centro", "156132", cli1, c2);
		
		cli1.getEnderecos().addAll(Arrays.asList(e1, e2));
		
		repoCliente.save(cli1);
		repoEndereco.saveAll(Arrays.asList(e1, e2));
	}

}

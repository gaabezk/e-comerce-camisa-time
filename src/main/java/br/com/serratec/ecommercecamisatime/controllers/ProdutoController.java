package br.com.serratec.ecommercecamisatime.controllers;

import br.com.serratec.ecommercecamisatime.exceptions.IdNotFoundException;
import br.com.serratec.ecommercecamisatime.exceptions.ProdutoExistentException;
import br.com.serratec.ecommercecamisatime.models.Produto;
import br.com.serratec.ecommercecamisatime.modelsDTO.ProdutoDTO;
import br.com.serratec.ecommercecamisatime.services.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/produto")
public class ProdutoController {

	@Autowired
	ProdutoService produtoService;

	// METODO 1
	/*
	 * @GetMapping public List<Produto> listar() { return
	 * produtoService.listarProdutos(); }
	 */

	// METODO 2
	@GetMapping
	public ResponseEntity<List<Produto>> getAll() {
		HttpHeaders headers = new HttpHeaders();
		headers.add("Lista de Produtos", "Segue a lista de produtos");
		return new ResponseEntity<List<Produto>>(produtoService.listar(), headers, HttpStatus.valueOf(202));
	}

	@GetMapping("/{id}")
	public ResponseEntity<Produto> getById(@PathVariable Integer id) throws IdNotFoundException {
		return new ResponseEntity<Produto>(produtoService.listarPorId(id), HttpStatus.FOUND);
	}

	@PostMapping("/{categoria}")
	public ResponseEntity<ProdutoDTO> insert(@RequestBody ProdutoDTO produtoDTO,@PathVariable String categoria) throws ProdutoExistentException {
		produtoService.criar(produtoDTO,categoria);
		HttpHeaders headers = new HttpHeaders();
		headers.add("Inserir produto", "Insere um produto e retorna ele");
		return new ResponseEntity<>(produtoDTO, headers, HttpStatus.CREATED);
	}
}

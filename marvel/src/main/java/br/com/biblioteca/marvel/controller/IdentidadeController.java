package br.com.biblioteca.marvel.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.biblioteca.marvel.core.crud.CrudController;
import br.com.biblioteca.marvel.domain.Identidade;
import br.com.biblioteca.marvel.repository.IdentidadeRepository;

@RestController
@RequestMapping("/identidade")
public class IdentidadeController extends CrudController<Identidade, Long> {
		
	
	@Autowired
	public IdentidadeRepository getRepository;
	
	@GetMapping(path="/nome/{nome}")
	public Identidade listarNome(@PathVariable String nome) {
		return getRepository.findByNome(nome);
	}	
	
	@GetMapping(path="/profissao/{profissao}")	
	public ResponseEntity<Identidade> listarProfissao(@PathVariable String profissao) {
		return ResponseEntity.ok(getRepository.consultarPelaProfissao(profissao));
		
	}
	
	@GetMapping("/ordenar")
	public ResponseEntity<List<Identidade>> ordenarPorNome(){
		List<Identidade> nomes = getRepository.findAllSortByName();
		return ResponseEntity.ok(nomes);
	}
}

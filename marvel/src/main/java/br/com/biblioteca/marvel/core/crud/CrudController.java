package br.com.biblioteca.marvel.core.crud;

import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

public abstract class CrudController<T, ID> {
	
	@Autowired
	protected CrudService<T, ID> service;
	
	@GetMapping
	public ResponseEntity<List<T>> listar(){
		var listaMarvel = service.listar();
		return ResponseEntity.ok(listaMarvel);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<T> individual(@PathVariable("id") ID id){
		var individual = service.listarId(id);
		
		if (Objects.isNull(individual)) {
			return ResponseEntity.notFound().build();
		}
		
		return ResponseEntity.ok(individual);
	}
	
	@PostMapping
	public ResponseEntity<T> criar(@RequestBody T marvel){
		var salvar = service.criar(marvel);
		return ResponseEntity.ok(salvar);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<T> editar(@PathVariable("id") ID id, @RequestBody T marvel){
		return ResponseEntity.ok(service.editar(id, marvel));
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> excluir(@PathVariable("id") ID id){
		service.excluir(id);
		return ResponseEntity.ok().build();
	}

}

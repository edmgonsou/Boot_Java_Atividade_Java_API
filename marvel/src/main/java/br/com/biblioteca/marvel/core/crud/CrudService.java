package br.com.biblioteca.marvel.core.crud;

import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;

public abstract class CrudService<T, ID> {
	
	@Autowired
	protected CrudRepository<T, ID> repository;
	
	public List<T> listar(){
		return repository.findAll();
	}
	
	public T listarId(ID id) {
		return repository.findById(id).orElse(null);
	}
	
	public T criar(T marvel) {
		return repository.save(marvel);
	}
	
	public T editar (ID id, T marvel) {
		var buscar = listarId(id);
		
		if(Objects.isNull(buscar)) {
			throw new RuntimeException("Não foi encontrado");
		}
		
		var marvelSalvar = editarMarvel(buscar, marvel);
		return repository.save(marvelSalvar);
		
	}

	protected abstract T editarMarvel(T buscar, T marvel);
	
	public void excluir(ID id) {
		repository.deleteById(id);
	}

}

package br.com.biblioteca.marvel.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.biblioteca.marvel.core.crud.CrudRepository;
import br.com.biblioteca.marvel.domain.Identidade;

@Repository
public interface IdentidadeRepository extends CrudRepository<Identidade, Long> {

		Identidade findByNome(String nome);
	
		@Query(value = "select i from Identidade i where i.profissao = ?1")
		Identidade consultarPelaProfissao(String profissao);
	 
		@Query(value = "select * from identidade order by nome", nativeQuery = true)
		List<Identidade> findAllSortByName();
}

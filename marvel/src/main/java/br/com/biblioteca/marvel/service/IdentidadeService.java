package br.com.biblioteca.marvel.service;

import org.springframework.stereotype.Service;

import br.com.biblioteca.marvel.core.crud.CrudService;
import br.com.biblioteca.marvel.domain.Identidade;


@Service
public class IdentidadeService extends CrudService<Identidade, Long> {

	@Override
	protected Identidade editarMarvel(Identidade buscar, Identidade marvel) {
		buscar.setNome(marvel.getNome());
		buscar.setProfissao(marvel.getProfissao());
		return buscar;
	}
	
}

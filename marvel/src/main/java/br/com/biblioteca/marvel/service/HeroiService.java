package br.com.biblioteca.marvel.service;

import org.springframework.stereotype.Service;

import br.com.biblioteca.marvel.core.crud.CrudService;
import br.com.biblioteca.marvel.domain.Heroi;

@Service
public class HeroiService extends CrudService<Heroi, Long> {
	
	@Override
	protected Heroi editarMarvel(Heroi buscar, Heroi marvel) {
		buscar.setNome(marvel.getNome());
		buscar.setPoder(marvel.getPoder());
		return buscar;
	}

}

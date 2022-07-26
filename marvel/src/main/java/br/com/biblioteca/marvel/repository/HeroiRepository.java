package br.com.biblioteca.marvel.repository;

import org.springframework.stereotype.Repository;

import br.com.biblioteca.marvel.core.crud.CrudRepository;
import br.com.biblioteca.marvel.domain.Heroi;

@Repository
public interface HeroiRepository extends CrudRepository<Heroi, Long> {

}

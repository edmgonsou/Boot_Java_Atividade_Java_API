package br.com.biblioteca.marvel.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.biblioteca.marvel.core.crud.CrudController;
import br.com.biblioteca.marvel.domain.Identidade;

@RestController
@RequestMapping("/identidade")
public class IdentidadeController extends CrudController<Identidade, Long> {

}

package br.com.biblioteca.marvel.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.biblioteca.marvel.core.crud.CrudController;
import br.com.biblioteca.marvel.domain.Heroi;

@RestController
@RequestMapping("/heroi")
public class HeroiController extends CrudController<Heroi, Long> {

}

package com.vanbarone.cursomc.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vanbarone.cursomc.domain.Categoria;
import com.vanbarone.cursomc.repositories.CategoriaRepository;
import com.vanbarone.cursomc.services.exceptions.ObjectNotFoundException;

@Service
public class CategoriaService {

	@Autowired
	private CategoriaRepository repo;
	
	public Categoria buscar(Integer id) {
		
		Optional<Categoria> obj = repo.findById(id);
		
		
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado! Id: " + id + ", Tipo: " + Categoria.class.getName(), null));
	}
}

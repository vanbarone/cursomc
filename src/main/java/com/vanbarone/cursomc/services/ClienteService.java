package com.vanbarone.cursomc.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vanbarone.cursomc.domain.Cliente;
import com.vanbarone.cursomc.repositories.ClienteRepository;

@Service
public class ClienteService {

	@Autowired
	private ClienteRepository repo;
	
	public List<Cliente> findAll() {
		return repo.findAll();
	}
}

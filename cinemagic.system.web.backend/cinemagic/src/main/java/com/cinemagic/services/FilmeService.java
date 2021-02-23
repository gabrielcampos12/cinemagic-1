package com.cinemagic.services;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cinemagic.domain.Filme;
import com.cinemagic.dto.FilmeDTO;
import com.cinemagic.repositories.FilmeRepository;
import com.cinemagic.services.exceptions.ObjectNotFoundException;

@Service
public class FilmeService {
	@Autowired
	FilmeRepository repo;

	public Filme findById(Integer id) {
		Optional<Filme> obj = repo.findById(id);
		return obj.orElseThrow(
				() -> new ObjectNotFoundException("Objeto não encontrado Id " + id + " Tipo" + Filme.class.getName()));

	}
	
	public Filme update(Filme obj) {
		Filme newObj = findById(obj.getId());
		updateData(newObj,obj);
		return repo.save(newObj);
	}
	
	private void updateData(Filme newObj, Filme obj) {
		newObj.setTitulo(obj.getTitulo());
		newObj.setGenero(obj.getGenero());
		newObj.setDuracao(obj.getDuracao());
	}

	public Filme insert(Filme filme) {
		filme.setId(null);
		return repo.save(filme);
	}
	
	/**
	 * -Matheus 15/02
	 * duvida do objetivo do metodo fromDTO para o Filme
	 * @param objDto
	 * @return
	 */
	@Transactional
	public Filme fromDTO(FilmeDTO objDto) {
		Filme filme = new Filme(null, null, null, null);
		return filme;
	}

}
package com.centertransmition.cinemagic.services.interfaces;

import java.util.List;

import com.centertransmition.cinemagic.entity.Ator;

public interface AtorInterface {
	
	public Ator insertAtor(Ator ator);
	
	public Ator findById(Integer id);
	
	public List<Ator> findAll();
	
	public void delete(Integer id);
	
}

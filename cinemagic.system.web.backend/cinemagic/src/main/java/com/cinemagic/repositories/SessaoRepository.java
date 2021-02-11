package com.cinemagic.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cinemagic.domain.Sessao;

@Repository
public interface SessaoRepository extends JpaRepository<Sessao, Integer>{

}

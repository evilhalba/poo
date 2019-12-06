package com.pootrab.repository;

import org.springframework.data.repository.CrudRepository;

import com.pootrab.models.Seguradora;
import com.pootrab.models.TipoDeslocamento;

public interface TipoDeslocamentoRepository extends CrudRepository<TipoDeslocamento,String>{
	TipoDeslocamento findByTipodeslocamentoid(String tipodeslocamentoid);
}

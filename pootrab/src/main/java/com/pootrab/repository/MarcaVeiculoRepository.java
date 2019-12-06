package com.pootrab.repository;

import org.springframework.data.repository.CrudRepository;

import com.pootrab.models.MarcaVeiculo;

public interface MarcaVeiculoRepository extends CrudRepository<MarcaVeiculo,String>{
	MarcaVeiculo findByMarcaveiculoid(String marcaveiculoid);
}

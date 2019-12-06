package com.pootrab.repository;

import org.springframework.data.repository.CrudRepository;

import com.pootrab.models.ModeloVeiculo;

public interface ModeloVeiculoRepository extends CrudRepository<ModeloVeiculo,String>{
	ModeloVeiculo findByModeloveiculoid(String modeloveiculoid);
}

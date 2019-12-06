package com.pootrab.repository;

import org.springframework.data.repository.CrudRepository;

import com.pootrab.models.Seguradora;

public interface SeguradoraRepository extends CrudRepository<Seguradora,Integer>{
	Seguradora findById(int id);
}

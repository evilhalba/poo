package com.pootrab.repository;

import org.springframework.data.repository.CrudRepository;

import com.pootrab.models.Seguradora;
import com.pootrab.models.Veiculo;

public interface VeiculoRepository extends CrudRepository<Veiculo,Integer>{
Veiculo findById(int id);
}

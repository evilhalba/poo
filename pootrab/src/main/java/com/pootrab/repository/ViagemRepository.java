package com.pootrab.repository;

import org.springframework.data.repository.CrudRepository;

import com.pootrab.models.Seguradora;
import com.pootrab.models.Viagem;

public interface ViagemRepository extends CrudRepository<Viagem,Integer>{

}

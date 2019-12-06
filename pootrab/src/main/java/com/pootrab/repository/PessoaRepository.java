package com.pootrab.repository;

import org.springframework.data.repository.CrudRepository;

import com.pootrab.models.Pessoa;


public interface PessoaRepository extends CrudRepository<Pessoa,Integer>{
Pessoa findByIdPessoa(int idPessoa);
}

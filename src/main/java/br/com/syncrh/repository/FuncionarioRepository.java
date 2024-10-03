package br.com.syncrh.repository;

import org.springframework.stereotype.Repository;

import br.com.syncrh.domain.entity.Funcionario;

@Repository
public interface FuncionarioRepository extends GenericRepository<Funcionario, Long>{

}

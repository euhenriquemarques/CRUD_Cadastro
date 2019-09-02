package desafio.BackEnd.Desafio.BackEnd.repository;

import org.springframework.data.repository.CrudRepository;

import desafio.BackEnd.Desafio.BackEnd.modelos.Cadastro;

public interface CadastroRepository extends CrudRepository<Cadastro, String>{
	Cadastro findById(long id);

}

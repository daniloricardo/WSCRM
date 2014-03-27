package nelsys.repository;

import java.util.List;

import javax.persistence.EntityManager;

import nelsys.model.Pessoa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class PessoaRepository {

	@Autowired
	EntityManager entityManager;
	
	@SuppressWarnings("unchecked")
	public List<Pessoa> lista(){
		return entityManager.createQuery("from Pessoa p ").getResultList();
	}
}

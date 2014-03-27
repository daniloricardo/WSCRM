package nelsys.repository;

import java.util.List;

import javax.persistence.EntityManager;

import nelsys.model.Tipocontato;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class TipoContatoRepository {
	
	@Autowired
	EntityManager entityManager;

	@SuppressWarnings("unchecked")
	public List<Tipocontato> lista(){
		return entityManager.createQuery("from Tipocontato t").getResultList();
	}
}

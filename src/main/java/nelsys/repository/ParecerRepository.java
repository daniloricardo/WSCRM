package nelsys.repository;

import java.util.List;

import javax.persistence.EntityManager;

import nelsys.model.Atendimento;
import nelsys.model.Parecer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ParecerRepository {

	@Autowired
	EntityManager entityManager;
	
	@SuppressWarnings("unchecked")
	public List<Parecer> listaPorId(int idatendimento){
		
		
		return entityManager.createQuery("from Parecer p where p.idatendimento = ?1 order by p.dtfinalparecer desc")
				.setParameter(1, idatendimento).getResultList();
	}
	public void insereParecer(Parecer parecer){
		entityManager.getTransaction().begin();
		entityManager.persist(parecer);
		entityManager.getTransaction().commit();
		
	}
}

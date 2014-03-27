package nelsys.repository;

import java.util.List;

import javax.persistence.EntityManager;

import nelsys.model.Fase;
import nelsys.model.WorkFlowItem;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class FaseRepository {
	
	@Autowired
	EntityManager entityManager;
	
	@SuppressWarnings("unchecked")
	public Fase findById(String idfase){
		
		return (Fase) entityManager.createQuery("from Fase f where f.idfase = :idfase").
		setParameter("idfase", idfase).setMaxResults(1).getResultList().get(0);
	}
}

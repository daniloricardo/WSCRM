package nelsys.repository;

import java.util.List;

import javax.persistence.EntityManager;

import nelsys.model.Atendimento;
import nelsys.model.Parecer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class AtendimentoRepository {

	@Autowired
	EntityManager entityManager;
	
	@SuppressWarnings("unchecked")
	public List<Atendimento> findAllPorUsuario(String idusuario){
		
		return entityManager.
				createQuery("from Atendimento a where a.stencerrado = 'N' and a.idusuario = :idusuario")
				.setParameter("idusuario", idusuario)
				.getResultList();
	}
	public void atualizaAtendimento(Parecer parecer){
		Atendimento atendimento = entityManager.find(Atendimento.class, parecer.getIdatendimento());
		if(atendimento != null){
			atendimento.setIdusuario(parecer.getIdusuarioproximocontato());
			atendimento.setDtultimaatualizacao(parecer.getDatainicioparecer());
			atendimento.setIdfase(parecer.getIdfasedestino());
			atendimento.setDtproximoatendimento(parecer.getDtproximocontato());
			entityManager.getTransaction().begin();
			entityManager.persist(atendimento);
			entityManager.getTransaction().commit();
			
		
		}
	}
}

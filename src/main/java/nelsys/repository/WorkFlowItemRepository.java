package nelsys.repository;

import java.util.List;

import javax.persistence.EntityManager;

import nelsys.model.WorkFlowItem;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class WorkFlowItemRepository {
	
	@Autowired
	EntityManager entityManager;
	
	@SuppressWarnings("unchecked")
	public List<WorkFlowItem> listaProximo(String idworkflow,String idfase){
		
		return entityManager.createNativeQuery("select * from WorkFlowItem wi where wi.cdordem = "+
			" ( "+
			" select top 1 cdproximaordem from WorkFlowItem where idworkflow = :idworkflow and idfase = :idfase) "+
			" and wi.idworkflow = :idworkflow "+
			" order by wi.cdordem",WorkFlowItem.class).
			setParameter("idworkflow", idworkflow).
			setParameter("idfase", idfase).
			setMaxResults(1)
			.getResultList();
	}
	public WorkFlowItem localizaPorWorkFlowEOrdem(String idworkflow,String ordem){
		
		return (WorkFlowItem) entityManager.createQuery("from WorkFlowItem wi where wi.idworkflow = :idworkflow and wi.cdordem = :ordem").
				setParameter("idworkflow", idworkflow).
				setParameter("ordem", ordem).
				getResultList().get(0);
		
	}
public WorkFlowItem localizaPorWorkFlowEOrdemB(String idworkflow,String ordem){
		
		return (WorkFlowItem) entityManager.createNativeQuery(""+
				" select * from WorkFlowItem wi where wi.IdWorkFlow = :idworkflow  and wi.cdordem = "+
				" (select top 1 wi2.cdproximaordem from WorkFlowItem wi2 where wi2.idworkflow " +
				" = :idworkflow  and wi2.cdordem = :ordem )",WorkFlowItem.class).
				setParameter("idworkflow", idworkflow).
				setParameter("ordem", ordem).
				getResultList().get(0);
		
	}
}

package nelsys.repository;

import java.util.List;

import javax.persistence.EntityManager;

import nelsys.model.Usuario;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class UsuarioRepository {
		
	@Autowired
	EntityManager entityManager;
	
	@SuppressWarnings("unchecked")
	public List<Usuario> lista(){
		return entityManager.createQuery("from Usuario u where u.stativo = 'S'").getResultList();
	}
	public Usuario selecionaUsuarioPorLogin(String login){
		login = converteUsuarioSupervisor(login);
		return (Usuario) entityManager.createQuery("from Usuario u where u.stativo = 'S' and u.nmlogin = :login")
				.setParameter("login", login)
				.getResultList().get(0);
	}
	public String converteUsuarioSupervisor(String nome){
		nome = nome.toUpperCase();
		if(nome.equals("SA")){
			nome = "SUPERVISOR";
		}
		return nome;
	}
		
}

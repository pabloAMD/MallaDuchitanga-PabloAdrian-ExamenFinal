package ec.edu.ups.ejb;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import ec.edu.ups.modelo.CitaMedica;
import ec.edu.ups.modelo.Signos;


@Stateless
public class SignosFacade extends AbstractFacade<Signos> {
	
	@PersistenceContext(unitName = "peristenciaExa")
	private EntityManager em;
	
	public SignosFacade() {
		super(Signos.class);
		// TODO Auto-generated constructor stub
	}


	@Override
	protected EntityManager getEntityManager() {
		// TODO Auto-generated method stub
		return em;
	}
	
	

}
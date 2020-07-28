package ec.edu.ups.ejb;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import ec.edu.ups.modelo.CitaMedica;
import ec.edu.ups.modelo.Paciente;


@Stateless
public class CitaFacade extends AbstractFacade<CitaMedica> {
	
	
	@PersistenceContext(unitName = "peristenciaExa")
	private EntityManager em;
	
	public CitaFacade() {
		super(CitaMedica.class);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	protected EntityManager getEntityManager() {
		// TODO Auto-generated method stub
		return em;
	}

}

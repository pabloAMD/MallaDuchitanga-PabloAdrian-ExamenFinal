package ec.edu.ups.ejb;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;


import ec.edu.ups.modelo.Paciente;


@Stateless
public class PacienteFacade extends AbstractFacade<Paciente> {
	
	@PersistenceContext(unitName = "peristenciaExa")
	private EntityManager em;

	public PacienteFacade() {
		super(Paciente.class);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected EntityManager getEntityManager() {
		// TODO Auto-generated method stub
		return em;
	}
	
	public Paciente readAutor(String nombre) {
		Query query = em.createNamedQuery("getByPaciente");
		query.setParameter("nombre", nombre);
		List result = query.getResultList();
		Paciente respuesta = null;
		if (!result.isEmpty()) {
			respuesta = (Paciente)result.get(0);
		}
		return respuesta;
	}

}

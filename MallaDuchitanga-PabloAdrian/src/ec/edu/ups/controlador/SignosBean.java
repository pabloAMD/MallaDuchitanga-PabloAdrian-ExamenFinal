package ec.edu.ups.controlador;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.faces.annotation.FacesConfig;
import javax.inject.Named;

import ec.edu.ups.ejb.CitaFacade;
import ec.edu.ups.ejb.SignosFacade;
import ec.edu.ups.modelo.CitaMedica;
import ec.edu.ups.modelo.Signos;


@FacesConfig(version = FacesConfig.Version.JSF_2_3)
@Named
@RequestScoped
public class SignosBean implements Serializable {

	
	private static final long serialVersionUID = 1L;
	
	@EJB
	private SignosFacade ejbSignos;
	private List<Signos> list;
	
	private String presion;
	private String frecuenciaCardiaca;
	private String frecuenciaRespiratoria;
	private double temperatura;
	private double saturacion;
	
	@EJB
	private CitaFacade ejbCitaMedica;
	private List<CitaMedica> citaMedicaList;
	
	
	public SignosBean() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	@PostConstruct
	public void init() {
		list = ejbSignos.findAll();
		citaMedicaList = ejbCitaMedica.findAll();
	}
	
	public Signos[] getList() {
		return list.toArray(new Signos[0]);
	}

	public SignosFacade getEjbSignos() {
		return ejbSignos;
	}

	public void setEjbSignos(SignosFacade ejbSignos) {
		this.ejbSignos = ejbSignos;
	}


	public void setList(List<Signos> list) {
		this.list = list;
	}

	public String getPresion() {
		return presion;
	}

	public void setPresion(String presion) {
		this.presion = presion;
	}

	public String getFrecuenciaCardiaca() {
		return frecuenciaCardiaca;
	}

	public void setFrecuenciaCardiaca(String frecuenciaCardiaca) {
		this.frecuenciaCardiaca = frecuenciaCardiaca;
	}

	public String getFrecuenciaRespiratoria() {
		return frecuenciaRespiratoria;
	}

	public void setFrecuenciaRespiratoria(String frecuenciaRespiratoria) {
		this.frecuenciaRespiratoria = frecuenciaRespiratoria;
	}

	public double getTemperatura() {
		return temperatura;
	}

	public void setTemperatura(double temperatura) {
		this.temperatura = temperatura;
	}

	public double getSaturacion() {
		return saturacion;
	}

	public void setSaturacion(double saturacion) {
		this.saturacion = saturacion;
	}
	
	public String add() {
		//ejbSignos.create(new Signos(this.presion, this.frecuenciaCardiaca, this.frecuenciaRespiratoria, temperatura, this.saturacion) );
		list = ejbSignos.findAll();
		return null;
	}
	

}

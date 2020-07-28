package ec.edu.ups.controlador;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.faces.annotation.FacesConfig;
import javax.inject.Named;

import ec.edu.ups.ejb.CitaFacade;
import ec.edu.ups.ejb.PacienteFacade;
import ec.edu.ups.modelo.CitaMedica;
import ec.edu.ups.modelo.Paciente;
import ec.edu.ups.modelo.Signos;

@FacesConfig(version = FacesConfig.Version.JSF_2_3)
@Named
@RequestScoped
public class CitaMedicaBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@EJB
	private CitaFacade ejbCita;
	private List<CitaMedica> list;
	
	private String nombreA;
	
	private String fecha;
	private String hora;
	private String sintomas;
	private String alergias;
	private String enfermedadesPrevias;
	
	@EJB
	private PacienteFacade ejbPaciente;
	private List<Paciente> pacienteList;
	
	
	public CitaMedicaBean() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	@PostConstruct
	public void init() {
		list = ejbCita.findAll();
		pacienteList= ejbPaciente.findAll();
	}

	
	public String getNombreA() {
		return nombreA;
	}

	public void setNombreA(String nombreA) {
		this.nombreA = nombreA;
	}

	public CitaFacade getEjbCita() {
		return ejbCita;
	}

	public void setEjbCita(CitaFacade ejbCita) {
		this.ejbCita = ejbCita;
	}

	public CitaMedica[] getList() {
		return list.toArray(new CitaMedica[0]);
	}
	public void setList(List<CitaMedica> list) {
		this.list = list;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public String getHora() {
		return hora;
	}

	public void setHora(String hora) {
		this.hora = hora;
	}

	public String getSintomas() {
		return sintomas;
	}

	public void setSintomas(String sintomas) {
		this.sintomas = sintomas;
	}

	public String getAlergias() {
		return alergias;
	}

	public void setAlergias(String alergias) {
		this.alergias = alergias;
	}

	public String getEnfermedadesPrevias() {
		return enfermedadesPrevias;
	}

	public void setEnfermedadesPrevias(String enfermedadesPrevias) {
		this.enfermedadesPrevias = enfermedadesPrevias;
	}

	public PacienteFacade getEjbPaciente() {
		return ejbPaciente;
	}

	public void setEjbPaciente(PacienteFacade ejbPaciente) {
		this.ejbPaciente = ejbPaciente;
	}

	public List<Paciente> getPacienteList() {
		return pacienteList;
	}

	public void setPacienteList(List<Paciente> pacienteList) {
		this.pacienteList = pacienteList;
	}
	
	public String add() {
		Paciente p= ejbPaciente.readAutor(this.nombreA);
				
		ejbCita.create(new CitaMedica(this.fecha, this.hora, this.sintomas, this.alergias, this.enfermedadesPrevias, p));
		list = ejbCita.findAll();
		return null;
	}
	
	

}

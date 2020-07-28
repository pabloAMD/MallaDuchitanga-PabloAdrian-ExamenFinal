package ec.edu.ups.controlador;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.faces.annotation.FacesConfig;
import javax.inject.Named;

import ec.edu.ups.ejb.PacienteFacade;

import ec.edu.ups.modelo.Paciente;

@FacesConfig(version = FacesConfig.Version.JSF_2_3)
@Named
@RequestScoped
public class PacienteBean implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private String nombreA;
	
	@EJB
	private PacienteFacade ejbPaciente;
	List<Paciente> list;
	
	private String cedula;
	private String nombre;
	private String apellido;
	private String telefono;
	private String direccion;
	private String correo;
	
	
	public PacienteBean() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	@PostConstruct
	public void init() {
		ejbPaciente.create(new Paciente("0102388301", "Pablo", "Malla", "0928181021", "Av Americas", "pmalla@gmail.com"));
		ejbPaciente.create(new Paciente("0102388321", "Juan", "Perez", "0928189835", "Av Solano", "jperez@gmail.com"));
		list= ejbPaciente.findAll();
	}

	public PacienteFacade getEjbPaciente() {
		return ejbPaciente;
	}

	public void setEjbPaciente(PacienteFacade ejbPaciente) {
		this.ejbPaciente = ejbPaciente;
	}

	public Paciente[] getList() {
		return list.toArray(new Paciente[0]);
	}

	public void setList(List<Paciente> list) {
		this.list = list;
	}

	public String getCedula() {
		return cedula;
	}

	public void setCedula(String cedula) {
		this.cedula = cedula;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}
	
	public String add() {
		ejbPaciente.create(new Paciente(this.cedula, this.nombre, this.apellido, this.telefono, this.direccion, this.correo));
		list = ejbPaciente.findAll();
		return null;
	}
	

	
	

}

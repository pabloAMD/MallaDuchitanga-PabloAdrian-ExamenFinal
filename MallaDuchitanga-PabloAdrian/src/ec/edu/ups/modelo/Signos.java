package ec.edu.ups.modelo;

import java.io.Serializable;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: Signos
 *
 */
@Entity

public class Signos implements Serializable {

	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int codigo;
	
	private String presion;
	private String frecuenciaCardiaca;
	private String frecuenciaRespiratoria;
	private double temperatura;
	private double saturacion;
	
	@OneToOne
	@JoinColumn
	private CitaMedica citaMedica;
	
	
	

	public Signos() {
		super();
	}




	public Signos(String presion, String frecuenciaCardiaca, String frecuenciaRespiratoria, double temperatura,
			double saturacion, CitaMedica citaMedica) {
		super();
		this.presion = presion;
		this.frecuenciaCardiaca = frecuenciaCardiaca;
		this.frecuenciaRespiratoria = frecuenciaRespiratoria;
		this.temperatura = temperatura;
		this.saturacion = saturacion;
		this.citaMedica= citaMedica;
	
	}




	public int getCodigo() {
		return codigo;
	}




	public void setCodigo(int codigo) {
		this.codigo = codigo;
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



	public CitaMedica getCitaMedica() {
		return citaMedica;
	}

	public void setCitaMedica(CitaMedica citaMedica) {
		this.citaMedica = citaMedica;
	}




	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + codigo;
		return result;
	}




	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Signos other = (Signos) obj;
		if (codigo != other.codigo)
			return false;
		return true;
	}
	
	
   
}

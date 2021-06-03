package ar.unju.edu.edm.model;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

//import java.util.Date;
import java.time.Period;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Component;

@Entity
@Table(name="CLIENTES")
@Component
public class Cliente {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private Integer idCliente;
	
	@Column (name="documento")
	@Min(100000)
	@Max(99999999)
	private int nroDocumento;
	
	@Column
	@NotNull(message="Debe incluirse su nombre y apellido")
	private String nombre;
	@Column
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate fechaNacimiento;
	
	/*@Column
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate fechaUltimCompra;
	*/
	@Column
	private String password;
	
	@Column
	private String tipoDocumento;
	
	@Column
	private int codigoAreaTelefono;
	
	@Column
	private int numTelefono;
	
	@Column
	private String email;
	
	@Column
	private Boolean activa;
	
	public Cliente() {
		// TODO Auto-generated constructor stub
	}
	
	public Integer getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(Integer idCliente) {
		this.idCliente = idCliente;
	}
	
	public int getNroDocumento() {
		return nroDocumento;
	}

	public void setNroDocumento(int nroDocumento) {
		this.nroDocumento = nroDocumento;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public LocalDate getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(LocalDate fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public String getTipoDocumento() {
		return tipoDocumento;
	}

	public void setTipoDocumento(String tipoDocumento) {
		this.tipoDocumento = tipoDocumento;
	}

	public int getCodigoAreaTelefono() {
		return codigoAreaTelefono;
	}

	public void setCodigoAreaTelefono(int codigoAreaTelefono) {
		this.codigoAreaTelefono = codigoAreaTelefono;
	}

	public int getNumTelefono() {
		return numTelefono;
	}

	public void setNumTelefono(int numTelefono) {
		this.numTelefono = numTelefono;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getEdad() {
		int edad = 0;
		LocalDate hoy = LocalDate.now();
		Period periodo = Period.between(fechaNacimiento, hoy);
		edad = periodo.getYears();
		return edad;
	}

	/*public LocalDate getFechaUltimCompra() {
		return fechaUltimCompra;
	}

	public void setFechaUltimCompra(LocalDate fechaUltimCompra) {
		this.fechaUltimCompra = fechaUltimCompra;
	}

	public String gettUltCompra() {
		LocalDate fechaActual = LocalDate.now();
		Period periodo = Period.between(fechaUltimCompra, fechaActual);
		return " T.D.U.C.  Año: " + periodo.getYears() + " Mes: " + periodo.getMonths() + " Dia: " + periodo.getDays();
	}
	*/
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public String gettNac() {
		LocalDate fechaActual = LocalDate.now();
		long dias = ChronoUnit.DAYS.between(fechaNacimiento, fechaActual);
		return " D.d.N: " + dias;
	}

	public String gettHastaCumple() {
		LocalDate fechaActual = LocalDate.now();
		LocalDate sigCumple = fechaNacimiento.withYear(fechaActual.getYear());
		if (sigCumple.isBefore(fechaActual) || sigCumple.isEqual(fechaActual)) {
			sigCumple = sigCumple.plusYears(1);
		}

		Period periodo = Period.between(fechaActual, sigCumple);
		long periodo2 = ChronoUnit.DAYS.between(fechaActual, sigCumple);
		return "T.h.s.C.: " + periodo.getMonths() + " meses  " + periodo.getDays() + " dias (" + periodo2
				+ " dias en total)";
	}

}
package edu.arelance.nube.repository.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.springframework.lang.NonNull;

@Entity
@Table(name = "restaurantes" )
public class Restaurante {
	
	@Id //indico a Spring que este será la clave primaria
	@GeneratedValue(strategy = GenerationType.IDENTITY)//autoInc en Mysql
	private Long id;
	
	@NotEmpty
	private String nombre;//x
	
	@NotEmpty
	private String direccion;//x
	
	@NotEmpty
	private String barrio;//x
	
	private String web;
	
	private String fichaGoogle;
	
	private Float latitud;
	
	private Float longuitud;
	
	@Min(2)
	@Max(500)
	private Integer precio;//x
	
	private String especialidad1;
	
	private String especialidad2;
	
	private String especialidad3;
	
	@Column(name = "creado_en")
	private LocalDateTime creadoEn;
	
	@PrePersist//este método, marcado así, se ejecuta antes de insertar el restaurante nuevo
	private void generarFechaCreacion ()
	{
		this.creadoEn = LocalDateTime.now();//obtengo la fecha actual
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getBarrio() {
		return barrio;
	}

	public void setBarrio(String barrio) {
		this.barrio = barrio;
	}

	public String getWeb() {
		return web;
	}

	public void setWeb(String web) {
		this.web = web;
	}

	public String getFichaGoogle() {
		return fichaGoogle;
	}

	public void setFichaGoogle(String fichaGoogle) {
		this.fichaGoogle = fichaGoogle;
	}

	public Float getLatitud() {
		return latitud;
	}

	public void setLatitud(Float latitud) {
		this.latitud = latitud;
	}

	public Float getLonguitud() {
		return longuitud;
	}

	public void setLonguitud(Float longuitud) {
		this.longuitud = longuitud;
	}

	public Integer getPrecio() {
		return precio;
	}

	public void setPrecio(Integer precio) {
		this.precio = precio;
	}

	public String getEspecialidad1() {
		return especialidad1;
	}

	public void setEspecialidad1(String especialidad1) {
		this.especialidad1 = especialidad1;
	}

	public String getEspecialidad2() {
		return especialidad2;
	}

	public void setEspecialidad2(String especialidad2) {
		this.especialidad2 = especialidad2;
	}

	public String getEspecialidad3() {
		return especialidad3;
	}

	public void setEspecialidad3(String especialidad3) {
		this.especialidad3 = especialidad3;
	}

	public LocalDateTime getCreadoEn() {
		return creadoEn;
	}

	public void setCreadoEn(LocalDateTime creadoEn) {
		this.creadoEn = creadoEn;
	}

	public Restaurante(Long id, String nombre, String direccion, String barrio, String web, String fichaGoogle,
			Float latitud, Float longuitud, Integer precio, String especialidad1, String especialidad2,
			String especialidad3, LocalDateTime creadoEn) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.direccion = direccion;
		this.barrio = barrio;
		this.web = web;
		this.fichaGoogle = fichaGoogle;
		this.latitud = latitud;
		this.longuitud = longuitud;
		this.precio = precio;
		this.especialidad1 = especialidad1;
		this.especialidad2 = especialidad2;
		this.especialidad3 = especialidad3;
		this.creadoEn = creadoEn;
	}
	
	public Restaurante() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Restaurante [id=" + id + ", nombre=" + nombre + ", direccion=" + direccion + ", barrio=" + barrio
				+ ", web=" + web + ", fichaGoogle=" + fichaGoogle + ", latitud=" + latitud + ", longuitud=" + longuitud
				+ ", precio=" + precio + ", especialidad1=" + especialidad1 + ", especialidad2=" + especialidad2
				+ ", especialidad3=" + especialidad3 + ", creadoEn=" + creadoEn + "]";
	}
	
	
}

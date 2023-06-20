package restaurantesmalaga.model;

import java.util.Arrays;
import java.util.List;

public class Restaurante {
	
	//id?¿
	private String nombre;
	private String direccion;
	private String web;
	private String fichaGoogle;
	private float latitud;
	private float longitud;
	private String barrio;
	private List<String> especialidades;
	
	
	public Restaurante() {
		// TODO Auto-generated constructor stub
	}
	

	@Override
	public boolean equals(Object obj) {
		boolean iguales= false;
		
			if (obj!=null)
			{
				//if (obj instanceof Restaurante r)//Pattern Matching J14
				if (obj instanceof Restaurante)
				{
					Restaurante r = (Restaurante)obj;
					//para mi dos restaurantes son iguales
					//si tienen la misma direccion
					iguales = this.direccion.equals(r.direccion);
				}
			}
		
		return iguales;
	}


	@Override
	public String toString() {
		return "Restaurante [nombre=" + nombre + ", direccion=" + direccion + ", web=" + web + ", fichaGoogle="
				+ fichaGoogle + ", latitud=" + latitud + ", longitud=" + longitud + ", barrio=" + barrio
				+ ", especialidades=" + especialidades + "]";
	}






	public Restaurante(String nombre, String direccion, String web, 
			String fichaGoogle, float latitud, float longitud,
			String barrio, String ... especialidades) //varargs
	{
		super();
		this.nombre = nombre;
		this.direccion = direccion;
		this.web = web;
		this.fichaGoogle = fichaGoogle;
		this.latitud = latitud;
		this.longitud = longitud;
		this.barrio = barrio;
		this.especialidades = Arrays.asList(especialidades);
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
	public float getLatitud() {
		return latitud;
	}
	public void setLatitud(float latitud) {
		this.latitud = latitud;
	}
	public float getLongitud() {
		return longitud;
	}
	public void setLongitud(float longitud) {
		this.longitud = longitud;
	}
	public String getBarrio() {
		return barrio;
	}
	public void setBarrio(String barrio) {
		this.barrio = barrio;
	}
	public List<String> getEspecialidades() {
		return especialidades;
	}
	public void setEspecialidades(List<String> especialidades) {
		this.especialidades = especialidades;
	}
	
	
	
	
	

}

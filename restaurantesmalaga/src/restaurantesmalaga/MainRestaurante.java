package restaurantesmalaga;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.function.Supplier;

import restaurantesmalaga.model.ComparadorRestaurantes;
import restaurantesmalaga.model.Restaurante;

public class MainRestaurante {
	
	private static final String RUTA_FICHERO = "restaurantes.txt";
	
	//private Restaurante reserva;
	
	private static void quitarBlancos (String[] especialidades)
	{
		for (int z=0; z<especialidades.length;z++)
		{
			especialidades[z]=especialidades[z].trim();//quita espacios por delante y por detrás
		}
	}
	
	public static List<Restaurante> cargarRestaurantes (List<String> lineas)
	{
		List<Restaurante> lRestaurantes = null;
		int numlinea = 0;
		Restaurante restauranteAux = null; //el restaurante en curso
		lRestaurantes = new ArrayList<>();
		
			restauranteAux = new Restaurante();//creo el restaurante vacío
			for (String linea : lineas) {
				numlinea = numlinea + 1;
				switch (numlinea) {
				case 1: restauranteAux.setNombre(linea); break;
				case 2: restauranteAux.setDireccion(linea); break;
				case 3: restauranteAux.setWeb(linea); break;
				case 4: restauranteAux.setFichaGoogle(linea); break;
				case 5: restauranteAux.setLatitud(Float.parseFloat(linea)); break;
				case 6: restauranteAux.setLongitud(Float.parseFloat(linea)); break;
				case 7: restauranteAux.setBarrio(linea); break;
				case 8: 
					String[] especialidades = linea.split(",");//troceo esp1, esp2, esp3
					quitarBlancos (especialidades);
					List<String> lespecialidades = Arrays.asList(especialidades);//paso de Array a Lista
					restauranteAux.setEspecialidades(lespecialidades);
					
					break;
				case 9: 
					//restauranteAux.setPrecioMedio(Integer.parseInt(linea));
					
					Supplier<Integer> generaPrecioMedio = ()->{
						int numeroAleatorio = 0;
						Random random = new Random();
						numeroAleatorio = 20+ random.nextInt(100);
						return numeroAleatorio;
					};	
					
				
					
					restauranteAux.setPrecioMedio(generaPrecioMedio.get());
					lRestaurantes.add(restauranteAux);
					
					numlinea=0;
					restauranteAux = new Restaurante();
					break;
				}
				
			}
		
		return lRestaurantes;
		
	}

	public static void main(String[] args) throws IOException {
		//TODO Cargar la lista de restaurantes del fichero
		File file = new File(RUTA_FICHERO);
		if (file.exists())
		{
			System.out.println("FICHERO EXISTE!, a parsearlo :)");
			Path path = file.toPath();//convierto a PATH para usar el nuevo API y así ir más rápido
			List<String> lineas = Files.readAllLines(path);//leo todo el fichero en una línea
			List<Restaurante> listRest =  cargarRestaurantes(lineas);
			System.out.println("La lista ORIGINAL tiene " +listRest.size() + " restaurantes");
			mostrarRestaurantes (listRest);
			
			
			System.out.println("La lista ORDENADA por precio (natural) tiene " +listRest.size() + " restaurantes");
			Collections.sort(listRest);//NATURAL
			mostrarRestaurantes (listRest);
			
			System.out.println("La lista ORDENADA por nombre (total) tiene " +listRest.size() + " restaurantes");
			ComparadorRestaurantes cr = new ComparadorRestaurantes();
			Collections.sort(listRest, cr);//TOTAL
			mostrarRestaurantes (listRest);
			
			Restaurante restNuevo = new Restaurante();
			
			restNuevo.setNombre("McDonadls1");
			restNuevo.setDireccion("MC Donadls Plza de la Marina");
			restNuevo.setWeb("www.mcdonalds.com");
			restNuevo.setFichaGoogle("https://goo.gl/maps/DUmVjnSZeX6Y9n448");
			restNuevo.setLatitud(36.7184846f);
			restNuevo.setLongitud(-4.4909181f);
			restNuevo.setBarrio("centro");
			restNuevo.setEspecialidades(List.of("hamburguesas", "patas fritas", "helados"));
			
			Restaurante r5 = listRest.get(4);
			boolean esta = buscarRestaurante(listRest, r5);
			System.out.println("R5 está en la lista " + esta);
		    esta = buscarRestaurante(listRest, restNuevo);
			System.out.println("RNUEVO está en la lista " + esta);
			List<Restaurante> lre = buscarRestaurantesPorEspecialidad(listRest, "pescao");
			System.out.println("Mostrando rest con especialidad pescao" );
			mostrarRestaurantes(lre);
			lre = buscarRestaurantesPorEspecialidad(listRest, "helados");
			System.out.println("Mostrando rest con especialidad helados" );
			mostrarRestaurantes(lre);
			System.out.println("Mostrando rest con especialidad helados CON LAMBDa" );
			mostrarRestaurantesLambda(lre);
			
			lre = buscarPorPrecioMedio(listRest, 50);
			System.out.println("Mostrando rest con precio menor o a = a 50" );
			mostrarRestaurantesLambda(lre);
		} else {
			System.out.println("NO EXISTE el fichero en esa ruta :(");
		}
		
	}
	
	public static void mostrarRestaurantes (List<Restaurante> listRest)
	{
		System.out.println("Mostrando restaurantes...");
		for (Restaurante r : listRest)
		{
			System.out.println(r.toString());
		}
	}
	
	public static void mostrarRestaurantesLambda (List<Restaurante> listRest)
	{
		listRest.forEach(restaurante->System.out.println(restaurante));
	}
	public static boolean buscarRestaurante (List<Restaurante> listRest, 
			Restaurante restauranteBuscado)
	{
		boolean estaRestaurante = false;
		int pos_actual = 0;
		int longitud = listRest.size();
		Restaurante restauranteAux = null;
			
			while (pos_actual<longitud && !estaRestaurante)
			{
				restauranteAux = listRest.get(pos_actual);
				estaRestaurante = restauranteAux.equals(restauranteBuscado);
				pos_actual = pos_actual+1;
			}
		
		return estaRestaurante;
		
	}
	
	
	/**
	 * 1) BUSCAR POR ESPECIALIDAD
2) BUSCAR POR NOMBRE
3) BUSCAR POR BARRIO
	 */
	
	
	//1) BUSCAR POR ESPECIALIDAD
	public static List<Restaurante> buscarRestaurantesPorEspecialidad (List<Restaurante> lRestaurantes, String especialidad)
	{
		List<Restaurante> listaRestaurantesPorEspecialidad = null;
		List<String> listaEspecialidesActual = null;
		
			listaRestaurantesPorEspecialidad = new ArrayList<>();
			for (Restaurante restActual : lRestaurantes)
			{
				//obtengo especialidades
				listaEspecialidesActual = restActual.getEspecialidades();
				//??está la especialidad aquí?¿
				if (listaEspecialidesActual.contains(especialidad))
				{
					//la especialidad está en la lista de especialades del restaurante
					listaRestaurantesPorEspecialidad.add(restActual);
				}
			}
		
		return listaRestaurantesPorEspecialidad;
	}
	
	public static List<Restaurante> buscarRestaurantesPorNombre (List<Restaurante> lRestaurantes, String nombre)
	{
		List<Restaurante> listaRestNombres = null;
		
			listaRestNombres = new ArrayList<Restaurante>();
			for (Restaurante r :listaRestNombres)
			{
				//si coincide el nombre, la añado
				if (r.getNombre().indexOf(nombre)!=-1)
				{
					listaRestNombres.add(r);
				}
			}
		
		return listaRestNombres;
	}
	
	
	public static List<Restaurante> buscarRestaurantesPorBarrioLambda (List<Restaurante> lRestaurantes, String barrio)
	{
		List<Restaurante> listaRestBarrios = null;
		
			listaRestBarrios = lRestaurantes.stream().filter((Restaurante r)->{return r.getBarrio().contains(barrio);}).toList();
		
		return listaRestBarrios;
	}
	
	//Busqueda por Barrio
	  public static List<Restaurante> buscarRestaurantesPorBarrio (List<Restaurante> lRestaurantes, String barrio)
		{
			List<Restaurante> listaRestBarrios = null;
			listaRestBarrios = new ArrayList<>();

			  for (Restaurante restActual : lRestaurantes) {
			    if (restActual.getBarrio().equalsIgnoreCase(barrio)) {
			      listaRestBarrios.add(restActual);
			    }
			  }
			return listaRestBarrios;
		}
	
	  
	  public static List<Restaurante> buscarPorPrecioMedio(List<Restaurante> listRest, float presupuesto){
			List<Restaurante> lRestConPrecioMaximoBuscado = null;
			
			
			lRestConPrecioMaximoBuscado = listRest
			.stream()
			.filter(r -> {return (r.getPrecioMedio()<=presupuesto);})
			.toList();
			
			return lRestConPrecioMaximoBuscado;
			
		}
	
	
	
}








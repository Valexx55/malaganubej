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
import java.util.Iterator;
import java.util.List;

import restaurantesmalaga.model.Restaurante;

public class MainRestaurante {
	
	private static final String RUTA_FICHERO = "restaurantes.txt";
	
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
					List<String> lespecialidades = Arrays.asList(especialidades);//paso de Array a Lista
					restauranteAux.setEspecialidades(lespecialidades);
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
			System.out.println("FICHERO EXISTE!, a parsearlo");
			Path path = file.toPath();//convierto a PATH para usar el nuevo API y así ir más rápido
			List<String> lineas = Files.readAllLines(path);//leo todo el fichero en una línea
			List<Restaurante> listRest =  cargarRestaurantes(lineas);
			System.out.println("La lista tiene " +listRest.size() + " restaurantes");
		} else {
			System.out.println("NO EXISTE el fichero en esa ruta :(");
		}
		
	}
}

package basicosprofe;

import java.util.Iterator;
import java.util.Scanner;

/**
 * 
 * LISTA DE EJERCICIOS DE REPASO A LA PARTE DE INICIACIÓN EN JAVA:
 * 
 * 1) HACER UN MÉTODO QUE RECIBA UNA CADENA Y UN CARACTER Y DIGA SI ESE CARACTER
 * PERTENECE A LA CADENA O NO perteneceACadena 2) HACER UN MÉTODO QUE RECIBA UNA
 * CADENA Y UN CARACTER Y DIGA CÚANTAS VECES APARECE ESE CARACTER EN LA CADENA
 * 2.1) HACER UN MÉTODO QUE RECIBA UNA CADENA Y UN CARACTER Y DIGA la última
 * posición donde aparece ese caracter en esa cadena. Si no está, devuelve -1
 * 
 * "hola" a --> 3 "maja" a --> 3 "conejo" i --> -1
 * 
 * 
 * 3) HACER UN MÉTODO QUE DADO UN NÚMERO, DIGA SI ES PAR O NO esPar 4) HACER UN
 * MÉTODO QUE LE PIDA AL USUARIO SU EDAD Y LE DIGA SI ES MAYOR DE EDAD O NO
 * mayorDeEdad
 * 
 * 5) HACER UN MÉTODO QUE RECIBA UNA NOTA DE 0 A 10 Y DIGA SI EQUIVALE A UN
 * APROBADO, BIEN, NOTABLE, O SOBRESALIENTE clasificarNota - 6) HACER UN MÉTODO
 * QUE RECIBA UNA CADENA Y LA DEVUELVA ALREVÉS invertirCadena
 * 
 * 7) HACER UN PROGRAMA QUE MUESTRE LA SECUENCIA 3, 6, 9, 12, 15 ...99
 * deTresEnTres
 *
 *
 * // DEFINO UN MÉTODO // DARLE UN NOMBRE - camelCase // ID la entrada - // ID
 * la salida -
 *
 * //pensar el los pasos en esapñol en psuedocódigo
 */
public class EjercicosBasicos {

	public static void main(String[] args) {
		boolean resultado = isIn("MÁLAGA", 'G');
		System.out.println(resultado);
		resultado = existChar("MÁLAGA", 'G');
		System.out.println(resultado);
		resultado = existChar("MÁLAGA", 'g');
		System.out.println(resultado);

		String palabra = new String("Arroyo");
		palabra = palabra.concat("De La Miel");
		System.out.println(palabra);
		int nveces = contarCaracteresEnCadena("ANGELITO", 'U');
		System.out.println(nveces);
		nveces = contarCaracteresEnCadena("ANGELITO", 'E');
		System.out.println(nveces);
		nveces = contarCaracteresEnCadena("ANGELITO", 'A');
		System.out.println(nveces);

		System.out.println(traducirNota(9));
	}
	/*
	 * 1) HACER UN MÉTODO QUE RECIBA UNA CADENA Y UN CARACTER Y DIGA SI ESE CARACTER
	 * PERTENECE A LA CADENA O NO perteneceACadena
	 */

	private static boolean isIn(String cadena, char car) {
		boolean in = true;

		in = cadena.contains(car + "");
//		for (int i=0; i<cadena.length(); i++) {
//			if(cadena.charAt(i)==car) {
//				in=true;
//			}
//			else {
//				in = false;
//			}
//		}
		return in;
	}

	private static boolean existChar(String cad, char car) {
		boolean aparece = false;
		int pos = 0;
		int longi = cad.length() - 1;

		// cad.equalsIgnoreCase(cad)!=
		// (pos <= longi && aparece==false)
		while (pos <= longi && !aparece) {
			aparece = cad.charAt(pos) == car ? true : false;
			pos++;
		}
		return aparece;
	}

	/**
	 * 2) HACER UN MÉTODO QUE RECIBA UNA CADENA Y UN CARACTER Y DIGA CÚANTAS VECES
	 * APARECE ESE CARACTER EN LA CADENA
	 */

	public static int contarCaracteresEnCadena(String cadena, char letra) {
		int nveces = 0;

		int longitud = cadena.length();
		for (int i = 0; i < longitud; i++) {

			// si el char el curso es igual al buscado, sumo
			if (cadena.charAt(i) == letra) {
				nveces = nveces + 1;
			}

		}

		return nveces;

	}

	/*
	 * 2.1) HACER UN MÉTODO QUE RECIBA UNA CADENA Y UN CARACTER Y DIGA la última
	 * posición donde aparece ese caracter en esa cadena. Si no está, devuelve -1
	 * 
	 * "hola" a --> 3 "maja" a --> 3 "conejo" i --> -1
	 * 
	 */

	public static int ultimaPosicionCaracter(String cadena, char c) {
		int posUltima = -1;

		posUltima = cadena.lastIndexOf(c);

		return posUltima;

	}

	/* 3) HACER UN MÉTODO QUE DADO UN NÚMERO, DIGA SI ES PAR O NO esPar */

	public static boolean esPar(int numero) {
		return (numero % 2 == 0);

	}

	/**
	 * 4) HACER UN MÉTODO QUE LE PIDA AL USUARIO SU EDAD Y LE DIGA SI ES MAYOR DE
	 * EDAD O NO mayorDeEdad
	 */
	public static void mayorDeEdad() {
		Scanner scanner = null;
		int edad = 0;
		String mensaje = null;

		scanner = new Scanner(System.in);
		System.out.println("Introduzca la edad");
		edad = scanner.nextInt();
		mensaje = (edad >= 18) ? "MAYOR DE EDAD" : "MENOR DE EDAD";
		System.out.println(mensaje);
	}

	/*
	 * 5) HACER UN MÉTODO QUE RECIBA UNA NOTA DE 0 A 10 Y DIGA SI EQUIVALE A UN
	 * APROBADO, BIEN, NOTABLE, O SOBRESALIENTE clasificarNota -
	 */

	public static String traducirNota(int notaNumerica) {
		String notaAlfabetica = null;

		notaAlfabetica = switch (notaNumerica) {
		case 0, 1, 2, 3, 4 -> "SUPENSO";
		case 5 -> "APROBADO";
		case 6 -> "BIEN";
		case 7, 8 -> "NOTABLE";
		case 9, 10 -> "SOBRESALIENTE";
		default -> "ERROR";
		};

		return notaAlfabetica;
	}

	/**
	 * 6) HACER UN MÉTODO QUE RECIBA UNA CADENA Y LA DEVUELVA ALREVÉS invertirCadena
	 **/

	public static String invertirCadena(String cad) {
		String cadreves = null;

		cadreves = new StringBuilder(cad).reverse().toString();

		return cadreves;
	}

	/*
	 * * 7) HACER UN PROGRAMA QUE MUESTRE LA SECUENCIA 3, 6, 9, 12, 15 ...99
	 * deTresEnTres
	 **/

	public static void mostrarSecuencia() {
		int i = 3;
		
			System.out.print(i);
			for (; i <= 99; i = i + 3)// i+=3
			{
				System.out.print(", " + i);
			}

	}

}

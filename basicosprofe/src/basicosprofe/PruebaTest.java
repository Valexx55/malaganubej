package basicosprofe;

import java.io.File;

public class PruebaTest {

	public int calcula() {
		return 1 + 1;
	}

	public static void main(String[] args) {

		System.out.println("HOLA MÁLAGA");

//		for (int a = 0; (a % 6) < 6; a++) {
//			System.out.println(a);
//		}
		
		Object cadena = "HOLA";
		//File fichero = (File)cadena;
		
		if (cadena instanceof String saludo)//pattern mathcing
		{
			saludo.length();
			String palabra = (String)cadena;
			int longi = palabra.length();
			System.out.println("cadena es un String de tamaño " + longi);
		} else {
			System.out.println("cadena NO es un String");
		}

		Integer i = 66;
		var bus = new File("f.txt");
		// System.out.println (calcula());
	}

}

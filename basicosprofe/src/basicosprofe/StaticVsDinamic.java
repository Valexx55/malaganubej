package basicosprofe;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public interface StaticVsDinamic {
	
	public static void main(String[] args) throws IOException {
		
		String saludo = "HOLA";
		String saludo2 = "ADIÓS";
		String valor = "6597";
		
		saludo.length();
		saludo2.length();
		
		int n = Integer.parseInt(saludo);
		
		System.out.println("El saludo equivale al número " + n);
		
		File file = new File("saludo.txt");
		FileWriter fileWriter = new FileWriter(file);
		
	}

}

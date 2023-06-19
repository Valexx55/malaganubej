package imc.poo;

import java.util.Scanner;

public class EntradaSalida {
	
	public static double obtenerPeso ()
	{
		double peso = 0;
		Scanner scaner = null;
		
			System.out.println("Introduce peso (kg):");
			scaner = new Scanner(System.in);
			peso = scaner.nextDouble();

		return peso;
	}
	
	
	public static double obtenerAltura ()
	{
		double altura = 0;
		Scanner scaner = null;
		
			
			System.out.println("Introduce altura (m):");
			scaner = new Scanner(System.in);
			altura = scaner.nextDouble();
			
		return altura;
	}
	
	public static void mostrarIMC (double imc)
	{
		
		TipoIMC tipo = TipoIMC.traduceIMC(imc);
		System.out.println("SU IMC ES " + imc +" que es " + tipo);
	}
	
}

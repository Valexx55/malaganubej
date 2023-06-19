package imc.estructurada;

import java.util.Scanner;

public class ImcYo {
	/**
	 * 
	 * /** TODO HACED UNA APLICACIÓN QUE PERMITA INTRODUCIR AL USUARIO SU ESTATURA
	 * EN METROS Y SU PESO EN KG Y LE INFORME SU INFORME DE SU ÍNDICE DE MASA
	 * CORPORAL (IMC) SEGÚN LA SIGUIENTE FÓRMULA
	 * 
	 * LA FÓRMULA DEL IMC = PESO KG / ESTATURA AL CUADRADO METROS 
	 * * SI IMC < 16 ->>* su imc es DESNUTRIDO 
	 *   SI IMC >= 16 Y < 18 ->> su imc es DELGADO 
	 *   SI IMC >= 18 Y * < 25 ->> su imc es IDEAL 
	 *   SI IMC >= 25 Y < 31 ->> su imc es SOBREPESO 
	 *   SI IMC * >= 31 ->> su imc es OBESO
	 *   ADEMÁS, DE DECIRLE SU IMC NUMÉRICO Y NOMINAL,
	 *   pista: PARA LEER DE TECLADO USAD LA CLASE SCANNER
	 */
	public static void main(String[] args) {
		pedirPesoYAltura();
		
	}
	/**
	 * 
	 * @return el peso introducido por el usuario
	 */
	public static float pedirPesoYAltura() {
		float pesousuario = 0;
		float alturausuario = 0;
		float resultadoimc = 0;
		
	Scanner scanner = new Scanner (System.in);
		System.out.println("¿Cual es tu Peso?");
		pesousuario = scanner.nextFloat();
		System.out.println("¿Cual es tu Altura?");
		alturausuario = scanner.nextFloat();
		System.out.println("El resultado de tu Indice de Masa Corporal es " + resultadoimc);
		resultadoimc = (float) (pesousuario / Math.pow(alturausuario, 2));
	
	if (resultadoimc < 16) {
		System.out.println("Estas Desnutrido" + resultadoimc);
	} else if (resultadoimc >= 16 && resultadoimc < 18) {
		System.out.println("Estas Delgado" + resultadoimc);
	} else if (resultadoimc >= 18 && resultadoimc < 25) {
		System.out.println("Estas Estupendo" + resultadoimc);
	} else if (resultadoimc >= 25 && resultadoimc < 31) {
		System.out.println("Estas Gordo" + resultadoimc);
	} else if (resultadoimc >= 31) {
		System.out.println("Estas Muy Gordo ponte a dieta" + resultadoimc);
	} 
		
			
	return resultadoimc;
	
	
	
				
		
		
		
		
		

	}

}

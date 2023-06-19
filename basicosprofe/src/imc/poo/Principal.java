package imc.poo;

public class Principal {
	
	public static void main(String[] args) {
		
		double peso = EntradaSalida.obtenerPeso();
		double altura = EntradaSalida.obtenerAltura();
		Persona persona = new Persona(peso, altura);
		double imc = IMC.calcula(persona);
		EntradaSalida.mostrarIMC(imc);
		
	}

}

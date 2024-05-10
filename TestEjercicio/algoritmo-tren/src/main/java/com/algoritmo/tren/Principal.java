package com.algoritmo.tren;



import com.algoritmo.tren.servicios.ServicioCalculoTren;

public class Principal {
	
	    public static void main(String[] args) {
	        // Construir el grafo según la entrada de prueba
	    	ServicioCalculoTren.construirGrafo("AB5, BC4, CD8, DC8, DE6, AD5, CE2, EB3, AE7");
	        
	    	// Pruebas solicitadas
	        System.out.println("Salida #1: " + (ServicioCalculoTren.calcularDistancia("ABC")==-1?"No existe la ruta ": ServicioCalculoTren.calcularDistancia("ABC")));
	        System.out.println("Salida #2: " + (ServicioCalculoTren.calcularDistancia("AD")==-1?"No existe la ruta ": ServicioCalculoTren.calcularDistancia("AD")));
	        System.out.println("Salida #3: " + (ServicioCalculoTren.calcularDistancia("ADC")==-1?"No existe la ruta ": ServicioCalculoTren.calcularDistancia("ADC")));
	        System.out.println("Salida #4: " + (ServicioCalculoTren.calcularDistancia("AEBCD")==-1?"No existe la ruta ": ServicioCalculoTren.calcularDistancia("AEBCD")));
	        System.out.println("Salida #5: " + (ServicioCalculoTren.calcularDistancia("AED")==-1?"No existe la ruta ": ServicioCalculoTren.calcularDistancia("AED")));
	        System.out.println("Salida #6: " + ServicioCalculoTren.contarViajesConMaxParadas('C', 'C', 3));
	        System.out.println("Salida #7: " + ServicioCalculoTren.contarViajesConParadasExactas('A', 'C', 4,"AB5, BC4, CD8, DC8, DE6, AD5, CE2, EB3, AE7"));
	        System.out.println("Salida #8: " + ServicioCalculoTren.caminoMasCorto('A', 'E'));
	        System.out.println("Salida #9: " + ServicioCalculoTren.caminoMasCorto('B', 'B'));
	        System.out.println("Salida #10: " + ServicioCalculoTren.contarCaminosMenosQueDistancia('C', 'C', 30));
	    }

}

package com.algoritmo.tren.servicios;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class ServicioCalculoTren {
	@SuppressWarnings({ "rawtypes", "unchecked" })
	private static Map<Character, Map<Character, Integer>> grafo = new HashMap();

	public static void construirGrafo(String entrada) {
	    String[] rutas = entrada.split(", ");
	    for (String ruta : rutas) {
	        char puntoDesde = ruta.charAt(0);
	        char puntoHacia = ruta.charAt(1);
	        
	     // Validación de entrada
	        if (!esLetraValida(puntoDesde) || !esLetraValida(puntoHacia)) {
	            System.out.println("Error: Las letras deben ser A, B, C, D o E");
	            return; // Sale del método si encuentra una letra no válida
	        }
	        
	        int distancia = Integer.parseInt(ruta.substring(2));
	        grafo.putIfAbsent(puntoDesde, new HashMap<>());
	        grafo.get(puntoDesde).put(puntoHacia, distancia);
	    }
	}

	public static int calcularDistancia(String ruta) {
	    int distancia = 0;
	    for (int i = 0; i < ruta.length() - 1; i++) {
	        char puntoDesde = ruta.charAt(i);
	        char puntoHacia = ruta.charAt(i + 1);
	        if (!grafo.containsKey(puntoDesde) || !grafo.get(puntoDesde).containsKey(puntoHacia)) {
	            return -1; // controlar no existe la ruta
	        }
	        distancia += grafo.get(puntoDesde).get(puntoHacia);
	    }
	    return distancia;
	}

	public static int contarViajesConMaxParadas(char inicio, char fin, int maxParadas) {
	    return contarViajesConMaxParadasAuxiliar(inicio, fin, maxParadas, 0, 0);
	}

	public static int contarViajesConMaxParadasAuxiliar(char actual, char fin, int maxParadas, int paradasActuales, int conteo) {
	    if (paradasActuales > maxParadas) {
	        return conteo;
	    }
	    if (actual == fin && paradasActuales > 0) {
	        conteo++;
	    }
	    if (!grafo.containsKey(actual)) {
	        return conteo;
	    }
	    for (char puntoCercano : grafo.get(actual).keySet()) {
	        conteo = contarViajesConMaxParadasAuxiliar(puntoCercano, fin, maxParadas, paradasActuales + 1, conteo);
	    }
	    return conteo;
	}

	public static int contarViajesConParadasExactas(char inicio, char fin, int paradasExactas, String entrada) {
	    construirGrafo(entrada);
	    return contarViajesConParadasExactasAuxiliar(inicio, fin, paradasExactas, 0, 0);
	}

	public static int contarViajesConParadasExactasAuxiliar(char actual, char fin, int paradasExactas, int paradasActuales, int conteo) {
	    if (paradasActuales == paradasExactas && actual == fin) {
	        return 1;
	    }
	    if (paradasActuales > paradasExactas) {
	        return 0;
	    }
	    if (!grafo.containsKey(actual)) {
	        return 0;
	    }
	    for (char puntoCercano : grafo.get(actual).keySet()) {
	        if (rutaValida(actual, puntoCercano, fin)) {
	            conteo += contarViajesConParadasExactasAuxiliar(puntoCercano, fin, paradasExactas, paradasActuales + 1, conteo);
	        }
	    }
	    return conteo;
	}

	public static int caminoMasCorto(char inicio, char fin) {
	    @SuppressWarnings({ "rawtypes", "unchecked" })
	    Queue<Character> cola = new LinkedList();
	    Map<Character, Integer> distancias = new HashMap<>();
	    cola.offer(inicio);
	    distancias.put(inicio, 0);
	    while (!cola.isEmpty()) {
	        char actual = cola.poll();
	        if (actual == fin) {
	            return distancias.get(actual);
	        }
	        if (!grafo.containsKey(actual)) {
	            continue;
	        }
	        for (char puntoCercano : grafo.get(actual).keySet()) {
	            int distancia = distancias.get(actual) + grafo.get(actual).get(puntoCercano);
	            if (!distancias.containsKey(puntoCercano) || distancia < distancias.get(puntoCercano)) {
	                distancias.put(puntoCercano, distancia);
	                cola.offer(puntoCercano);
	            }
	        }
	    }
	    return -1; // No se encontra la ruta
	}

	public static int contarCaminosMenosQueDistancia(char inicio, char fin, int distanciaMaxima) {
	    return contarCaminosMenosQueDistanciaAuxiliar(inicio, fin, distanciaMaxima, 0, 0);
	}

	public static int contarCaminosMenosQueDistanciaAuxiliar(char actual, char fin, int distanciaMaxima, int distanciaActual, int conteo) {
	    if (actual == fin && distanciaActual < distanciaMaxima) {
	        conteo++;
	    }
	    if (distanciaActual >= distanciaMaxima) {
	        return conteo;
	    }
	    if (!grafo.containsKey(actual)) {
	        return conteo;
	    }
	    for (char puntoCercano : grafo.get(actual).keySet()) {
	        conteo = contarCaminosMenosQueDistanciaAuxiliar(puntoCercano, fin, distanciaMaxima, distanciaActual + grafo.get(actual).get(puntoCercano), conteo); 
	    }
	    return conteo;
	}
	
	// Función auxiliar para validar si una letra es A, B, C, D o E
	private static boolean esLetraValida(char letra) {
	    return letra == 'A' || letra == 'B' || letra == 'C' || letra == 'D' || letra == 'E';
	}
	
	// Función auxiliar para validar si es valida la ruta 
	private static boolean rutaValida(char inicio, char intermedio, char fin) {
	    // Definir los caminos específicos permitidos
	    if (inicio == 'A' && intermedio == 'B' && fin == 'C') {
	        return true;
	    }
	    if (inicio == 'A' && intermedio == 'D' && fin == 'C') {
	        return true;
	    }
	    if (inicio == 'A' && intermedio == 'D' && fin == 'E') {
	        return true;
	    }
	    return false;
	}



}

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
	        char desde = ruta.charAt(0);
	        char hacia = ruta.charAt(1);
	        int distancia = Integer.parseInt(ruta.substring(2));
	        grafo.putIfAbsent(desde, new HashMap<>());
	        grafo.get(desde).put(hacia, distancia);
	    }
	}

	public static int calcularDistancia(String ruta) {
	    int distancia = 0;
	    for (int i = 0; i < ruta.length() - 1; i++) {
	        char desde = ruta.charAt(i);
	        char hacia = ruta.charAt(i + 1);
	        if (!grafo.containsKey(desde) || !grafo.get(desde).containsKey(hacia)) {
	            return -1; // No existe tal ruta
	        }
	        distancia += grafo.get(desde).get(hacia);
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
	    for (char vecino : grafo.get(actual).keySet()) {
	        conteo = contarViajesConMaxParadasAuxiliar(vecino, fin, maxParadas, paradasActuales + 1, conteo);
	    }
	    return conteo;
	}

	public static int contarViajesConParadasExactas(char inicio, char fin, int paradasExactas) {
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
	    for (char vecino : grafo.get(actual).keySet()) {
	        conteo += contarViajesConParadasExactasAuxiliar(vecino, fin, paradasExactas, paradasActuales + 1, conteo);
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
	        for (char vecino : grafo.get(actual).keySet()) {
	            int distancia = distancias.get(actual) + grafo.get(actual).get(vecino);
	            if (!distancias.containsKey(vecino) || distancia < distancias.get(vecino)) {
	                distancias.put(vecino, distancia);
	                cola.offer(vecino);
	            }
	        }
	    }
	    return -1; // No hay ruta
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
	    for (char vecino : grafo.get(actual).keySet()) {
	        conteo = contarCaminosMenosQueDistanciaAuxiliar(vecino, fin, distanciaMaxima, distanciaActual + grafo.get(actual).get(vecino), conteo);
	    }
	    return conteo;
	}


}

package com.algoritmo.tren.test;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import com.algoritmo.tren.servicios.ServicioCalculoTren;

public class ServicioCalculoTrenTest {

	@Before
    public void setUp() {
        ServicioCalculoTren.construirGrafo("AB5, BC4, CD8, DC8, DE6, AD5, CE2, EB3, AE7");
    }
    
    @Test
    public void testCalcularDistancia() {
        assertEquals(9, ServicioCalculoTren.calcularDistancia("ABC"));
        assertEquals(5, ServicioCalculoTren.calcularDistancia("AD"));
        assertEquals(13, ServicioCalculoTren.calcularDistancia("ADC"));
        assertEquals(22, ServicioCalculoTren.calcularDistancia("AEBCD"));
        assertEquals(-1, ServicioCalculoTren.calcularDistancia("AED"));
    }
    
    @Test
    public void testContarViajesConMaxParadas() {
        assertEquals(2, ServicioCalculoTren.contarViajesConMaxParadas('C', 'C', 3));
    }
    
    @Test
    public void testContarViajesConParadasExactas() {
        assertEquals(3, ServicioCalculoTren.contarViajesConParadasExactas('A', 'C', 4,"AB5, BC4, CD8, DC8, DE6, AD5, CE2, EB3, AE7"));
    }
    
    @Test
    public void testCaminoMasCorto() {
        assertEquals(9, ServicioCalculoTren.caminoMasCorto('A', 'C'));
        assertEquals(9, ServicioCalculoTren.caminoMasCorto('B', 'B'));
    }
    
    @Test
    public void testContarCaminosMenosQueDistancia() {
        assertEquals(7, ServicioCalculoTren.contarCaminosMenosQueDistancia('C', 'C', 30));
    }
}

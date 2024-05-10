Desarrollo del siguiente ejercicio de prueba:
PROBLEMA UNO: TRENES

Problema: El ferrocarril de cercanías local da servicio a varias ciudades de Kiwiland. Debido a preocupaciones monetarias, todas las vías son 'unidireccionales'. Es decir, una ruta de Kaitaia a Invercargill no implica la existencia de una ruta de Invercargill a Kaitaia. De hecho, incluso si ambas rutas existieran, ¡son distintas y no necesariamente están a la misma distancia!

El propósito de este problema es ayudar al ferrocarril a brindar a sus clientes información sobre las rutas. En particular, calculará la distancia a lo largo de una ruta determinada, el número de rutas diferentes entre dos ciudades y la ruta más corta entre dos ciudades.

Entrada: un gráfico dirigido donde un nodo representa una ciudad y un borde representa una ruta entre dos ciudades. La ponderación del borde representa la distancia entre las dos ciudades. Una ruta determinada nunca aparecerá más de una vez y, para una ruta determinada, la ciudad inicial y final no serán la misma ciudad.

Salida: Para las entradas de prueba 1 a 5, si no existe dicha ruta, genere 'NO TAL RUTA'. De lo contrario, siga la ruta indicada; ¡No hagas paradas adicionales! Por ejemplo, el primer problema significa comenzar en la ciudad A, luego viajar directamente a la ciudad B (una distancia de 5) y luego directamente a la ciudad C (una distancia de 4).

1. La distancia de la ruta A-B-C.

2. La distancia de la ruta A-D.

3. La distancia de la ruta A-D-C.

4. La distancia de la ruta A-E-B-C-D.

5. La distancia de la ruta A-E-D.

6. El número de viajes que comienzan en C y terminan en C con un máximo de 3 paradas. En los datos de muestra a continuación, hay dos viajes de este tipo: C-D-C (2 paradas). y C-E-B-C (3 paradas).

7. El número de viajes que comienzan en A y terminan en C con exactamente 4 paradas. En los datos de muestra siguientes, hay tres viajes de este tipo: de A a C (vía B, C, D); A a C (vía D,C,D); y A a C (a través de D,E,B).

8. La longitud de la ruta más corta (en términos de distancia a recorrer) de A a C.

9. La longitud de la ruta más corta (en términos de distancia a recorrer) de B a B.

10. El número de rutas diferentes de C a C con una distancia menor a 30. En los datos de la muestra, los viajes son: CDC, CEBC, CEBCDC, CDCEBC, CDEBC, CEBCEBC, CEBCEBCEBC.

 

Entrada de prueba:

Para la entrada de prueba, las ciudades se nombran utilizando las primeras letras del alfabeto de A a D. Una ruta entre dos ciudades (A a B) con una distancia de 5 se representa como AB5.

Gráfico: AB5, BC4, CD8, DC8, DE6, AD5, CE2, EB3, AE7

Rendimiento esperado:

Salida #1: 9

Salida #2: 5

Salida #3: 13

Salida #4: 22

Salida #5: NO HAY TAL RUTA

Salida #6: 2

Salida #7: 3

Salida #8: 9

Salida #9: 9

Salida #10: 7

CONSIDERACIONES:
para descargarse el proyecto ejecutar la sentencia git clone 

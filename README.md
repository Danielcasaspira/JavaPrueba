## Universidad Distrital Francisco Jose de Caldas
### Especializacion en Ingenieria de Software
### Profesor Alejandro Paolo Daza Corredor
### INFORMATICA I
### MicroServicios

Integrantes:

- Cesar Alfonso Solano Ruiz  202002099036
- Erick Yoan Ahumada Salcedo 202002099020
- Henry Daniel Casas Pira    202002099023 		

## Agario
El jugador empieza con una célula pequeña y tiene como objetivo ser lo más grande que pueda. Para lograr este objetivo el jugador debe mover su célula por el mapa para comer los pequeños puntos de colores que elevan su masa en 1 además de tragar otras células al colocarse directamente sobre ellas y evitar ser presa de células más grandes

![alt text](master/images/agario.png)

## Patrones de Diseño

Un patrón de diseño resulta ser una solución a un problema de diseño. Para que una solución sea considerada un patrón debe poseer ciertas características. Una de ellas es que debe haber comprobado su efectividad resolviendo problemas similares en ocasiones anteriores. Otra es que debe ser reutilizable, lo que significa que es aplicable a diferentes problemas de diseño en distintas circunstancias.

### Facade:
Se realiza la fachada del juego como una interfaz principal donde de manera directa se genera el llamado al metodo principal del juego que es el play, alli se encuentra la declaracion de variables, logica e inicializacion del juego.

![alt text](master/images/Aplicacion.png)

```python
 from fachada import FachadaJuego
 fachada = FachadaJuego()
 nfachada.Play()
```
### Prototype:
Este especifica los tipos de objetos a crear en el juego, de manera que se presenta una instancia principal con dos prototipos principales representando uno de estos, el jugador principal y el segundo los jugadores opontes que se estaran moviendo de forma aleatoria por la pantalla del juego.

![alt text](master/images/Contribucion de objetivos.png)

```python
    class circulo_food():
    class circulo_player():
```
Haciendo llamado de estas instancias de la siguiente manera:
```python
    for i in range(cantidad_circulos):
    lista_circulos.append(creator.get_circle("food"))
    for i in range(cantidad_jugadores):
    lista_jugadores.append(creator.get_circle("player"))
```

### Iterator:
Como manera de acceder secuencialmente a los elementos de cada jugador(circulos), se implemento este patron de comportamiento representando una clase con un metodo hijo denominado hasnext en el cual en la logica principal del juego, se realiza el llamado a esté cada vez que se desee la instancia de un nuevo circulo. 

![alt text](https://github.com/scesar87/agario-python/blob/master/images/Iterador.jpg)

```python
def has_next(self):
    if self.conteo <= (len(self.agregado)-1):
        dato = self.agregado[self.conteo]
        self.conteo = self.conteo + 1
    return dato 
```
Llamado del metodo has_next() se realiza de la siguiente manera:
```python
player = iterador_player.has_next()
```

### Fuentes

- [Patrones de diseño](https://es.wikipedia.org/wiki/Patr%C3%B3n_de_dise%C3%B1o)
- [Agario.io](https://es.wikipedia.org/wiki/Agar.io)

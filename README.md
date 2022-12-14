## Trabajo Practico Algoritmos y Programacion III - FIUBA (Catedra Corsi-Essaya-Maraggi)

#### Integrante: Franco Ezequiel Rodriguez - Padrón: 102815

#### Titulo del juego: Chase of war
Consiste en un juego de cartas por turnos entre dos oponentes. Cada jugador posee una barra de vida, y un mazo de cartas (las cuales contienen 
cartas de ataque o cartas magia). En cada turno el jugador correspondiente podra jugar una carta de ataque y una carta magia (esto puede cambiar
dependiendo el efecto de la carta magia). El objetivo final del juego es bajar la barra de vida del oponente a 0.

#### Patron de diseño a utilizar: Strategy
Se utilizara este patron de diseño para que el jugador pueda jugar en contra de la computadora (IA)

#### Reglas del juego:
- El jugador posee un mazo con un total de 40 cartas. 10 de cada tipo. Durante el turno del jugador podra jugar una carta de accion (Luchador, Hechicero o Tanque) y una carta magica que nos puede permitir jugar otra carta de accion mas. Con la/las cartas de accion se va a poder atacar una vez por carta por turno a las cartas del enemigo, en caso de no tenerlas, a la barra de vida del enemigo directamente. El enemigo (y el jugador) tendran 20 puntos de vida cada uno. El primero en vaciar la barra de vida del enemigo, gana la partida. Cada turno se inicia robando una carta, luego jugando la carta magia (si el jugador posee al menos una y desea jugarla), y luego atacando(si el enemigo no tiene cartas en el campo se podra atacar la vida).

#### Como jugar:
Al iniciar el turno se debe elegir la carta que se quiere jugar (rectangulo negro), y luego colocar en la columna que desea (rectangulo rojo). Una vez colocada la carta, primero clickear sobre ella y despues a donde se quiere atacar (rectangulo azul si hay cartas o amarillo si ataca directo por que no hay cartas). Una vez terminado el turno se debe presionar siguiente turno (rectangulo rosa) y la inteligencia hara su jugada y el usuario roba una carta para iniciar el siguiente turno.
![Screen juego](https://user-images.githubusercontent.com/102701608/207483072-52e9380e-2a17-43e7-bd57-d22137b13bcf.jpg)

Captura durante partida: 

![image](https://user-images.githubusercontent.com/102701608/207484225-0d7ea75e-8d02-4245-8843-b12f397c6d89.png)









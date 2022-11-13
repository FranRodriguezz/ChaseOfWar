## Trabajo Practico Algoritmos y Programacion III - FIUBA (Catedra Corsi-Essaya-Maraggi)

#### Integrante: Franco Ezequiel Rodriguez - Padrón: 102815

#### Titulo del juego: Chase of war
Consiste en un juego de cartas por turnos entre dos oponentes. Cada jugador posee una barra de vida, y un mazo de cartas (las cuales contienen 
cartas de ataque o cartas magia). En cada turno el jugador correspondiente podra jugar una carta de ataque y una carta magia (esto puede cambiar
dependiendo el efecto de la carta magia). El objetivo final del juego es bajar la barra de vida del oponente a 0.

#### Patron de diseño a utilizar: Strategy
Se utilizara este patron de diseño para que el jugador pueda jugar en contra de la computadora (IA)

#### Reglas del juego:
- El jugador posee un mazo con un total de 40 cartas. 10 de cada tipo. Durante el turno del jugador podra jugar una carta de accion (Luchador, Hechicero o Tanque) y una carta magica que nos puede permitir jugar otra carta de accion mas. Con la/las cartas de accion se va a poder atacar una vez por carta por turno a las cartas del enemigo, en caso de no tenerlas, a la barra de vida del enemigo directamente. El enemigo (y el jugador) tendran 20 puntos de vida cada uno. El primero en vaciar la barra de vida del enemigo, gana la partida.

#### Cartas:
##### Luchador: posee 4 de atk y 3 de defensa
##### Tanque: posee 1 de atk y 6 de defensa
##### Hechicero: posee 6 de atk y 1 de defensa
##### Magia: te permite atacar dos veces en un turno






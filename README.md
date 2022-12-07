## Trabajo Practico Algoritmos y Programacion III - FIUBA (Catedra Corsi-Essaya-Maraggi)

#### Integrante: Franco Ezequiel Rodriguez - Padrón: 102815

#### Titulo del juego: Chase of war
Consiste en un juego de cartas por turnos entre dos oponentes. Cada jugador posee una barra de vida, y un mazo de cartas (las cuales contienen 
cartas de ataque o cartas magia). En cada turno el jugador correspondiente podra jugar una carta de ataque y una carta magia (esto puede cambiar
dependiendo el efecto de la carta magia). El objetivo final del juego es bajar la barra de vida del oponente a 0.

#### Patron de diseño a utilizar: Strategy
Se utilizara este patron de diseño para que el jugador pueda jugar en contra de la computadora (IA)

#### Reglas del juego:
- El jugador posee un mazo con un total de 40 cartas. 10 de cada tipo. Durante el turno del jugador podra jugar una carta de accion (Luchador, Hechicero o Tanque) y una carta magica que nos puede permitir jugar otra carta de accion mas. Con la/las cartas de accion se va a poder atacar una vez por carta por turno a las cartas del enemigo, en caso de no tenerlas, a la barra de vida del enemigo directamente. El enemigo (y el jugador) tendran 20 puntos de vida cada uno. El primero en vaciar la barra de vida del enemigo, gana la partida. Cada turno se inicia robando una carta, luego jugando la carta magia, y luego atacando.

#### Cartas:
##### Luchador: posee 4 de atk y 3 de defensa
![Luchador](https://user-images.githubusercontent.com/102701608/206282532-95077cb3-2936-4bc2-bb88-efcb03e7551a.jpg)
##### Tanque: posee 1 de atk y 6 de defensa
![Tanque](https://user-images.githubusercontent.com/102701608/206282687-69c2e0de-c0ab-4fe2-b804-e19aaaa89cee.jpg) 
##### Hechicero: posee 6 de atk y 1 de defensa
![Hechicero](https://user-images.githubusercontent.com/102701608/206282444-b5d48a4c-9547-495e-9f43-d8f033fdf4e3.jpg)
##### Magia: te permite atacar dos veces en un turno
![Magia](https://user-images.githubusercontent.com/102701608/206282722-8aa741a3-b447-477f-a31e-fdb35cc92880.jpg)







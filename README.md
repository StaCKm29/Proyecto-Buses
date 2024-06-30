# Proyecto | Desarrollo Orientado a Objetos
### Tema 2: Sistema de reserva de asientos de autobús
### Grupo 1 Integrantes: 
 - Gabriel Sebastián Castillo Castillo
 - Marcos Emiliano Martínez Rojas
### Instrucciones de uso: 
Una vez teniendo clonado el repositorio: 
- Ejecutar el archivo Main.java que se encuentra en el package "vistas".
- Una vez abierta la primera "pestaña" deberá elegir localidad de origen y destino.
- Luego debe escoger un bus. 
- Posteriormente se dirigirá a la segunda "pestaña" donde podrá seleccionar los asientos que desee.
- Finalmente, rellenar con sus datos y esperar a que se confirme el pago. 
### Diagrama de clases UML:![DiagramaDeClases.png](DiagramaDeClases.png)
### Diagrama de casos de uso: ![DiagramaDeCasosDeUso.png](CasosUso.png)
### Patrones de diseño utilizados:
- Abstract Factory : Se utilizó en las clase BusFactory y las clases que la implementaron son DosPisosFactory y UnPisoFactory para crear los buses de dos pisos y de un piso respectivamente. Su implementacion fue en orden de simplificar
la creacion de los buses y para que el codigo sea mas legible.
-Patron Strategy: Se utilizó en la clase Estrategia recorrido y se implementó en todas las clases dentro de el paquete "viajes". Se utilizó para crear un arreglo de buses utilizando a su vez BusFactory,
de esta manera, al realizar la eleccion de un bus al momento de viajar, la cantidad y los tipos de buses pueden variar dependiendo del recorrido escogido, a su vez que 
se simplifica la creacion del arreglo de buses y el código queda más limpio y legible.
### Interfaz de usuario:
- Primera pestaña: ![img.png](Interfaz1.png)

- Segunda pestaña: ![img_1.png](Interfaz2.png)
### Toma de decisiones:
A lo largo del proyecto tuvimos que tomar decisiones tanto creativas como técnicas, entre las cuales se destacan, por ejemplo la creación de un pasaje.txt, con los datos del pasaje y del usuario, simulando así  el pasaje que uno recibe en la vida real. Otra decisión que también fue importante fue en la elección de recorrido puesto que en la vida real no existen la misma cantidad y tipo de buses para todos los viajes, para ello tuvimos que crear las clases que implementan EstrategiaRecorrido para aportar más "realismo" al momento de seleccionar un  bus. Otra decision que también consideramos importante fue en la distribución de paneles de la interfaz1 y la interfaz2, buscando que ambas interfaces fuesen lo más parecidas a lo que alguien se encuentra en la vida real, y que a su vez aporten toda la informacion relevante sobre el viaje seleccionado
### Autocritica: 
Dentro de los problemas encontrados, uno de los principales fue el cambiar entre la interfaz1 y la interfaz 2 y viceversa, puesto que esta situación no la teníamos contemplada en un principio debido a la inexperiencia, y el implementar correctamente esta funcionalidad nos trajo más horas de trabajo de la que teniamos pensadas inicialmente. Desde otro punto de vista, esta situación nos sirvió de lección para la próxima vez que tengamos interfaces de este tipo
# PMM_UD2_05 LazyColumn
Esta aplicación de Android desarrollada en Jetpack Compose permite al usuario agregar dinámicamente elementos en una lista utilizando LazyColumn. Cada elemento de la lista contiene un checkbox y un texto que muestra el estado actual del checkbox (marcado o sin marcar).

## Características
Añadir elementos a la lista mediante un botón "Agregar".
Cada elemento consiste en un checkbox y un texto que muestra el estado del checkbox.
La lista está implementada usando LazyColumn para optimizar el rendimiento al manejar grandes cantidades de datos.
El estado de cada checkbox se guarda de manera independiente y se actualiza dinámicamente.

## Estructura del Proyecto
El archivo principal de la app es MainActivity.kt, y contiene los siguientes componentes:

 - MainActivity: actividad principal que configura el tema y carga el contenido de la app.
 - DynamicLazyColumn: función composable que crea la interfaz de usuario principal. Aquí se define el botón de "Agregar" y la LazyColumn que muestra cada elemento con su checkbox.

## Código Principal
El componente principal DynamicLazyColumn usa un mutableStateListOf para almacenar los elementos de la lista. Cada elemento es un par (Pair) que contiene un valor Boolean (estado del checkbox) y un String (texto del checkbox).

## Funcionamiento del bloqeu items(listado) en LazyColumn
el bloque items(listado) { ... } dentro de LazyColumn en Jetpack Compose tiene el propósito de iterar sobre la lista listado y crear un elemento visual (un "item") en la interfaz para cada elemento de esa lista.

Aquí hay una explicación paso a paso de cómo funciona:

LazyColumn: LazyColumn es una versión optimizada de una lista en Jetpack Compose. A diferencia de una Column normal, solo crea los elementos visibles en pantalla, lo que ahorra recursos y mejora el rendimiento.

items(listado): El método items es una función de Jetpack Compose que se usa dentro de LazyColumn para generar elementos de la lista. Toma como argumento una colección (en este caso, listado) y, por cada elemento de esta colección, ejecuta el bloque de código { ... } definido a continuación.

Argumento listado: listado es un mutableStateListOf<Pair<Boolean, String>>(). Cada elemento es un Pair, donde first es el valor Boolean que indica si el checkbox está marcado, y second es el texto que se muestra junto al checkbox.
{ item -> ... }: El bloque de código dentro de items(listado) { item -> ... } se ejecuta para cada item en listado. item es el elemento actual de la lista, que en este caso es un Pair<Boolean, String>.

Dentro de este bloque, el contenido de cada elemento se organiza en un Row, que es un contenedor horizontal. Este Row contiene:
Checkbox: Representa el estado (true o false) almacenado en item.first. Si el usuario cambia el estado del checkbox, el estado en listado se actualiza utilizando onCheckedChange.
Text: Muestra el texto de item.second y el estado item.first, permitiendo que el usuario vea el texto del checkbox junto con su estado actual (true o false).
Actualización del Estado: Cuando el usuario cambia el estado del checkbox, onCheckedChange:

Encuentra la posición de item en listado.
Actualiza el Pair en la posición correspondiente de listado con el nuevo estado del checkbox (isChecked), manteniendo el texto sin cambios (item.copy(first = isChecked)).
Al final, cada elemento de la lista es una combinación de un checkbox y un texto que se crea dinámicamente de acuerdo con los elementos en listado.
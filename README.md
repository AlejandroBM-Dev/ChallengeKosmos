Tareas principales

Listado de personajes:

Se renderiza una lista de personajes de Rick y Morty obtenidos de la API https://rickandmortyapi.com/api/character/?page=1.
Cada elemento de la lista muestra la imagen del personaje (obtenida del atributo image) y su nombre (name).

Un botón "Ver detalle" permite mostrar u ocultar la información detallada del personaje.

Al hacer clic en el botón, el texto cambia a "Ocultar detalle" y se muestra la información adicional:

Estado (status)
Especie (species)
Tipo (type)
Género (gender)
Origen (origin)
Ubicación (location)

Diseño de la interfaz:
  Se utiliza Kotlin y Android Jetpack Compose para el diseño de la interfaz gráfica.
Los componentes para mostrar imágenes, botones, detalles y otros elementos se crean de forma reutilizable.

Manejo de datos:
  Se utilizan ViewModels y Flows para la gestión del estado de la aplicación.

Comunicación con el servidor:
  Se utiliza Retrofit para realizar la consulta a la API de Rick y Morty.
  Se implementan corrutinas para manejar la comunicación de forma asíncrona.

Implementación de Clean Architecture:
  Se implementa la arquitectura Clean Architecture con casos de uso, ViewModels y repositorios.

Inyección de dependencias con Dagger Hilt:
  Se utiliza Dagger Hilt para la inyección de dependencias.

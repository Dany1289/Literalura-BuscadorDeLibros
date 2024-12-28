# Literalura-BuscadorDeLibros

Literalura es una aplicación diseñada para interactuar con la API de Gutendex, permitiendo a los usuarios buscar libros, filtrar resultados por idioma, listar los primeros libros disponibles y obtener detalles específicos de cada obra. La aplicación está desarrollada con Spring Boot y sigue una estructura modular y escalable.

Características
Búsqueda por palabra clave: Encuentra libros que coincidan con un término específico.
Filtrado por idioma: Obtén resultados limitados a un idioma en particular.
Listado de primeros libros: Muestra una lista de los primeros libros disponibles según la cantidad deseada.
Detalles del libro: Muestra información detallada sobre un libro utilizando su ID.

Tecnologías Utilizadas
Java 17: Lenguaje de programación principal.
Spring Boot 3.1.4: Framework utilizado para construir y ejecutar la aplicación.
Gutendex API: Fuente de datos para los libros.
PostgreSQL: Base de datos configurada (aunque no utilizada en esta fase del proyecto).
Maven: Gestión de dependencias y construcción del proyecto.

Instalación y Ejecución
Clonar el repositorio

bash
git clone <URL-del-repositorio>
cd literalura
Configurar la base de datos (opcional) Asegúrate de que PostgreSQL esté instalado y configurado correctamente. Luego, actualiza las credenciales en el archivo application.properties.

properties
spring.datasource.url=jdbc:postgresql://localhost:5432/postgres
spring.datasource.username=<tu-usuario>
spring.datasource.password=<tu-contraseña>


Ejecutar la aplicación
mvn spring-boot:run
Interacción con el Catálogo de Libros La aplicación se ejecutará en modo consola y presentará un menú interactivo para realizar las diferentes operaciones.

Uso

Menú Principal
Buscar libros por palabra clave: Permite buscar libros ingresando un término específico.
Filtrar libros por idioma: Ingresa un código de idioma (ej. en para inglés, es para español) para limitar los resultados.
Listar los primeros N libros: Especifica cuántos libros deseas listar.
Mostrar detalles de un libro: Proporciona el ID del libro para obtener información detallada.
Salir: Finaliza la ejecución del programa.

Datos Relevantes
URL de la API de Gutendex: https://gutendex.com/books/
Base de datos:
URL: jdbc:postgresql://localhost:5432/postgres
Usuario: postgres
Contraseña: 12345 (asegúrate de cambiarlo por seguridad).


Estructura del Proyecto
css

├── src
│   ├── main
│   │   ├── java
│   │   │   └── com.alura.literalura
│   │   │       ├── LiteraluraApplication.java
│   │   │       ├── catalogos
│   │   │       │   └── CatalogoLibros.java
│   │   │       ├── services
│   │   │       │   └── GutendexService.java
│   │   └── resources
│   │       ├── application.properties
├── pom.xml

Notas
Asegúrate de tener acceso a internet para interactuar con la API de Gutendex.
Verifica las URLs generadas por la aplicación para depurar posibles errores en las solicitudes HTTP.

Desafíos Técnicos
Durante el desarrollo de este proyecto, se abordaron problemas relacionados con:

Manejo de solicitudes HTTP y manejo de excepciones.
Construcción dinámica de URLs con múltiples parámetros.
Validación de datos de entrada para evitar errores.

Futuras Mejoras
Implementar una interfaz gráfica para mejorar la experiencia del usuario.
Guardar datos relevantes en la base de datos PostgreSQL para consultas rápidas.
Agregar más opciones de filtro, como categorías o autores.

Creado como parte del Challenge Alura.

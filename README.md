# Proyecto Rick an Morty

## Arquitectura

Se utilicó la arquitectura hexagonal y utilizando el formato multi módulos con Maven.
Para ello se crearon los siguientes módulos:

- application: Aquí se definen los casos de uso
- config: Aquí se define la clase principal, los recursos y el Dockerfile
- core: Aquí se define el módulo y la interfaces de ingreso y salida para estos.
- infrastructure: Se crea los adaptadores para conectarse a la base de datos y 
a los servicios de la API de rick and morty.
- ui: Se exponen los servicios CRUD para personajes y ubicaciones consultando la base de datos.

## Uso de la aplicación

Para usar la aplicación se indica clonar el presente proyecto desde el repositorio,
para posteriormente construir la aplicación utilizando docker compose. Para ello, 
es necesario tener instalado docker y docker-compose en el computador donde se desea alojar la aplicación.

Para crear la aplicación se debe ejecutar el siguiente comando en la raiz del proyecto:

- docker-compose up --build

## Servicios disponibles

Al tener la aplicación ejecutándose, se puede consumir los siguientes servicios

### Para personajes

- Buscar por id, GET: http://localhost:8080/api/v1/rickandmorty/character/<id>
- Buscar todos, GET: http://localhost:8080/api/v1/rickandmorty/character/all
- Guardar personaje, POST: http://localhost:8080/api/v1/rickandmorty/character/
- Actualizar personaje, PUT: http://localhost:8080/api/v1/rickandmorty/character/
- Eliminar personaje, DELETE: http://localhost:8080/api/v1/rickandmorty/character/<ID>

### Para ubicaciones

- Buscar por id, GET: http://localhost:8080/api/v1/rickandmorty/location/<id>
- Buscar todos, GET: http://localhost:8080/api/v1/rickandmorty/location/all
- Guardar ubicación, POST: http://localhost:8080/api/v1/rickandmorty/location/
- Actualizar ubicación, PUT: http://localhost:8080/api/v1/rickandmorty/location/
- Eliminar ubicación, DELETE: http://localhost:8080/api/v1/rickandmorty/location/<ID>
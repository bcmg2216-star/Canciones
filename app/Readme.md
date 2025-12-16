# Aplicación de canciones

## Descripción
Esta aplicación muestra un listado de canciones en tarjetas con su imagen, título, artista, álbum y duración.

## Funcionalidades
Permite realizar todas las operaciones de gestión (CRUD):
- **Visualizar:** Listado horizontal de canciones con diseño de tarjetas.
- **Añadir:** Botón flotante para dar de alta nuevas canciones mediante un formulario.
- **Editar:** Posibilidad de modificar los datos de cualquier canción.
- **Borrar:** Eliminación directa de canciones de la lista.

## Estructura
* **Navegación:** Uso de `NavigationComponent` con `AppBarConfiguration` para gestionar la navegación entre el fragmento de Inicio (Santi) y el listado (Canciones).
* **Arquitectura:** Separación de lógica mediante **Controlador** (`ControllerCanciones`) y **DAO** (`DaoCanciones`) simulado.
* **Interfaz:** Diseño limpio usando Material Design components.

## Enlace del video
https://drive.google.com/file/d/1ZYfD-3s_8uA0Kt_QpMfMZ9pfCGdKTVhf/view?usp=drive_link
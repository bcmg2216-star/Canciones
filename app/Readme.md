# Aplicación de canciones

## Descripción
Esta aplicación muestra un listado de canciones en tarjetas con su imagen, título, artista, álbum y duración,
El proyecto ha sido refactorizado completamente para implementar una arquitectura de Clean Architecture y el patrón MVVM.

## Funcionalidades
Permite realizar todas las operaciones de gestión (CRUD) con persistencia de datos real:
- **Acceso:** Pantalla de Login inicial con control de sesión local segura (SharedPreferences).
- **Navegación:** Menú lateral (Navigation Drawer) integrado con Navigation Component y SafeArgs.
- **Visualizar:** Listado de canciones que se actualiza automáticamente (LiveData) reflejando la base de datos local.
- **Añadir:** Botón flotante para guardar nuevas canciones en la base de datos persistente.
- **Editar:** Posibilidad de modificar los datos de cualquier canción existente.
- **Borrar:** Eliminación directa de canciones de la base de datos y de la lista.
- **Cerrar Sesión:** Opción de Logout que borra las preferencias y redirige al Login.


* **Arquitectura Clean + MVVM:**
    * **Domain:** Contiene los Modelos, la Interfaz del Repositorio y los **Casos de Uso** (`Add`, `Delete`, `Get`) que encapsulan la lógica.
    * **Data:** Implementación del Repositorio con Mappers y la base de datos **Room** (Entities y DAO).
    * **UI/Presentation:** Uso de `ViewModel` con `LiveData` para comunicar la vista con el dominio de forma reactiva.
* **Inyección de Dependencias:** Implementación de **Dagger Hilt** para la gestión automática de dependencias (`@Inject`, Módulos, `@HiltAndroidApp`).
* **Persistencia:** Base de datos local SQLite abstraída mediante la librería **Room**.
* **Asincronía:** Uso de **Corrutinas** de Kotlin (`suspend functions`) para operaciones eficientes en segundo plano.
* **Imágenes:** Carga optimizada con la librería **Glide**.

## Enlace del video
https://drive.google.com/file/d/1E5aAWDY4ZasD8nrdLbIGOPjoGmKDmVgL/view?usp=drive_link
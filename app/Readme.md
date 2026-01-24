# Aplicación de canciones

## Descripción
Esta aplicación muestra un listado de canciones en tarjetas con su imagen, título, artista, álbum y duración, 
gestionada ahora mediante un sistema de navegación lateral (Drawer) y control de acceso seguro.

## Funcionalidades
Permite realizar todas las operaciones de gestión (CRUD) y navegación:
- **Acceso:** Pantalla de Login inicial obligatoria con validación de credenciales (admin/1234).
- **Navegación:** Menú lateral (Navigation Drawer) con cabecera personalizada (usuario/foto) y acceso a secciones
- **Visualizar:** Listado horizontal de canciones con diseño de tarjetas.
- **Añadir:** Botón flotante para dar de alta nuevas canciones mediante un formulario.
- **Editar:** Posibilidad de modificar los datos de cualquier canción.
- **Borrar:** Eliminación directa de canciones de la lista.
- **Cerrar Sesión:** Opción de Logout en el menú lateral y superior para volver al Login.
- 
## Estructura
* **Navegación:** Uso avanzado de `NavigationComponent` con `DrawerLayout` para el menú lateral. Configuración de destinos Top-Level y uso de `SafeArgs` para pasar la posición al fragmento de detalles.
* **Arquitectura:** Separación de lógica en dos Activities (`LoginActivity` y `MainActivity`) y uso de **Controlador** (`ControllerCanciones`) y **DAO** (`DaoCanciones`) simulado.
* **Interfaz:** Diseño personalizado con temas propios y menú de opciones (Toolbar).

## Enlace del video
https://drive.google.com/file/d/1E5aAWDY4ZasD8nrdLbIGOPjoGmKDmVgL/view?usp=drive_link
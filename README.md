# 📦 API de Inventario (Spring Boot)

API RESTful para la gestión de inventario, productos y categorías. Desarrollada como proyecto de portafolio para demostrar arquitectura limpia y buenas prácticas en Backend.

## 🚀 Tecnologías Usadas
* **Java 17**
* **Spring Boot 3** (Web, JPA, Validation)
* **H2 Database** (Persistencia en archivo local)
* **Maven** (Gestión de dependencias)

## ⚙️ Funcionalidades
* **CRUD Completo:** Crear, Leer, Actualizar y Borrar Productos y Categorías.
* **Relaciones SQL:** Gestión de claves foráneas (Many-to-One) entre Productos y Categorías.
* **Validaciones:** Control de errores (Precios negativos, nombres vacíos) con `@Valid`.
* **Consultas Avanzadas:** Filtros por rango de precio y búsqueda por categoría.

## 🔌 Endpoints Principales
| Método | URL | Descripción |
| :--- | :--- | :--- |
| `GET` | `/productos` | Lista todos los productos |
| `POST` | `/productos` | Crea un nuevo producto (requiere categoría) |
| `GET` | `/productos/precio?min=10&max=50` | Filtra productos por rango |
| `POST` | `/categorias` | Crea una nueva categoría |

## 🛠️ Cómo probarlo
1.  Clonar el repositorio.
2.  Ejecutar `mvn spring-boot:run`.
3.  Abrir Swagger UI en: `http://localhost:8080/swagger-ui/index.html`

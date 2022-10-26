# Modelado-de-Software
Proyecto "Videogames Store" de la asignatura Modelado de Software - MS - FDI - UCM - (Curso 2021/22) para la gestión de una tienda de videojuegos.

### Arquitectura:
Multicapa (MVC, Modelo-Vista-Controlador) con Integración (Modelo), Negocio (Controller) y Presentación (View):
* La capa de integración es la responsable de la comunicación con recursos y sistemas externos.
* La de negocio proporciona los servicios del sistema.
* La capa de presentación encapsula la lógica de presentación para dar servicio a los usuarios de la aplicación que acceden al sistema.

Para la parte DAO se gestiona la transaccionalidad y concurrencia con un control pesimista (select... for update) evitando conflictos como lecturas sucias, lecturas fantasma, etc.

Para la parte JPA, está definido en un fichero xml la unidad de persistencia y la información para tener el esquema JPA, ya que la forma de persistir los objetos cambia. En los SA llamamos al Persistence.createManagerFactory() que nos da una factoría de EntityManager, el cual maneja el contexto de persistencia y la transaccionalidad que finaliza con commit o rollback. El método persist registra las modificaciones de los objetos de negocio. El control de la concurrencia ahora es optimista, mediante el control de versiones que realiza JPA.

### Patrones:
|  | DAO | JPA |
| :--- | :---: | :---: |
| Comunes a las tres capas | Abstract Factory, Singleton | Abstract Factory, Singleton |
| Integración | Query, Transaction Manager | Marco JPA |
| Negocio | Transfer, Service Application, TOA | Transfer, Service Application, ON |
| Presentación | Service to Worker, Dispatcher View, Context | Service to Worker |

### Modelo Entidad-Relación:
![solarized dualmode](https://github.com/ChristianEG98/Modelado-de-Software/blob/main/Videogames%20Store/image/Entidad-Relaci%C3%B3n%201.jpg)
![solarized dualmode](https://github.com/ChristianEG98/Modelado-de-Software/blob/main/Videogames%20Store/image/Entidad-Relaci%C3%B3n%202.jpg)

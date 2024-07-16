# Alura Challenge Foro Hub

Este proyecto es parte del Challenge ALURA LATAM ONE GRUPO 6 BACK-END CHALLENGE ALURA # 3. La aplicación es una API REST para gestionar un foro, permitiendo a los usuarios realizar operaciones CRUD sobre temas y comentarios.

## Tecnologías Utilizadas

- **Java 17**
- **Spring Boot 3.3.0**
- **Spring Security**
- **JWT (Json Web Token)**
- **MySQL**
- **Maven**

## Características

- Autenticación y autorización utilizando JWT.
- CRUD de usuarios, temas y comentarios.
- Integración con Swagger para documentación de la API.
- Configuración CORS para permitir peticiones desde diferentes orígenes.

## Requisitos

- JDK 17 o superior
- Maven 3.8.1 o superior
- MySQL

## Instalación

1. Clona el repositorio:
    ```sh
    git clone https://github.com/conantkd/alura-challenge-foro-hub.git
    ```

2. Configura la base de datos MySQL:
    ```sql
    CREATE DATABASE forohub;
    ```

3. Actualiza el archivo `application.properties` con la configuración de tu base de datos:
    ```properties
    spring.datasource.url=jdbc:mysql://tu_url/tu_DB
    spring.datasource.username=tu_usuario
    spring.datasource.password=tu_contraseña
    ```

4. Construye y ejecuta la aplicación:
    ```sh
    mvn clean install
    mvn spring-boot:run
    ```

## Uso

La API proporciona los siguientes endpoints:

- **POST /login:** Autentica un usuario y retorna un token JWT.
- **GET /topics:** Lista todos los temas.
- **POST /topics:** Crea un nuevo tema.
- **GET /topics/{id}:** Obtiene un tema por ID.
- **PUT /topics/{id}:** Actualiza un tema por ID.
- **DELETE /topics/{id}:** Elimina un tema por ID.

Consulta la documentación de Swagger en `http://tu_url/swagger-ui.html` para más detalles sobre los endpoints disponibles.

## Configuración de Seguridad

La seguridad se configura en `SecurityConfig.java`. El acceso a la mayoría de los endpoints requiere autenticación. Utiliza el token JWT generado al iniciar sesión para autenticar las solicitudes.

## Contribuciones

Las contribuciones son bienvenidas, realiza un pull request

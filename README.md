# Proyecto: Aplicación de Gestión de Empleo

## Descripción
Esta es una aplicación desarrollada en **Spring Boot** que permite gestionar y consultar datos de empleo en distintas comunidades autónomas. Incluye una base de datos con información detallada sobre empleo, edad, sexo y períodos de tiempo.

## Tecnologías Utilizadas
- **Java 17**
- **Spring Boot**
- **Spring Data JPA**
- **Maven**
- **H2 / MySQL** (dependiendo de la configuración)
- **Thymeleaf** (para vistas, si aplica)
- **RESTful API**

## Estructura del Proyecto
```
AD_H2_2T_Rodrigo_Diaz_Dones/
├── src/
│   ├── main/
│   │   ├── java/com/empleo/app/
│   │   │   ├── EmpleoApplication.java  # Clase principal
│   │   │   ├── controller/
│   │   │   │   ├── DatosController.java  # Controlador REST
│   │   │   ├── model/
│   │   │   │   ├── CCAA.java  # Modelo de comunidad autónoma
│   │   │   │   ├── Datos.java  # Modelo de datos de empleo
│   │   │   ├── repositories/
│   │   │   │   ├── CcaaRepository.java  # Repositorio para CCAA
│   │   │   │   ├── DatosRepository.java  # Repositorio para datos de empleo
│   │   ├── resources/
│   │   │   ├── application.properties  # Configuración de la aplicación
│   ├── test/
│   │   ├── java/com/example/demo/DemoApplicationTests.java  # Pruebas unitarias
├── pom.xml  # Configuración de Maven
├── bbdd.sql  # Script SQL para la base de datos
```

## Instalación y Configuración
### 1. Clonar el repositorio
```sh
git clone https://github.com/tu_usuario/AD_H2_2T_Rodrigo_Diaz_Dones.git
cd AD_H2_2T_Rodrigo_Diaz_Dones
```

### 2. Configurar la Base de Datos
El archivo `bbdd.sql` contiene la estructura de la base de datos. Puedes importarlo en MySQL o configurar H2 en `application.properties`.

Para MySQL:
```properties
spring.datasource.url=jdbc:mysql://localhost:3306/empleo
spring.datasource.username=root
spring.datasource.password=tu_contraseña
```

Para H2 (base de datos en memoria):
```properties
spring.datasource.url=jdbc:h2:mem:empleo
spring.h2.console.enabled=true
```

### 3. Ejecutar la Aplicación
Si estás usando **Maven Wrapper**, puedes ejecutar:
```sh
./mvnw spring-boot:run
```
O con Maven instalado:
```sh
mvn spring-boot:run
```

La aplicación estará disponible en: [http://localhost:8080](http://localhost:8080)

## API REST
El controlador `DatosController.java` expone endpoints para acceder a la información:
- `GET /datos` → Lista todos los registros de empleo.
- `GET /datos/{id}` → Obtiene un registro por ID.
- `POST /datos` → Agrega un nuevo registro.
- `PUT /datos/{id}` → Modifica un registro existente.
- `DELETE /datos/{id}` → Elimina un registro.

## Contribuciones
Si deseas contribuir, puedes hacer un fork del proyecto y enviar un pull request con mejoras.

## Autor
**Rodrigo Díaz Dones** - Desarrollo y Documentación

## Licencia
Este proyecto está bajo la licencia MIT. Puedes ver los detalles en el archivo `LICENSE`.


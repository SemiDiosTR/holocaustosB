Instrucciones para levantar el Proyecto (README).

1.- Herramientas a utilizar:
	Java 17
	Spring Tools Suite 4
	Postman
	Oracle 19c
	Angular
	Git
Nota
	Postman 		Se utilizara para probar las APIs
	Oracle  		Se utilizara para las bases de datos
	Spring Tools Suite 4 	Se utilizara para el desarrollo del backend
	Angular			Se utilizara para el desarrollo del Frontend
	Git 			Se utilizara para crear el repositorio y

2.- Configuracion de Herramientas:
	Configurar conexiones a la base de datos Oracle
	Crear un repositorio en Git para gestionar el código fuente.

3.- Crear el paquete principal del proyecto (microservicios-clientes).
Crear el proyecto base en Spring Tools Suite 4 y configurar las dependencias en pom.xml:
Eureka Discovery Client para el registro en Eureka.
Oracle Driver para la conexión con la base de datos.
Spring Boot Devtools para facilitar pruebas.
Spring Data JPA para manejar datos y entidades.
Spring Web para exposiciones REST.
Validation para validar datos.
Configurar las propiedades básicas en application.properties:
Nombre del servicio: spring.application.name=microservicios-clientes.
Conexión a la base de datos Oracle.
Registro en Eureka (eureka.client.service-url.defaultZone=http://localhost:8761/eureka).
Puerto de la aplicación (server.port=8081).
Organizar los paquetes en el proyecto:
Primero: com.holocaustos.clientes.models.entities para las clases de modelo.
Segundo: com.holocaustos.clientes.models.repositories.
Tercero: com.holocaustos.clientes.models.dto.
Cuarto: com.holocaustos.clientes.mappers.
Quinto: com.holocaustos.clientes.services.
Sexto: com.holocaustos.clientes.controllers.

Paso 2: Crear la clase Cliente en el paquete models.entities.
Definir los atributos de la clase:

idCliente: Identificador único con anotaciones @Id, @GeneratedValue, @SequenceGenerator.
nombre, apellido: Atributos de texto validados con @NotBlank y @Size.
correoElectronico: Validación para correo con @Column y una posible anotación personalizada.
Relación @OneToMany si los clientes tienen otros datos asociados.
Implementar las etiquetas JPA para mapear los campos con la tabla:
@Entity y @Table(name="clientes") para la entidad y su correspondencia en la base de datos.
Generar los métodos Getters y Setters.

Paso 3: Crear la interfaz ClientesRepository en models.repositories.
Extender JpaRepository<Cliente, Long>.
Proporcionar métodos predeterminados como:
findAll() para listar todos los clientes.
findById(Long id) para encontrar un cliente por su ID.
save(Cliente cliente) para crear o actualizar.
deleteById(Long id) para eliminar por ID.

Paso 4: Crear el DTO ClienteDTO en el paquete models.dto.
Definir los campos necesarios:
idCliente, nombre, apellido, correoElectronico.
Aplicar validaciones con jakarta.validation
@NotBlank(message = "El nombre es obligatorio") para evitar campos vacíos.
Validación del correo para asegurar formato válido.
Asegurarse de que esta clase esté orientada a transferir datos ligeros en lugar de incluir lógica.

Paso 5: Crear la clase ClienteMapper en el paquete mappers.
Implementar métodos para transformar datos entre entidades y DTOs:
ClienteDTO entityToDto(Cliente cliente):
Convierte una entidad en un DTO, manteniendo solo los campos relevantes.
Cliente dtoToEntity(ClienteDTO clienteDto):
Convierte un DTO en una entidad, preparándola para persistencia.

Paso 6: Crear la lógica de negocio en services.
Crear la interfaz IClienteService:
Declarar métodos como:
listar() para obtener todos los clientes.
obtenerPorId(Long id) para buscar un cliente por su ID.
crear(ClienteDTO clienteDto) para crear clientes.
eliminarPorId(Long id) para eliminarlos.
actualizar(ClienteDTO clienteDto, Long id) para actualizar datos.
Implementar la clase ClienteServiceImpl:
Inyectar ClientesRepository y utilizar ClienteMapper.
Añadir lógica para manejar transacciones con anotación @Transactional.

Paso 7: Implementar el controlador en controllers.
Crear la clase ClienteController con endpoints REST:
GET /clientes: Lista todos los clientes.
GET /clientes/{id}: Retorna un cliente específico.
POST /clientes: Crea un nuevo cliente.
PUT /clientes/{id}: Actualiza un cliente existente.
DELETE /clientes/{id}: Elimina un cliente por su ID.
Validar datos con @Valid y manejar errores mediante un método de validación.

Paso 8: Configurar y probar con Postman.
Utilizar Postman para probar los endpoints.
Validar las siguientes operaciones:
Listar todos los clientes (GET /clientes).
Crear clientes (POST /clientes).
Actualizar datos (PUT /clientes/{id}).
Eliminar clientes (DELETE /clientes/{id}).
-------------------------------------------------------------------
Pasos realizados en el paquete "Eureka Server":
Configuración de la clase principal:

Se creó la clase EurekaServerApplication y se anotó con @EnableEurekaServer para habilitar el servidor de descubrimiento de servicios.
Se inicializó la aplicación mediante SpringApplication.run.
Definición de propiedades:
Se configuró application.properties para:
Establecer el nombre de la aplicación como eureka-server.
Definir el puerto de ejecución como 8761.
Deshabilitar el registro y la obtención de registros (register-with-eureka=false y fetch-registry=false).
Activar la preferencia por direcciones IP.
Archivo pom.xml:
Se definieron las dependencias necesarias, incluyendo spring-cloud-starter-netflix-eureka-server.
Se añadió la gestión centralizada de dependencias con spring-cloud-dependencies.
Se configuró el plugin spring-boot-maven-plugin para empaquetar la aplicación.
Se incluyó Java 17 como versión base del proyecto.
-----------------------------------------------------------------------------------------------------
Pasos realizados en el paquete "Microservicio de Clientes":
Configuración de la clase principal:

Se creó la clase MicroserviciosClientesApplication, configurada con @SpringBootApplication y @EntityScan para escanear las entidades compartidas.
Implementación del controlador:
En la clase ClienteController, se definió el CRUD completo para clientes, con validaciones y manejo de errores.
Métodos como listar, obtenerPorId, crear, actualizar y eliminarPorId fueron implementados.
Creación de la clase Mapper:
Se implementaron métodos en la clase ClienteMapper para convertir entidades en DTO (entityToDto) y viceversa (dtoToEntity).
Definición del DTO de Cliente:
La clase ClienteDTO fue creada, incluyendo validaciones específicas para atributos requeridos como nombre, apellido, email y telefono.
Diseño del repositorio:
Se creó la interfaz ClientesRepository extendiendo JpaRepository para facilitar operaciones CRUD con la base de datos.
Implementación del servicio:
La clase ClienteServiceImpl contiene la lógica de negocio, con métodos transaccionales para gestionar clientes.
Definición de la interfaz del servicio:
La interfaz IClienteService establece el contrato para los servicios del microservicio.
Archivo de configuración (application.properties):
Se configuraron propiedades para la conexión con la base de datos Oracle y el cliente Eureka.
Se definió el puerto y las configuraciones necesarias para registrar el servicio en el servidor Eureka.
Archivo pom.xml:
Se añadieron dependencias esenciales, como spring-boot-starter-data-jpa, spring-cloud-starter-netflix-eureka-client y el conector JDBC (ojdbc11).
Se configuró la gestión de dependencias con spring-cloud-dependencies.
Se incluyó el plugin de Spring Boot Maven.

-------------------------------------------------------------------------------------------------------------------------

Resumen del paquete "Commons":
Configuración de la clase principal:

Se creó MicroserviciosCommonsApplication2 con la anotación @SpringBootApplication para iniciar la aplicación y habilitar el escaneo de componentes.
Controlador genérico:
La clase CommonController se diseñó para ofrecer un CRUD generalizado adaptable a diferentes entidades, con validaciones y manejo de errores integrados.
Entidades:
Cliente: Representa la tabla CLIENTES con validaciones, relaciones y mapeos completos.
Pedido: Modela la tabla PEDIDOS con relaciones ManyToOne hacia Cliente y ManyToMany hacia Producto.
Producto: Define la tabla PRODUCTOS y su relación ManyToMany con pedidos.
Interfaz y servicio genérico:
CommonService: Define métodos genéricos como listar, crear, obtenerPorId y eliminarPorId.
CommonServiceImpl: Implementa la lógica de negocio para gestionar entidades usando un repositorio genérico y soporte transaccional.
Archivo application.properties:
Se configuraron las propiedades para conectarse a una base de datos Oracle, definiendo credenciales, URL y driver JDBC.
Se asignó el puerto 8081 al servicio y se preparó para posibles integraciones con Eureka.
Archivo pom.xml:
Se añadieron dependencias como spring-boot-starter-data-jpa, spring-boot-starter-validation, spring-boot-starter-web, y el conector JDBC para Oracle.
Uso del plugin spring-boot-maven-plugin para empaquetar la aplicación.
-----------------------------------------------------------------------------------------------------------------------
Resumen del paquete "Gateway":
Configuración de la clase principal:

Se creó la clase MicroserviciosGatewayApplication como punto de entrada para el gateway, utilizando @SpringBootApplication.
Archivo application.properties:
Nombre del servicio configurado como microservicios-gateway.
Puerto asignado: 8090.
Configuración de rutas para enrutar solicitudes a:
microservicios-clientes: /api/clientes/**.
microservicios-productos: /api/productos/**.
microservicios-pedidos: /api/pedidos/**.
Balanceo de carga habilitado mediante Eureka (lb://).
Configuración de CORS para permitir solicitudes desde http://localhost:4200.
Archivo pom.xml:
Dependencias clave:
spring-cloud-starter-gateway: Para enrutar solicitudes y aplicar filtros personalizados.
spring-cloud-starter-netflix-eureka-client: Habilita descubrimiento de servicios mediante Eureka.
Gestión centralizada con spring-cloud-dependencies.
Configuración del plugin spring-boot-maven-plugin para empaquetar la aplicación.
------------------------------------------------------------------------------------------------
Resumen del paquete "Pedidos":
Configuración de la clase principal:

Se creó la clase MicroserviciosPedidosApplication como punto de entrada del microservicio.
@EntityScan habilita el uso de las entidades compartidas desde el paquete Commons.
Controlador PedidoController:
Maneja operaciones CRUD para los pedidos mediante endpoints REST.
Proporciona validaciones detalladas para los datos enviados por el cliente.
Clase PedidoMapper:
Convierte datos entre las entidades Pedido y los objetos de transferencia de datos PedidoDTO, asegurando una separación clara entre capas.
DTO PedidoDTO:
Estructura los datos transferidos en las operaciones de pedido, con validaciones específicas para garantizar su integridad.
Enumeración Estado:
Define los posibles estados de un pedido (CANCELADO, PENDIENTE, ENVIADO, ENTREGADO) con valores asociados para fácil referencia y validación.
Repositorio PedidosRepository:
Extiende JpaRepository para proporcionar acceso directo a la base de datos y realizar operaciones CRUD en la entidad Pedido.
Interfaz IPedidoService:
Define el contrato para los servicios de pedidos, enfocándose en el uso de PedidoDTO.
Implementación del servicio PedidoServiceImpl:
Implementa la lógica de negocio para las operaciones CRUD, manejando la interacción entre los repositorios y los DTOs mediante el PedidoMapper.
Archivo application.properties:
Configura la conexión a la base de datos Oracle, el registro en Eureka y otros parámetros para el microservicio.
Archivo pom.xml:
Define las dependencias clave como spring-boot-starter-data-jpa, spring-cloud-starter-netflix-eureka-client y el paquete compartido Commons.
-------------------------------------------------------------------------------------------------------------------------------------------------
Resumen del paquete "Productos":
Configuración de la clase principal:

Se creó la clase MicroserviciosProductosApplication como punto de entrada del microservicio, habilitando el escaneo de entidades compartidas del paquete Commons.
Controlador ProductoController:
Maneja operaciones CRUD relacionadas con los productos, con validaciones y manejo adecuado de errores.
Clase ProductoMapper:
Facilita la conversión entre entidades Producto y objetos de transferencia de datos ProductoDTO, asegurando una separación clara entre capas.
DTO ProductoDTO:
Estructura los datos transferidos en las operaciones, con validaciones específicas para asegurar su integridad.
Repositorio ProductosRepository:
Extiende JpaRepository para acceder y manipular eficientemente los datos de productos en la base de datos.
Interfaz IProductoService:
Define los contratos para las operaciones relacionadas con la lógica de negocio del microservicio.
Implementación del servicio ProductoServiceImpl:
Proporciona la lógica de negocio para las operaciones CRUD, utilizando el ProductoMapper para interactuar entre entidades y DTOs.
Archivo application.properties:
Configura la conexión con la base de datos Oracle, el registro en Eureka y otros parámetros importantes del microservicio.
Archivo pom.xml:
Establece las dependencias clave, como spring-cloud-starter-netflix-eureka-client, Commons y el driver JDBC para Oracle, asegurando compatibilidad y funcionalidad.

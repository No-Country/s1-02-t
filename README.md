# Medical consultation by video calls :health_worker: :woman_health_worker:

## s1-02-t Solo Backend :wave: :muscle: 

### Team :octocat: :adult: :bowing_man:

- Tomas Padilla - *Desarrollador Full Stack. Tester* - :robot:[PadillaTom](https://github.com/PadillaTom)
- Abel Acevedo- *Desarrollador Backend, Tester, Documentación* - :space_invader:[Abel3581](https://github.com/Abel3581)
- Gabriel Navarro - *Desarrollador Backend, Tester, Documentación* - :brain:[gabynavarro](https://github.com/gabynavarro)


## El por que y para que
Proyecto realizado con el fin de lograr una fluidez entre pacientes y profesionales de una entidad X, por medio de esta app entonces
<br>El paciente puede:
- Registrarse y editar su perfil
- Consultar profesiones 
- Elegir un profesional
- Consultar la agenda del profesional.
- Elegir días y horarios y reservar un turno
 
Como profesional puede:
- Registrarse y editar su perfil
- Realizar una agenda por día y horarios de atención 
- Consultar los turnos asignados
- Llenar y consultar historia clínica del paciente-
- 
Como Admin puede:
- Asignar nuevos roles
- Crear pacientes y profesionales
- Consultar listados de pacientes y profesionales
- Eliminar y dar de baja cualquier usuario de la app
- Editar usuarios de la app
- Consultar listados de turnos asignados 
- Consultar turnos reservados
- 
### PROJECT SETUP

- Postman
- Maven
- JDK 11
- Mysql
- Spring-Boot
- Firebase
- Swagger
### BACKEND
- [Dbeaver-ce](https://dbeaver.io/download/) - Herramienta de administraćión de datos 
- [DbVisualizer](https://www.dbvis.com/) - Herramienta de administración de datos 
- [Pgadmin 4](https://www.pgadmin.org/download/) - Herramienta de administración de datos (Herramienta de mysql)
- [Java 11](https://www.oracle.com/ar/java/technologies/javase/jdk11-archive-downloads.html) - Lenguaje de programación
- [Maven 4.0.0](https://maven.apache.org/index.html) - Manejador de dependencias
- [Spring-Boot](https://spring.io/projects/spring-boot) - Framework
To test the application [Swagger](http://localhost:8080/swagger-ui/index.html)

### Linkedin 
- :robot:[Tomás Padilla](https://www.linkedin.com/in/padillatom/)
- :space_invader:[Abel Acevedo](https://www.linkedin.com/in/abel-fernando-acevedo/)
- :brain:[Gabriel Navarro](https://www.linkedin.com/in/gabriel-navarro-233388219/)

USERS SEED
<table>
<thead>
<tr>
<th>email</th>
<th>role</th>
</tr>
</thead>
<tbody>
<tr>
<td>admin{id}@test.com</td>
<td>admin</td>
</tr>
<tr>
<td>patient{id}@test.com</td>
<td>patient</td>
</tr>
  <tr>
<td>professional{id}@test.com</td>
<td>professional</td>
</tr>
</tbody>
</table>


#### *By default, 3 users with admin role and 3 users with user role will be created where the {id} in the email is a number from 1 to 4 per role. All the users have "12345678" as password.*


ROLES SEED
<table>
<thead>
<tr>
<th>ID</th>
<th>Description</th>
<th>Name</th>
</tr>
</thead>
<tbody>
<tr>
<td>1</td>
<td>ROLE_USER</td>
<td>USER</td>
</tr>
<tr>
<td>2</td>
<td>ROLE_ADMIN</td>
<td>ADMIN</td>
</tr>
 <tr>
<td>3</td>
<td>ROLE_PROFESSIONAL</td>
<td>PROFESSIONAL</td>
</tr>
  <tr>
<td>4</td>
<td>ROLE_PATIENT</td>
<td>PATIENT</td>
</tr>
</tbody>
</table>

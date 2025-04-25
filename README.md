Pasos para levantar el proyecto:

	• SQL: 
	
Descargar la base de datos BD_PROYECTO_FINAL
 Ubicada en el repositorio: ProyectoFinalWorkspace

Crear la base de datos en tu SQLdeveloper

	• BACKEND:
	
Descargar el proyecto backend 
Ubicada en el repositorio: https://github.com/Kniroxe/ProyectoFinalWorkspace.git

Verificar la conexión entre la base de datos y los microservicios


Levantar los microservicios en el siguiente orden:
Eureka - serve
Microservicio - clientes
Microservicio - pedidos
Microservicio - productos
Microservicio - gateway

	• FRONTEND

Requisitos previos
	Node.js instalado
	Angular CLI (npm install -g @angular/cli)

1.-  Clonar el repositorio (si aplica):
git clone https://github.com/tu-usuario/FrontendRepositorioFinal.git
cd FrontendRepositorioFinal


2.- Instalar las dependencias del proyecto:
npm install


3.-  Instalar la librería sweetalert2 en tu proyecto Angular:
npm i sweetalert2


4.- Para compilar y arrancar el servidor de desarrollo de Angular, y abrir automáticamente tu aplicación en el navegador:
ng serve -o

La aplicación estará disponible en: http://localhost:4200
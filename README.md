<h1 align="center">
  <br>
  <a href="http://www.amitmerchant.com/electron-markdownify"><img src="https://f.hubspotusercontent20.net/hubfs/2829524/Copia%20de%20LOGOTIPO_original-2.png"></a>
  <br>
  Proyecto base de Serenityrest
  <br>
</h1>

<h4 align="center">Proyecto base de <a href="https://github.com/karatelabs/karate" target="_blank">Pragma</a>.</h4>

<p align="center">
  <a href="https://www.oracle.com/java/technologies/javase-jdk11-downloads.html">
    <img src="https://img.shields.io/badge/Java-11+-orange.svg" alt="Java">
  </a>
  <a href="https://cucumber.io/">
    <img src="https://img.shields.io/badge/Cucumber-BDD-green.svg" alt="Cucumber">
  </a>
  <a href="https://serenity-bdd.info/">
    <img src="https://img.shields.io/badge/Serenity-Reporting-blueviolet.svg" alt="Serenity">
  </a>
</p>

Proyecto donde hacemos uso de Serenity Rest para la automatización de servicios REST usando el patrón de ScreenPlay

## Topicos

* Java
* Cucumber
* Serenity
* RestAssured
* Selenium

## Tecnologias
### This project required:
- [JDK java] version 17+
- [Serenity] version 4
- [Gradle] last version
- [RestAssured] version 3.6
- [Cucumber] version 3.6
- Screenplay desing pattern


## Descarga
Para clonar está aplicación desde la linea de comando:

```bash
git clone https://github.com/somospragma/qa-backend-proyectobase-serenityrest.git
cd qa-backend-proyectobase-serenityrest
git remote remove origin
git remote add origin URL_DE_TU_NUEVO_REPOSITORIO
git push -u origin master
```
Nota: Asegúrate de reemplazar URL_DE_TU_NUEVO_REPOSITORIO con la URL del repositorio que creaste en tu cuenta de GitHub.

Puedes descargar el proyecto en el enlace [download](https://github.com/somospragma/qa-backend-proyectobase-serenityrest.git) 

## Estructura del proyecto
El proyecto se desarrolló bajo el patrón de diseño de Screenplay, el cual obedece al siguiente esquema:

Los casos de prueba se describen en la ruta src/test/resources/features en los archivos con extensión .feature en formato Given-When-Then, donde cada uno de los tres pasos que lo componen redireccionan a la definición de pasos en la ruta *src/test/java/co/com/pragma/stepdefinitions*

Dentro de las clases Java de definición de pasos, cada uno de los pasos involucrados en su ejecución se describe utilizando las tareas especificadas en la ruta *src/main/java/co/com/pragma/task, donde estas tareas y definiciones de pasos a su vez hacen uso de widgets descritos en clases UI de Java especificadas en la ruta *src/main/java/co/com/pragma/userinterfaces * y también hacen uso de los modelos de conexión a bases de datos en la ruta *src/main/java/co/com/pragma/model. Algunas tareas también utilizan acciones generales descritas en la ruta *src/main/java/co/com/pragma/actions. En la definición de los pasos de validación denotados por el decorador @Then o en las validaciones intermedias en los pasos de acción denotados con el decorador @When, se utilizan clases de preguntas de Java para realizar validaciones. complejos que pueden ser reutilizados, estos se encuentran descritos en la ruta * *src/main/java/co/com/pragma/questions *, a su vez en pasos de validación se realiza la validación de la estructura del cuerpo de respuesta de los microservicios haciendo uso de esquemas JSON definidos en la ruta src/test/resources/schemas.

En algunos archivos .feature se hace uso de clases Java de modelos de tablas de datos para pasar la información de cada caso de prueba a la definición de pasos con el fin de hacer uso de la misma de una manera más óptima y mantenible, estos modelos se encuentran descritos en la ruta *src/main/java/co/com/pragma/model/datatables*.

De la misma manera las clases de definición de pasos Java hacen uso de constantes, métodos, funciones y métodos ejecutables como tareas ubicadas en la ruta *src/main/java/co/com/pragma/test/util*

Al ejecutar casos de prueba de tipo Front o E2E, el proyecto descargará automáticamente la versión más reciente del driver de Chrome según el sistema operativo donde se esté ejecutando. Si esta operación de descarga falla, se envía a la ruta src/test/resources/webdriver, estos drivers deben ser actualizados manualmente por el automator. Estos drivers se pueden descargar desde la página oficial de descarga de Chromium.

La ejecución de los casos de prueba se ordena por las clases Java de runners descritas en la ruta *src/test/java/co/com/pragma/runners*.

## Instalación y ejecución

Para ejecutar está aplicación, necesitas [Gradle](https://gradle.org/install) and [Java JDK](https://www.oracle.com/java/technologies/downloads/) instalados en tu equipo, ten en cuenta que tu IDE puede gestionar la instalación de estos dos requerimientos. Desde la linea de comando:

```
gradle clean build
```
## **Run tests in different environments:**
```
gradle command... -Denvironment=defaul
gradle command... -Denvironment=dev
gradle command... -Denvironment=qa
gradle command... -Denvironment=prod
```
### Note: 
    - The default environment will be used if no other value is provided
    - Could modify the environment urls in .../test/resources/serenity.conf

## Autores


| [<img src="https://secure.gravatar.com/avatar/23b2db02403d79ebd356e8e8356758ec?s=192&d=identicon" width=115><br><sub>Dehiler M. Sepulveda V.</sub>](https://gitlab.com/mauro.ibarrap) <br/> ||
:------------------------------------------------------------------------------------------------------------------------------------------------------------------------------:|:---------------------------------------------------------------------------------------------------------------------------------------------------------------------------:|


## Relacionados

- [proyecto-base-serenity-bdd-screenplay-browsers-and-utilities](https://github.com/somospragma/qa-web-proyecto-base-serenity-bdd-screenplay-browsers-and-utilities)


## Roadmap

- [Guia QA](https://github.com/amitmerchant1990/pomolectron) - (En construcción) Una guia de proyectos Orientados a la Calidad de Software

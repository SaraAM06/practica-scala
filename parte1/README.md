# Parte 1 — Entornos de trabajo

En esta sección se documenta la configuración de los tres entornos de desarrollo independientes solicitados para trabajar con Scala 2.12.21.

## 1.1. Entorno 1 — JupyterLab + Almond Kernel + Scala 2.12.21

### Instalación y ejecución de JupyterLab
Para comenzar, instalé Python en Windows 10 y utilicé el gestor de paquetes `pip` para instalar JupyterLab mediante el comando `pip install jupyterlab`. Una vez instalado, inicié el entorno desde la terminal ejecutando `jupyter lab`, lo que abrió la interfaz correctamente en mi navegador web.

![Inicio de JupyterLab](../images/jupyter-inicio.PNG)

### Instalación de Almond Kernel
Para que JupyterLab reconozca Scala, utilicé `coursier` como gestor de paquetes. 

**Resolución de problemas: Error de versión de Java**
Durante la instalación de Almond, el instalador falló devolviendo el siguiente error: 
`Exception in thread "main" java.lang.Exception: C:\Program Files\Java\jdk-21\java\bin not found`. 
El problema ocurrió porque el sistema intentaba utilizar una ruta antigua de Java 21. Para solucionarlo y asegurar que el entorno utilizara **JDK 17** (tal y como exigen los requisitos), modifiqué el comando forzando la máquina virtual correspondiente mediante el parámetro `--jvm 17`.

El comando definitivo que ejecuté con éxito en la terminal fue:
`cs-x86_64-pc-win32.exe launch --jvm 17 --fork almond --scala 2.12.21 -- --install`

Al reiniciar JupyterLab, comprobé que el kernel de Scala ya estaba disponible.

![Kernel de Almond disponible](../images/jupyter-almond.PNG)

### Verificación de la versión de Scala
Creé un nuevo Notebook utilizando el kernel de Scala. 

**Resolución de problemas: Error Ammonite util**
Al intentar comprobar la versión usando `util.Properties.versionString`, el kernel devolvió un error (`object Properties is not a member of package ammonite.util`). Esto ocurre porque el motor Ammonite intercepta el paquete `util`. Para solucionarlo, especifiqué la ruta absoluta del paquete ejecutando `scala.util.Properties.versionString`.

El resultado devolvió exactamente la versión solicitada: 2.12.21.

![Versión de Scala](../images/jupyter-scala-version.PNG)

### Ejecución de código Scala
Para comprobar el correcto funcionamiento, ejecuté celdas de código realizando operaciones con variables de texto, una suma numérica y creando una colección `List`. Todo se ejecutó correctamente.

![Ejecución de código Scala](../images/jupyter-codigo.PNG)

## 1.2. Entorno 2 — Visual Studio Code + Metals + sbt

### Requisitos previos
Primero, comprobé y configuré la versión correcta de Java (JDK 17) ajustando las variables de entorno de Windows (PATH) para darle prioridad sobre otras versiones instaladas previamente.

![Versión de Java](../images/java-version.PNG)

A continuación, instalé Scala Build Tool (sbt) para gestionar la compilación y ejecución del proyecto.

![Versión de sbt](../images/sbt-version.PNG)

### Configuración del editor
Tras instalar Visual Studio Code, añadí la extensión oficial de Scala (Metals) para habilitar las funcionalidades de desarrollo.

![Inicio VS Code](../images/vscode-inicio.PNG)
![Extensión Metals](../images/vscode-metals.PNG)

### Creación y ejecución del proyecto
Creé manualmente la estructura de directorios estándar de sbt (`src/main/scala`) junto con el archivo de configuración `build.sbt`. Al abrir la carpeta raíz en VS Code, Metals reconoció la estructura e importó el proyecto automáticamente.

![Importación Metals](../images/vscode-metals-import.PNG)

Por último, desde la terminal integrada, utilicé los comandos de sbt para compilar el código (`sbt compile`) y ejecutarlo (`sbt run`), comprobando que la salida por consola era la esperada. *(Nota: Se omitieron las tildes en el código fuente para evitar problemas de codificación nativos de la consola de Windows).*

![Compilación sbt](../images/vscode-sbt-compile.PNG)
![Ejecución sbt](../images/vscode-sbt-run.PNG)

## 1.3. Entorno 3 — IntelliJ IDEA Community + sbt

### Instalación y preparación
Para este entorno utilicé IntelliJ IDEA Community Edition junto con su plugin oficial de soporte para Scala.

![Inicio IntelliJ](../images/intellij-inicio.PNG)
![Plugin de Scala](../images/intellij-plugin.PNG)

### Creación del proyecto y resolución de errores
Configuré un nuevo proyecto indicando Scala como lenguaje, sbt como sistema de construcción y el JDK 17. Durante la generación inicial del proyecto, me encontré con la siguiente incidencia:

* **Error detectado:** `extracting structure failed: Structure file sbt-structure.xml is empty`.
* **Solución:** Este fallo se debía a una incompatibilidad de la plantilla por defecto con Java 17. Para solucionarlo, actualicé la versión en el archivo `project/build.properties` especificando `sbt.version=1.13.0` y forcé la recarga del proyecto, tras lo cual la estructura de directorios se generó correctamente.

### Ejecución del código
Finalmente, creé el objeto `Main` dentro de la ruta `src/main/scala` y ejecuté el programa desde el IDE.

![Ejecución en IntelliJ](../images/intellij-run.PNG)

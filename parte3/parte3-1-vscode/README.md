# Mini proyecto 3.1 — Torneo de Twenty-One

## Entorno

- Visual Studio Code
- Metals
- Scala 2.12.21
- JDK 17
- sbt

## Descripción

Pequeña aplicación en Scala que analiza los resultados de varias manos de un torneo de Twenty-One. El programa evalúa las puntuaciones de los jugadores en dos rondas para determinar quién se ha pasado de 21, contabilizar las manos válidas, buscar la mejor puntuación de cada ronda y compararlas al final. Además, hace uso de colecciones (`List` y `Array`) y distintas estructuras de control.

## Estructura

Los archivos principales del proyecto son:
- `build.sbt`: Archivo de configuración de sbt que define el nombre del proyecto y la versión exacta de Scala (2.12.21).
- `src/main/scala/Main.scala`: Archivo de código fuente principal que contiene las variables, colecciones, funciones y la lógica de ejecución del torneo.

## Funciones utilizadas

- `bust`: Recibe una puntuación y devuelve `true` si es mayor a 21, o `false` en caso contrario.
- `estadoMano`: Recibe una puntuación y devuelve el texto "BUST" o "VALIDA".
- `mejorMano`: Recibe dos puntuaciones y devuelve la mayor válida (o 0 si ambas superan 21).

## Colecciones y bucles (while vs foreach)

Se han utilizado `List` para los nombres inmutables y `Array` para las puntuaciones. Al comparar las iteraciones:
- El bucle `while` necesita definir un contador y una variable mutable (`var i = 0`) para controlar el final de la colección.
- El método `foreach` no necesita contadores ni variables mutables externas. Por ello, el `foreach` se aproxima mucho más al estilo funcional presentado en el material del curso.

![Comparación Foreach](images/comparacion_foreach.png)

## Problemas y soluciones durante el desarrollo

- **Problema:** Al usar `sbt run`, la terminal devolvía el error `No main class detected` y no compilaba nada.
- **Solución:** Se corrigió la ubicación del archivo `Main.scala`, moviéndolo a la ruta estricta `src/main/scala/`, y asegurándose de guardar los cambios en VS Code para que sbt pudiera detectarlo.

## Ejecución

```bash
sbt compile

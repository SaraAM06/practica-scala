package Main

object Main extends App {

  // 3.2.3 Datos iniciales
  val estudiantes = List(
    "Ana",
    "Luis",
    "Marta",
    "Pedro",
    "Sofia"
  )

  val notas = Array(
    8,
    4,
    10,
    6,
    3
  )

  // 3.2.7 Función aprobado
  def aprobado(nota: Int): Boolean = {
    if (nota >= 5) {
      return true
    } else {
      return false
    }
  }

  // 3.2.8 Función estadoNota
  def estadoNota(nota: Int): String = {
    if (aprobado(nota)) {
      return "APROBADO"
    } else {
      return "SUSPENSO"
    }
  }

  // 3.2.9 Función maxNota
  def maxNota(a: Int, b: Int): Int = {
    if (a > b) a
    else if (a < b) b
    else 0
  }

  // 3.2.12 Función clasificacion adicional
  def clasificacion(nota: Int): String = {
    if (nota >= 9) {
      return "EXCELENTE"
    } else if (nota >= 7) {
      return "NOTABLE"
    } else if (nota >= 5) {
      return "APROBADO"
    } else {
      return "SUSPENSO"
    }
  }

  def ejecutarListado(est: List[String], not: Array[Int]): Unit = {
    var i = 0
    while (i < est.length) {
      println(est(i) + " -> " + not(i) + " -> " + estadoNota(not(i)))
      i = i + 1
    }
  }

  def obtenerMejorNota(not: Array[Int]): Int = {
    var mejor_nota = 0
    var j = 0
    while (j < not.length) {
      mejor_nota = maxNota(mejor_nota, not(j))
      j = j + 1
    }
    return mejor_nota
  }

  // CORREGIDO: Ahora cuenta solo los suspensos reales usando estadoNota
  def obtenerNumeroSuspensos(not: Array[Int]): Int = {
    var suspensos = 0
    var j = 0
    while (j < not.length) {
      if (estadoNota(not(j)) == "SUSPENSO") {
        suspensos = suspensos + 1
      }
      j = j + 1
    }
    return suspensos
  }

  // CORREGIDO: Ahora cuenta solo los aprobados reales usando estadoNota
  def obtenerNumeroAprobados(not: Array[Int]): Int = {
    var aprobados = 0
    var j = 0
    while (j < not.length) {
      if (estadoNota(not(j)) == "APROBADO") {
        aprobados = aprobados + 1
      }
      j = j + 1
    }
    return aprobados
  }

  def ejecutarClasificacion(est: List[String], not: Array[Int]): Unit = {
    var g = 0
    while (g < est.length) {
      println(est(g) + " -> " + not(g) + " -> " + clasificacion(not(g)))
      g = g + 1
    }
  }

  def mejorar(est: List[String], not: Array[Int], not_2: Array[Int]): Unit = {
    var i = 0
    while (i < est.length) {
      if (not(i) > not_2(i)) {
        println(est(i) + " ha empeorado")
      } else if (not(i) < not_2(i)) {
        println(est(i) + " ha mejorado")
      } else {
        println(est(i) + " se ha mantenido igual")
      }
      i = i + 1
    }
  }

  // 3.2.10 Listado de estudiantes
  println("--- Recorrer grupo 1 ---")
  ejecutarListado(estudiantes, notas)

  // 3.2.11 Estadísticas
  println("\n--- Resumen del grupo 1 ---")
  println("Estudiantes: " + estudiantes.length)
  println("Aprobados: " + obtenerNumeroAprobados(notas))
  println("Suspensos: " + obtenerNumeroSuspensos(notas))
  println("Mejor nota: " + obtenerMejorNota(notas))

  println("\n--- Recorrer grupo 1 (version 2) ---")
  ejecutarClasificacion(estudiantes, notas)

  // 3.2.13 Segunda evaluación
  val notasSegundaEvaluacion = Array(
    9,
    5,
    8,
    7,
    6
  )

  println("\n--- Recorrer grupo 2 ---")
  ejecutarListado(estudiantes, notasSegundaEvaluacion)

  // CORREGIDO: Se rellenó el print de estudiantes que estaba vacío
  println("\n--- Resumen del grupo 2 ---")
  println("Estudiantes: " + estudiantes.length)
  println("Aprobados: " + obtenerNumeroAprobados(notasSegundaEvaluacion))
  println("Suspensos: " + obtenerNumeroSuspensos(notasSegundaEvaluacion))
  println("Mejor nota: " + obtenerMejorNota(notasSegundaEvaluacion))

  println("\n--- Recorrer grupo 2 (version 2) ---")
  ejecutarClasificacion(estudiantes, notasSegundaEvaluacion)

  // 3.2.14 Comparación de evaluaciones (etiquetas corregidas y llamada a la función mejorar)
  println("\n--- Comparación de evaluaciones ---")
  println("Mejor nota primera evaluación: " + obtenerMejorNota(notas))
  println("Mejor nota segunda evaluación: " + obtenerMejorNota(notasSegundaEvaluacion))
  println("Número de aprobados de la primera: " + obtenerNumeroAprobados(notas))
  println("Número de aprobados de la segunda: " + obtenerNumeroAprobados(notasSegundaEvaluacion))

  println()
  mejorar(estudiantes, notas, notasSegundaEvaluacion)

  // 3.2.15 Uso de listas
  println("\n--- Uso de Listas ---")
  val nuevosEstudiantes = "Carlos" :: estudiantes
  println("Lista original: " + estudiantes)
  println("Lista nueva: " + nuevosEstudiantes)
}
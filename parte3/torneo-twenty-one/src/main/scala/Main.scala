object Main extends App {
  
  // 3.1.6 Datos iniciales
  val jugadores = List(
    "Alex",
    "Chen",
    "Marta",
    "Sindhu",
    "Luis"
  ) 

  val puntuaciones = Array(
    18,
    24,
    21,
    20,
    26
  )

  // 3.1.7 Función bust
  def bust(puntuacion: Int): Boolean = {
    puntuacion > 21
  }

  // 3.1.8 Función estadoMano
  def estadoMano(puntuacion: Int): String = {
    if (bust(puntuacion)) "BUST"
    else "VALIDA"
  }

  // 3.1.9 Función mejorMano
  def mejorMano(handA: Int, handB: Int): Int = {
    if (bust(handA) && bust(handB)) 0
    else if (bust(handA)) handB
    else if (bust(handB)) handA
    else if (handA > handB) handA
    else handB
  }

  // 3.1.10 Procesamiento de la primera ronda
  println("\n--- Resultados de la ronda 1 ---")

  var i = 0
  while(i < puntuaciones.length) {
    println(jugadores(i) + " -> " + estadoMano(puntuaciones(i)))
    i += 1
  }

  // 3.1.11 Estadísticas de la primera ronda
  println("\n--- Resumen de la ronda 1 ---")
  println("Numero de jugadores: " + jugadores.length)

  var j = 0
  var manos_validas = 0
  var mejor_puntuacion = 0
  while(j < puntuaciones.length) {
    if (!bust(puntuaciones(j))) {
      manos_validas += 1
    }

    if(!bust(puntuaciones(j))) {
      if (puntuaciones(j) > mejor_puntuacion) {
        mejor_puntuacion = puntuaciones(j)
      }
    }

    j += 1
  }
  println("Manos validas: " + manos_validas)
  println("Bust: " + (jugadores.length - manos_validas))
  println("Mejor puntuacion valida: " + mejor_puntuacion)

  // 3.1.12 Segunda ronda
  val puntuacionesRonda2 = Array(
    22,
    19,
    20,
    21,
    17
  )

  println("\n--- Resultados de la ronda 2 ---")

  var g = 0
  while(g < puntuacionesRonda2.length) {
    println(jugadores(g) + " -> " + estadoMano(puntuacionesRonda2(g)))
    g += 1

  }

  println("\n--- Resumen de la ronda 2 ---")
  println("Numero de jugadores: " + jugadores.length)

  j = 0
  manos_validas = 0
  var mejor_puntuacion_2 = 0
  while(j < puntuacionesRonda2.length) {
    if (!bust(puntuacionesRonda2(j))) {
      manos_validas += 1
    }

    if(!bust(puntuacionesRonda2(j))) {
      if (puntuacionesRonda2(j) > mejor_puntuacion_2) {
        mejor_puntuacion_2 = puntuacionesRonda2(j)
      }
    }

    j += 1
  }
  println("Manos validas: " + manos_validas)
  println("Bust: " + (jugadores.length - manos_validas))
  println("Mejor puntuacion valida: " + mejor_puntuacion_2)

  // 3.1.13 Comparación de rondas
  println("\n--- Comparacion de rondas ---")
  println("Mejor puntuacion ronda 1: " + mejor_puntuacion)
  println("Mejor puntuacion ronda 2: " + mejor_puntuacion_2)
  
  if (mejor_puntuacion > mejor_puntuacion_2) {
    println("La mejor puntuacion global es: " + mejor_puntuacion)
  } else if (mejor_puntuacion < mejor_puntuacion_2) {
    println("La mejor puntuacion global es: " + mejor_puntuacion_2)
  } else {
    println("Las puntuaciones son iguales")
  }

  // 3.1.14 Uso de foreach
  println("\n--- Uso de foreach ---")
  puntuaciones.foreach(puntos => println(puntos + " -> " + estadoMano(puntos)))
  println("\n")
}
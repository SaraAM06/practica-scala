error id: file:///C:/Users/AlumnoM_AI/OneDrive%20-%20Tajamar/Escritorio/practica-scala-main/parte3/parte3-1-vscode/torneo-twenty-one/src/main/scala/Main.scala:
file:///C:/Users/AlumnoM_AI/OneDrive%20-%20Tajamar/Escritorio/practica-scala-main/parte3/parte3-1-vscode/torneo-twenty-one/src/main/scala/Main.scala
empty definition using pc, found symbol in pc: 
empty definition using semanticdb
empty definition using fallback
non-local guesses:
	 -printnl.
	 -printnl#
	 -printnl().
	 -scala/Predef.printnl.
	 -scala/Predef.printnl#
	 -scala/Predef.printnl().
offset: 1142
uri: file:///C:/Users/AlumnoM_AI/OneDrive%20-%20Tajamar/Escritorio/practica-scala-main/parte3/parte3-1-vscode/torneo-twenty-one/src/main/scala/Main.scala
text:
```scala
// Autora: Sara Antón Madero

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
    else if (handB > handA) handB
  }

  // 3.1.10 Procesamiento de la primera ronda

  var i = 0
  while(i < puntuaciones.length) {
    println(jugadores(i) + "->" + estadoMano(puntuaciones(i)))
    i += 1
  }

  // 3.1.11 Estadísticas de la primera ronda
  println("--- Resumen de la ronda ---")
  printnl("Número de jugadores: " + jugadores.length)

  var j = 0
  while(j < puntuaciones.length) {
    
    j += 1
  }
  @@printnl("Manos válidas:" + estadoMano)
  println("Manos BUST:" + )

}
```


#### Short summary: 

empty definition using pc, found symbol in pc: 
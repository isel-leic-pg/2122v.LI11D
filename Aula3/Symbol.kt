
fun main() {
  print("Symbol? ")
  val sym = readln().trim().first()
  println("sym=$sym code=${sym.code}")
  println("Maíuscula = ${sym in 'A'..'Z'}")
  println("Minuscula = ${sym >='a' && sym <='z'}")
}


fun main() {
  val r = readFloat("Raio")
  val area = circleArea(r)
  println("Area = $area")  
}

fun circleArea(radius: Float) = 3.14F * radius * radius

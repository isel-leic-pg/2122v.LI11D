
fun main() {
	print("Valor? ")
	val value = readln().toInt()
	val n = value % 1000
	val d0 = n % 10
	val d1 = n % 100 / 10
	val d2 = n / 100
	println("Soma dos digitos $n = ${d0+d1+d2}")
}
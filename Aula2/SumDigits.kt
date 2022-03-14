
fun main() {
	print("Valor? ")
	val value = readln()
	val d0 = value.last() - '0'
	val d1 = value[value.length-2] - '0'
	val d2 = value[value.length-3] - '0'
	val n = value.takeLast(3)
	println("Soma dos digitos $n = ${d0+d1+d2}")
}
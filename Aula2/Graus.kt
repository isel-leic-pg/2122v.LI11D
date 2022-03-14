
fun main() {
	print("Temperatura em graus Celsius? ")
	val celsius = readln().toDouble()
	val fahrenheit = 9 * celsius / 5 + 32
	println("$celsius \u00B0C = $fahrenheit \u00B0F")
}
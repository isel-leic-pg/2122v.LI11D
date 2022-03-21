fun main() {
	print("Valor? ")
	val n = readln().toInt()
	val signal = if (n<0) "negativo" else "positivo"
	val pair = if (n%2==0) "par" else "impar"
	println("O número $n é $signal e é $pair")
}
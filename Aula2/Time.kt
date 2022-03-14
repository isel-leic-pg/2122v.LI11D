
fun main() {
	print("Tempo total em segundos? ")
	val total = readln().toInt()
	val h = total / 3600
	val m = total % 3600 / 60
	val s = total % 60
	println("$total segundos = $h:$m:$s")
}
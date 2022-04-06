fun main() {
    val numbers: List<Int> = listOf(44, 40, 11, 14, 31)
    println(numbers)
    val letters = listOf('I','S','E','L')
    println(letters)
    println(numbers[2])
    println(letters[2])
    println(letters.size)
    println(numbers + 4)
    val l2 = numbers - 40
    println(l2)
    println( letters + listOf(' ','P','G') )
    val elems: List<Int> = readInts()
    println(elems)
}

/**
 * Reads a sequence of integer values, one per line.
 * @return A list of the values read.
 */
fun readInts(): List<Int> {
    var values = emptyList<Int>()
    while (true) {
        val line = readln()
        if (line.isEmpty()) return values
        values = values + line.toInt()
    }
}
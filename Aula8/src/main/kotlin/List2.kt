fun main() {
    repeat(4) { index ->
        val numbers = randomIntList(20,2,20)
        println("${index+1} - $numbers")
    }
    val l = (0..25).shuffled()
    println( l )
    println( l.map { 'A'+it } )
}

/**
 * Returns a list with [size] random integer values between [min] and [max], without repetition.
 * If the range of values is less than [size] returns a list with [max]-[min]+1 values.
 * @return The generated list of values.
 */
fun randomIntList(size: Int=5, min:Int=1, max:Int=50): List<Int> {
    var allValues = List(max-min+1) { idx -> min+idx }
    if (max-min+1 < size)
        return allValues.shuffled()
    var numbers: List<Int> = emptyList()
    repeat(size) {
        val n = allValues.random()
        numbers = numbers + n
        allValues = allValues - n
    }
    return numbers
}
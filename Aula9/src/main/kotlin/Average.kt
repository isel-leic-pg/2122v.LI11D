import java.sql.Struct

/**
 * Reads a row of integer values separated by spaces
 * and displays their average and which ones are greater than the average.
 */
fun main() {
    /*
    val line = readln()
    val values = line.toInts()
    val avg = average(values)
    println("Média = $avg")
    println("Maiores que $avg = ${values.biggestThan(avg)}")
     */
    val values = readln().split(' ').map { it.toInt() }
    val avg = values.average()
    println("Média = $avg")
    println("Maiores que $avg = ${values.filter{ it>avg }}")
}

/**
 * Converts a string with the digits of several integer values separated by spaces
 * into a list with those integer values.
 * @receiver String with integer values separated by spaces.
 * @return List with integer values.
 */
fun String.toInts(): List<Int> {
    var ints = emptyList<Int>()
    var spaceIdx = 0
    var lastIdx = 0
    while(spaceIdx < this.length) {
        spaceIdx = this.indexOf(' ',spaceIdx)
        if (spaceIdx==-1) spaceIdx = this.length
        ints = ints + this.subStr(lastIdx,spaceIdx).toInt()
        spaceIdx++
        lastIdx = spaceIdx
    }
    return ints
}

/**
 * Get a part of the string with the symbols from the index [from] to the index [to] (exclusive).
 * @return The sub-string
 */
fun String.subStr(from: Int, to: Int): String {
    var result = ""
    for(idx in from until to)
        result += this[idx]
    return result
}

/**
 * Returns a list of values from the original list that are greater than [value].
 */
fun List<Int>.biggestThan(value: Float): List<Int> {
    var result = emptyList<Int>()
    for (v in this)
        if (v > value)
            result = result + v
    return result
}

/**
 * Returns the average of the values contained in the list [ints].
 */
fun average(ints: List<Int>): Float {
    var sum = 0
    for (v in ints)
        sum += v
    return sum / ints.size.toFloat()
}

/**
 * Reads a sequence of integer values, one per line.
 * @return A list of the values read.
 */
fun readInts(): List<Int> {
    var values = emptyList<Int>()
    while (true) {
        val line = readln().trim()
        if (line.isEmpty()) return values
        values = values + line.toInt()
    }
}
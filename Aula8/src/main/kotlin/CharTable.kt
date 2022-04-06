fun main() {
    val min = readChar("min",'A','Z')
    val max = readChar("max",min,'Z')
    printTable(min,max)
}

/**
 * Reads a user-entered symbol until it is in the range between [min] and [max].
 * @param quest Question to write before entering the symbol.
 * @return The symbol read.
 */
fun readChar(quest: String, min:Char, max:Char): Char {
    /*
    var c: Char
    do {
        print("$quest ($min..$max)? ")
        c = readln()[0]
    } while( c !in min..max )
    return c
    */
    while(true) {
        print("$quest ($min..$max)? ")
        val line = readln()
        if (line.isNotEmpty()) {
            val c = line[0]
            if (c in min..max) return c
        }
    }
}

/**
 * Displays a table with symbols and their Unicode codes from [a] to [b].
 */
fun printTable(a:Char, b:Char) {
    for(c in a..b)
        println("$c - ${c.code}")
}
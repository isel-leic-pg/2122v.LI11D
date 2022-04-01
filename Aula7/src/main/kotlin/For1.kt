fun main() {
    for(n in 1..10) {
        println("Linha $n")
    }
    println("-------------")
    for(c in "ISEL") print("$c ")
    println("\n-------------")
    val txt = "Texto a usar"
    var found = false
    for(c in txt) {
        if (c=='a') {
            println("Existe 'a' em \"$txt\"")
            found = true
            break
        }
    }
    if (!found)
        println("Não existe")
    println("-------")
    println (
        if ( existCharInString('a',txt) ) "Existe 'a' em \"$txt\""
        else "Não existe"
    )
    println("-------")
    println (
        if ( 'a' in txt ) "Existe 'a' em \"$txt\""
        else "Não existe"
    )
}

/**
 * Checks for the existence of a symbol in a string.
 * @param c symbol to look for
 * @param s string where to look
 * @return true if found and false if not
 */
fun existCharInString(c: Char, s: String): Boolean {
    for (e in s)
        if (e == c) return true
    return false
}
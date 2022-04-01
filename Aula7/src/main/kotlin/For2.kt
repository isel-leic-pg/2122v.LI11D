fun main() {
    val txt = "texto a usar"
    var found = false
    for (idx in 0 until txt.length) {
        if ('a' == txt[idx]) {
            println("Existe 'a' no indice $idx de \"$txt\"")
            found = true
            break
        }
    }
    if (!found)
        println("Não existe")
    println("-----------")
    val idx = txt.findIndexOf('a')
    println(
        if (idx>=0) "Existe 'a' no indice $idx de \"$txt\""
        else "Não existe"
    )
    println("-----------")
    val idx2 = txt.indexOf('a',7)
    println(
        if (idx2>=0) "Existe 'a' no indice $idx2 de \"$txt\""
        else "Não existe"
    )
}

/**
 * Gets the index of a symbol in a string.
 * @receiver String where to look
 * @param e Symbol to search
 * @param startIndex index where to start the search
 * @return index of [e] in string or -1 if not found
 */
fun String.findIndexOf(e: Char, startIndex:Int = 0): Int {
    for(idx in startIndex until length)
        if (this[idx]==e) return idx
    return -1
}
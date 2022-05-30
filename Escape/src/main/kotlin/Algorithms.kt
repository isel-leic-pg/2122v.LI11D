
//Generic Algorithms

/**
 * Returns the repeated elements of a list.
 *
 * Using 2 nested loops and a variable with an immutable list or a value with a mutable list.
 */
fun <T> List<T>.repetitions1(): List<T> {
    //var res = listOf<T>()         // Variable with the resulting immutable list
    val res = mutableListOf<T>()    // Value of the resulting mutable list
    for (idx in 0 .. size-2) {      // Outer loop - Select first element
        val elem = this[idx]        // first element
        if (elem !in res)           // Not yet used
            for(idx2 in idx+1 until size)   // Inner loop - Find second element
                if ( elem==this[idx2]) {    // second element same as first
                    // res = res + elem     // Add to resulting list (immutable list)
                    res.add(elem)           // Add to resulting list  (mutable list)
                    break                   // Ignore the remaining
                }
    }
    return res
}

/**
 * Returns the repeated elements of a list.
 * Using only list functions.
 */
fun <T> List<T>.repetitions(): List<T> =
    filterIndexed{ idx, elem -> lastIndexOf(elem) > idx }.distinct()











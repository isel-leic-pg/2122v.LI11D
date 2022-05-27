
//Generic Algorithms

/**
 * Returns the repeated elements of a list.
 *
 * Using 2 nested loops and a variable with an immutable list.
 */
fun <T> List<T>.repetitions(): List<T> {
    var res = emptyList<T>()        // Variable with the resulting list
    for (idx in 0 .. size-2) {      // Outer loop - Select first element
        val elem = this[idx]        // first element
        if (elem !in res)           // Not yet used
            for(idx2 in idx+1 .. size-1)    // Inner loop - Find second element
                if ( elem==this[idx2]) {    // second element same as first
                    res = res + elem        // Add to resulting list
                    break                   // Ignore the remaining
                }
    }
    return res
}

// TODO: Outras variantes de List<T>.repetitions() (MutableList, Indexed/indexOf)

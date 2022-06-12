
/**
 * Recursive implementation of factorial.
 * n! =  (n==0) -> 1 ; (n>0) -> n * (n-1)!
 */
fun factorial(n: Int): Int = if (n==0) 1 else n * factorial(n-1)

/**
 * Iterative implementation of factorial.
 */
fun factorialI(n: Int): Int {
    var res = 1
    for(i in 1..n) res *= i
    return res
}

/**
 * Iterative implementation of sequential search.
 * Only using isEmpty, first and drop functions of List<T>
 */
fun findI(num: Int, nums: List<Int>): Boolean {
    var l = nums
    while (l.isNotEmpty()) {
        if (num==l.first()) return true
        l = l.drop(1)
    }
    return false
}

/**
 * Recursive implementation of sequential search.
 * Only using isEmpty, first and drop functions of List<T>
 */
fun find(num: Int, nums: List<Int>): Boolean {
    if (nums.isEmpty()) return false
    if (num == nums.first()) return true
    return find(num,nums.drop(1))
}

fun main() {
    println( factorial(12) )
    println( factorialI(12) )

    //val l = List(30){ (0..50).random() }.distinct()
    val l = (0..50).shuffled().take(30)
    println(l)
    println(find(25,l))
    println(findI(25,l))
}
fun main() {
    for(e:Char in '9' downTo '0') {
        print("$e ")
    }
    for(c in "ISEL") print("$c ")
    println("\n---------------")
    var n = 9
    do {
        val x = n-1
        print("$n ")
        n=x   // n = n+1
    } while( n >= 0 )
    println("\n---------------")
    var e = 0
    while( e <= 9 ) {
        print("$e ")
        e++
    }
}
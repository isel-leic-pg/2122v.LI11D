
fun main() {
    oper('+', {a,b->a+b} )
    oper('-') {a,b->a-b}
    oper('x') {a,b->a*b}
    oper('/') {a,b->a/b}
    oper('$') {a,b->a*b-b}
}

fun oper(op: Char, f:(Int,Int)->Int) {
    val a = readInt("A")
    val b = readInt("B")
    val res = f(a,b)
    println("$a $op $b = $res")
}


private fun sub() {
    val a = readInt("A")
    val b = readInt("B")
    println("$a - $b = ${a - b}")
}

private fun sum() {
    val a = readInt("A")
    val b = readInt("B")
    println("$a + $b = ${a + b}")
}
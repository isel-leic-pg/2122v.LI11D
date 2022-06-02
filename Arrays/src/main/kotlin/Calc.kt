fun main(args: Array<String>) {
    if (args.size!=3) return
    val a = args[0].toIntOrNull() ?: return
    val b = args[2].toIntOrNull() ?: return
    val op = args[1].first()
    val res = when(op) {
        '+' -> a + b
        '-' -> a - b
        '*','x' -> a * b
        '/',':' -> a / b
        else -> {
            println("Invalid operator $op")
            return
        }
    }
    println("$a $op $b = $res")
}
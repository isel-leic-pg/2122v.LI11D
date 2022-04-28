import pt.isel.canvas.*

fun main() {
    var x = 150
    onStart {
        val area = Canvas(300,200, BLACK)
        area.drawCircle(x,100,50, YELLOW)
        area.onKeyPressed { key: KeyEvent ->
            println(key)
            area.erase()
            x += when (key.code) {
                39 -> 10
                37 -> -10
                else -> 0
            }
            area.drawCircle(x,100,50, YELLOW)
        }
    }
    onFinish { }
    println(x)
}
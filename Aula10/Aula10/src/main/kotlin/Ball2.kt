import pt.isel.canvas.*

fun main() {
    onStart {
        val area = Canvas(300,200, BLACK)
        area.drawCircle(150,100,50, YELLOW)
        area.onTimeProgress(1000) {
            println(it)
            area.drawLine(0,0,area.width,area.height, WHITE, it.toInt()/1000)
        }
        area.onTime(20000) {
            area.close()
        }
    }
    onFinish { }
}
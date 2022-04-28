import pt.isel.canvas.*

const val RADIUS = 50
const val DELTA = 10

fun Canvas.drawBall(c: Point) {
    erase()
    drawCircle(c.x, c.y, RADIUS, YELLOW)
}

data class Point(val x: Int, val y:Int)

fun moveBall(c: Point, keyCode: Int): Point {
    return when (keyCode) {
        RIGHT_CODE -> Point(c.x+DELTA, c.y)
        LEFT_CODE -> Point(c.x-DELTA, c.y)
        UP_CODE -> Point(c.x, c.y-DELTA)
        DOWN_CODE -> Point(c.x, c.y+DELTA)
        else -> c
    }
}

fun main() {
    var center = Point(150,100)
    onStart {
        val area = Canvas(300,200, BLACK)
        area.drawBall(center)
        area.onKeyPressed { key: KeyEvent ->
            center = moveBall(center, key.code)
            area.drawBall(center)
        }
    }
    onFinish { }
}
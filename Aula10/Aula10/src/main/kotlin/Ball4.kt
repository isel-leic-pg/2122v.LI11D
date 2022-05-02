import pt.isel.canvas.*

const val RADIUS = 50
const val DELTA = 4

fun Canvas.drawBall(c: Point, color: Color = Color.YELLOW) {
    erase()
    drawCircle(c.x, c.y, RADIUS, when(color) {
        Color.YELLOW -> YELLOW
        Color.GREEN -> GREEN
        Color.WHITE -> WHITE
    })
    //drawImage("junk|100,100,10,10",c.x-RADIUS,c.y-RADIUS,2*RADIUS,2*RADIUS)
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
    onStart {
        val area = Canvas(width = 300, height = 200, BLACK)
        var center = Point(area.width/2, area.height/2)
        area.drawBall(center)
        area.onKeyPressed { key: KeyEvent ->
            center = moveBall(center, key.code)
            area.drawBall(center)
        }
    }
    onFinish {

    }
}
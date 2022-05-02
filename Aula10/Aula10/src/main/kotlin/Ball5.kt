import pt.isel.canvas.*

const val FRAMES_SEC = 50
const val PERIOD_FRAMES = 1000 / FRAMES_SEC

enum class Direction(val dx:Int, val dy: Int) {
    LEFT(-DELTA,0), RIGHT(+DELTA,0),
    UP(0,-DELTA), DOWN(0,+DELTA),
}

fun Direction.revert(): Direction = when(this) {
    Direction.LEFT -> Direction.RIGHT
    Direction.RIGHT -> Direction.LEFT
    Direction.UP -> Direction.DOWN
    Direction.DOWN -> Direction.UP
}

enum class Color{ YELLOW, GREEN, WHITE }

fun Color.next(): Color =
    Color.values()[(ordinal+1) % Color.values().size ]
/*
  when(this) {
    Color.YELLOW -> Color.GREEN
    Color.GREEN -> Color.WHITE
    Color.WHITE -> Color.YELLOW
  }
*/

data class Ball(
    val center: Point,
    val dir: Direction = Direction.LEFT,
    val color: Color = Color.YELLOW
)

fun Ball.swapColor() = copy( color = color.next() )

//fun Ball.copy(center: Point = this.center , dir: Direction = this.dir) =
//    Ball(center,dir)

fun createStartBall(width: Int, height: Int): Ball =
    Ball( Point(width/2, height/2) )

fun Int.toDir(): Direction? = when (this) {
    RIGHT_CODE -> Direction.RIGHT
    LEFT_CODE -> Direction.LEFT
    UP_CODE -> Direction.UP
    DOWN_CODE -> Direction.DOWN
    else -> null
}

fun Ball.changeDir(dir: Direction?): Ball =
    if (dir==null) this
    else  copy(dir=dir) // Ball( center, dir )

operator fun Point.plus(dir: Direction) = Point(x+dir.dx, y+dir.dy)

fun Ball.move(width: Int, height: Int): Ball {
    val c = center + dir
    if ( c.x in RADIUS..width-RADIUS && c.y in RADIUS..height-RADIUS )
        return copy(center = c)
    val d = dir.revert()
    return copy( center= center+d , dir= d)
}

fun main() {
    onStart {
        val area = Canvas(width = 600, height = 400, BLACK)
        var ball = createStartBall(area.width, area.height)
        area.drawBall(ball.center)
        area.onKeyPressed { key: KeyEvent ->
            ball = ball.changeDir( key.code.toDir() )
            if ( key.char == 'c' )
                ball = ball.swapColor()
        }
        area.onTimeProgress(PERIOD_FRAMES) {
            ball = ball.move(area.width, area.height)
            area.drawBall(ball.center, ball.color)
        }
    }
    onFinish { }
}
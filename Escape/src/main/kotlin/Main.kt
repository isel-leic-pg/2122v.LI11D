import pt.isel.canvas.*

const val CELL_SIZE = 64
const val GRID_WIDTH = 15
const val GRID_HEIGHT = 9

fun main() {
    onStart {
        val cv = Canvas(CELL_SIZE*GRID_WIDTH, CELL_SIZE*GRID_HEIGHT, BLACK)
        var hero = Hero( Cell(GRID_HEIGHT/2, GRID_WIDTH/2), Direction.DOWN)
        cv.drawArena(hero)
        cv.onKeyPressed { key ->
            hero = hero.move(key.code)
            cv.drawArena(hero)
        }
    }
    onFinish {  }
}
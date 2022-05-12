import pt.isel.canvas.*

const val CELL_SIZE = 64
const val GRID_WIDTH = 11
const val GRID_HEIGHT = 7

fun main() {
    onStart {
        val cv = Canvas(CELL_SIZE*GRID_WIDTH, CELL_SIZE*GRID_HEIGHT, BLACK)
        var game = createGame()
        cv.drawArena(game)
        cv.onKeyPressed { key: KeyEvent ->
            game = game.moveHero(key.code)
            cv.drawArena(game)
        }
        cv.onTimeProgress(100) {
            game  = game.stepAnim()
            cv.drawArena(game)
        }
    }
    onFinish {  }
}
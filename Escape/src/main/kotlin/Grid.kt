import pt.isel.canvas.DOWN_CODE
import pt.isel.canvas.LEFT_CODE
import pt.isel.canvas.RIGHT_CODE
import pt.isel.canvas.UP_CODE

/**
 * Represents a grid cell with [line] and [col] information.
 * @property line value in 0 until [GRID_HEIGHT]
 * @property col value in 0 until [GRID_WIDTH]
 */
data class Cell(val line: Int, val col: Int)

/**
 * All valid game positions.
 */
val ALL_POSITIONS: List<Cell> =
    (0 until GRID_HEIGHT).map { line ->
        (0 until GRID_WIDTH).map { col ->
            Cell(line,col)
        }
    }.flatten()
/*
    List(GRID_WIDTH*GRID_HEIGHT) {
        Cell( line = it/GRID_WIDTH, col = it%GRID_WIDTH)
    }
*/

/**
 * It represents the 8 possible directions: vertical, horizontal and oblique.
 * @property lineDif Offset in the lines of this direction.
 * @property colDif Offset in the columns of this direction.
 */
enum class Direction(val lineDif: Int, val colDif: Int) {
    LEFT(0,-1), RIGHT(0,+1), UP(-1,0), DOWN(+1,0),
    LEFT_UP(-1,-1), LEFT_DOWN(+1,-1), RIGHT_UP(-1,+1), RIGHT_DOWN(+1,+1)
}

/**
 * Gets the result of a cell shifted in one direction.
 * [Cell] + [Direction] -> [Cell]
 */
operator fun Cell.plus(dir: Direction) =
    Cell( line+dir.lineDif, col+dir.colDif)

/**
 * Gets the direction of displacement between two cells.
 * [Cell] - [Cell] -> [Direction]
 */
operator fun Cell.minus(b: Cell): Direction? {
    val lineDif = (line-b.line).coerceIn(-1 .. +1)
    val colDif = (col-b.col).coerceIn(-1 .. +1)
    return Direction.values()
        .firstOrNull { it.lineDif==lineDif && it.colDif==colDif }
}

const val PGUP_CODE = 33
const val PGDN_CODE = 34
const val END_CODE = 35
const val HOME_CODE = 36

/**
 * Transforms the code of a key into a direction.
 */
fun Int.toDir(): Direction? = when (this) {
    RIGHT_CODE -> Direction.RIGHT
    LEFT_CODE -> Direction.LEFT
    UP_CODE -> Direction.UP
    DOWN_CODE -> Direction.DOWN
    PGUP_CODE -> Direction.RIGHT_UP
    PGDN_CODE -> Direction.RIGHT_DOWN
    END_CODE -> Direction.LEFT_DOWN
    HOME_CODE -> Direction.LEFT_UP
    else -> null
}

/**
 * Checks if the cell position is within the grid.
 */
fun Cell.inArena() =
    line in 0 until GRID_HEIGHT && col in 0 until GRID_WIDTH



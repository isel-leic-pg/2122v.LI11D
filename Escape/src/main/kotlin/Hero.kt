
data class Cell(val line: Int, val col: Int)

enum class Direction(val lineDif: Int, val colDif: Int) {
    LEFT(0,-1), RIGHT(0,+1), UP(-1,0), DOWN(+1,0),
    LEFT_UP(-1,-1), LEFT_DOWN(+1,-1), RIGHT_UP(-1,+1), RIGHT_DOWN(+1,+1)
}

data class Hero(val pos: Cell, val dir: Direction)
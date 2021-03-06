import pt.isel.canvas.*

/**
 * Draw the entire scene of the game: The hero and the robots.
 */
fun Canvas.drawArena(g: Game) {
    erase()
    drawGrid()
    drawRobots(g.robots)
    drawHero(g.hero)
    drawGarbage(g.garbage)
    drawStatus(g.isOver())
}

const val OVER_TEXT = "Game Over"
const val TEXT_FONT = 64
const val HALF_WIDTH_OF_TEXT = OVER_TEXT.length/2 * TEXT_FONT

private fun Canvas.drawStatus(over: Boolean) {
    if (over)
        drawText(width/2-HALF_WIDTH_OF_TEXT,height/2,OVER_TEXT, RED, TEXT_FONT)
}

private fun Canvas.drawGarbage(garbage: List<Cell>) {
    garbage.forEach{ g ->
        val x = g.col * CELL_SIZE
        val y = g.line * CELL_SIZE
        drawImage("junk.png",x, y, CELL_SIZE, CELL_SIZE)
    }
}

private fun Canvas.drawRobots(robots: List<Actor>) {
    robots.forEach{
        drawActor(it, "robot")
    }
}

private fun Canvas.drawHero(hero: Actor) = drawActor(hero,"Hero")

private fun Canvas.drawActor(a: Actor, imageName: String) {
    val dif = (a.stepAnim*(CELL_SIZE/ANIM_STEPS))
    val x = a.pos.col * CELL_SIZE + dif * (-a.dir.colDif)
    val y = a.pos.line * CELL_SIZE + dif * (-a.dir.lineDif)
    val lineSprite = when(a.dir) {
        Direction.DOWN -> 0
        Direction.LEFT, Direction.LEFT_UP, Direction.LEFT_DOWN -> 1
        Direction.RIGHT, Direction.RIGHT_UP, Direction.RIGHT_DOWN -> 2
        Direction.UP -> 3
    }
    val colSprite = if (a.stepAnim==0) 0 else (ANIM_STEPS-a.stepAnim)%4
    drawImage(
        "$imageName.png|${colSprite*64+5},${lineSprite*64+7},54,54",
        x, y, CELL_SIZE, CELL_SIZE
    )
}

private fun Canvas.drawGrid() {
    repeat(GRID_WIDTH) {
        val x = it*CELL_SIZE
        drawLine( x, 0, x, height, WHITE, 1)
    }
    repeat(GRID_HEIGHT) {
        val y = it*CELL_SIZE
        drawLine( 0, y, width, y, WHITE, 1)
    }
}
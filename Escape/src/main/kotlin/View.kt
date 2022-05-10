import pt.isel.canvas.*

/**
 * Draw the entire scene of the game: The hero and the robots.
 */
fun Canvas.drawArena(g: Game) {
    erase()
    drawGrid()
    drawRobots(g.robots)
    drawHero(g.hero)
}

private fun Canvas.drawRobots(robots: List<Actor>) {
    robots.forEach{
        drawActor(it, "robot")
    }
}

private fun Canvas.drawHero(hero: Actor) = drawActor(hero,"Hero")

private fun Canvas.drawActor(a: Actor, imageName: String) {
    val x = a.pos.col * CELL_SIZE
    val y = a.pos.line * CELL_SIZE
    val lineSprite = when(a.dir) {
        Direction.DOWN -> 0
        Direction.LEFT, Direction.LEFT_UP, Direction.LEFT_DOWN -> 1
        Direction.RIGHT, Direction.RIGHT_UP, Direction.RIGHT_DOWN -> 2
        Direction.UP -> 3
    }
    drawImage("$imageName.png|4,${lineSprite*64+4},56,56", x, y, CELL_SIZE, CELL_SIZE)
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
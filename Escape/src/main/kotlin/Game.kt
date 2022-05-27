/**
 * Game information. The [hero], the [robots] and the [garbage].
 */
data class Game(val hero: Actor, val robots: List<Actor>, val garbage: List<Cell>)

/**
 * Create the initial game.
 */
fun createGame(): Game {
    val heroPos = Cell(GRID_HEIGHT / 2, GRID_WIDTH / 2)
    return Game(
        hero = Actor(heroPos, Direction.DOWN),
        robots = randomRobots(3, heroPos),
        garbage = emptyList()
    )
}

/**
 * Move the hero and robots towards him.
 */
fun Game.moveHero(keyCode: Int): Game {
    //println("key = $keyCode")
    val hero = if (keyCode==SPACE_CODE) {
        val pos = randomFreePosition(this)
        Actor(pos, Direction.DOWN)
    } else
        hero.moveByKey(keyCode)
    val robots = robots.map { it.moveToPos(hero.pos) }
    return copy(hero, robots)
}

fun Game.isStopped() = hero.stepAnim==0 && robots.all{ it.stepAnim==0 }

fun Game.detectCollisions(): Game {
    val robotsPositions = robots.map { it.pos }.repetitions()
    // ... TODO
    return this
}

/**
 * Perform one more animation step.
 */
fun Game.stepAnim(): Game {
    if (isStopped()) return this
    val g = copy(hero.stepAnim(), robots.map { it.stepAnim() })
    return if (g.isStopped()) g.detectCollisions() else g
}

/**
 * Returns a random free position, that doesn't have robot or hero.
 */
fun randomFreePosition(g: Game): Cell =
    (ALL_POSITIONS - g.hero.pos - g.robots.map { it.pos }).random()
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
    if (isOver()) return this
    val hero = if (keyCode==SPACE_CODE) {
        val pos = randomFreePosition(this)
        Actor(pos, Direction.DOWN)
    } else
        hero.moveByKey(keyCode)
    val robots = robots.map { it.moveToPos(hero.pos) }
    return copy(hero, robots)
}

/**
 * Checks if the actors are all stopped.
 */
fun Game.isStopped() = hero.stepAnim==0 && robots.all{ it.stepAnim==0 }

/**
 * Detects collisions between robots and garbage and between robots.
 */
fun Game.detectCollisions(): Game {
    val robotsAfter = robots.filter { it.pos !in garbage }
    val collisions = robotsAfter.map { it.pos }.repetitions()
    val newGarbage = garbage + collisions
    val newRobots = robots.filter { it.pos !in newGarbage }
    return if (newRobots.size == robots.size) this
           else copy(robots = newRobots, garbage = newGarbage)
}

/**
 * Perform one more animation step if any actor is moving.
 * Detect collisions at the end of each animation.
 */
fun Game.stepAnim(): Game {
    if (isStopped()) return this
    val g = copy(hero.stepAnim(), robots.map { it.stepAnim() })
    return if (g.isStopped()) g.detectCollisions() else g
}

/**
 * Detects if the game is over.
 * There are no more robots or the hero is in the same position as a garbage or a robot
 */
fun Game.isOver() =
    robots.isEmpty() || hero.pos in garbage || robots.any { it.pos == hero.pos }

/**
 * Returns a random free position, that doesn't have robot or hero.
 */
fun randomFreePosition(g: Game): Cell =
    (ALL_POSITIONS - g.hero.pos - g.robots.map { it.pos }).random()
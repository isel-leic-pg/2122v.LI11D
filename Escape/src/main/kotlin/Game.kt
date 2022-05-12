/**
 * Game information. The [hero] and the [robots].
 */
data class Game(val hero: Actor, val robots: List<Actor>)

/**
 * Create the initial game.
 */
fun createGame(): Game {
    val heroPos = Cell(GRID_HEIGHT / 2, GRID_WIDTH / 2)
    return Game(
        hero = Actor(heroPos, Direction.DOWN),
        robots = randomRobots(3, heroPos)
    )
}
/**
 * Move the hero and robots towards him.
 */
fun Game.moveHero(keyCode: Int): Game {
    val hero = hero.moveByKey(keyCode)
    val robots = robots.map { it.moveToPos(hero.pos) }
    return Game(hero, robots)
}

/**
 * Perform one more animation step.
 */
fun Game.stepAnim(): Game =
    if (hero.stepAnim==0) this
    else Game( hero.stepAnim(), robots.map { it.stepAnim() } )
/**
 * Game information. The [hero] and the [robots].
 */
data class Game(val hero: Actor, val robots: List<Actor>)

/**
 * Create the initial game.
 */
fun createGame() =
    Game(
        hero = Actor( Cell(GRID_HEIGHT/2, GRID_WIDTH/2), Direction.DOWN),
        robots = randomRobots(10)
    )

/**
 * Move the hero and robots towards him.
 */
fun Game.moveHero(keyCode: Int): Game {
    val hero = hero.moveByKey(keyCode)
    val robots = robots.map { it.moveToPos(hero.pos) }
    return Game(hero, robots)
}
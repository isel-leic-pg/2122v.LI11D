
/**
 * Represents an actor.
 * Position ([pos]) and the direction ([dir]) to move.
 */
data class Actor(val pos: Cell, val dir: Direction)

/**
 * Moves the actor in the direction associated with the indicated key ([keyCode]).
 * @receiver The original actor.
 * @param keyCode Key code of key pressed.
 * @return The actor after the movement.
 */
fun Actor.moveByKey(keyCode: Int): Actor {
    val dir:Direction = keyCode.toDir() ?: return this
    return moveToDir(dir)
}

/**
 * Moves actor in one direction ([dir]).
 * @receiver The original actor.
 * @param dir direction of movement.
 * @return The actor after the movement.
 */
private fun Actor.moveToDir(dir: Direction): Actor {
    val pos = pos + dir
    return if (pos.inArena())
        Actor(pos, dir)
    else
        copy(dir = dir)
}

/**
 * Moves actor in direction of a position ([to])
 */
fun Actor.moveToPos(to: Cell): Actor {
    val dir = (to - pos) ?: return this
    return moveToDir(dir)
}

/**
 * Creates [n] robots in random grid positions.
 */
fun randomRobots(n: Int): List<Actor> {
    val allCells = List(GRID_WIDTH*GRID_HEIGHT) {
        Cell( line = it/GRID_WIDTH, col = it%GRID_WIDTH)
    }
    return allCells.shuffled().take(n).map { Actor(it,Direction.DOWN) }
}
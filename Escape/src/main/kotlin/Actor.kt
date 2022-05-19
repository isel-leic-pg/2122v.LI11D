/**
 * Total number of animation step between cells.
 */
const val ANIM_STEPS = 16

const val SPACE_CODE = 32

/**
 * Represents an actor.
 * Position ([pos]), the direction ([dir]) to move
 * and the animation step ([stepAnim]) between cells.
 */
data class Actor(val pos: Cell, val dir: Direction, val stepAnim: Int = 0)

/**
 * Moves the actor in the direction associated with the indicated key ([keyCode]).
 * @receiver The original actor.
 * @param keyCode Key code of key pressed.
 * @return The actor after the movement.
 */
fun Actor.moveByKey(keyCode: Int): Actor {
    val dir: Direction = keyCode.toDir() ?: return this
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
        Actor(pos, dir, ANIM_STEPS-1)
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
fun randomRobots(n: Int, except: Cell): List<Actor> {
    val allCells = ALL_POSITIONS - except
    return allCells.shuffled().take(n).map { Actor(it,Direction.DOWN) }
}

/**
 * Perform one more animation step in actor.
 */
fun Actor.stepAnim() = if (stepAnim>0) copy(stepAnim=stepAnim-1) else this
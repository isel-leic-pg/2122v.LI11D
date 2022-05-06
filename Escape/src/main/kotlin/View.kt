import pt.isel.canvas.Canvas

fun Canvas.drawArena(h: Hero) {
    val x = h.pos.col * CELL_SIZE
    val y = h.pos.line * CELL_SIZE
    drawImage("Hero.png|0,0,64,64",x,y,CELL_SIZE,CELL_SIZE)
}
import pt.isel.canvas.*

fun main() {
    println("Begin")
    onStart {
        val area = Canvas(300,200, BLACK)
        val cv2 = Canvas(100,100, YELLOW)
        area.drawCircle(150,100,50, YELLOW)
        println("Start")
    }
    onFinish {
        println("Finish")
    }
    println("End.")
}
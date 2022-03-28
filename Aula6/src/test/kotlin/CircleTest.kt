import kotlin.test.*

class CircleTest {
    @Test
    fun testArea0() {
        val r = circleArea(0F)
        assertEquals(0F,r)
    }
    @Test
    fun testArea1() {
        assertEquals(3.14F, circleArea(1F))
    }
    @Test
    fun testAreaValue() {
        assertEquals(18.086403F , circleArea(2.4F))
    }
}
import kotlin.test.*
class SortTest {
    @Test
    fun orderedSort() {
        assertEquals("1 2 3",sortValues(1,2,3))
        assertEquals("-10 0 15",sortValues(-10,0,15))
    }
}
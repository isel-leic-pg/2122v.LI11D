import kotlin.test.*

class RepetitionsTests {
    @Test
    fun `example in class room`() {
        val original = listOf(2,3,5,3,7,2,7)
        val result = listOf(2,3,7)
        assertEquals(result, original.repetitions())
    }
    @Test
    fun `limit tests`() {
        assertEquals(emptyList(), listOf(1,2,3,4,10,12).repetitions())
        assertEquals(listOf(1), listOf(1,2,3,4,5,1).repetitions())
    }
}
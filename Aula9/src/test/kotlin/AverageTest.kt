import kotlin.test.*

class AverageTest {
    @Test
    fun subStrTest() {
        assertEquals("xp","xpto".subStr(0,2) )
        assertEquals("pt","xpto".subStr(1,3) )
        assertEquals("to","xpto".subStr(2,4) )
    }
    @Test
    fun toIntsTest() {
        assertEquals(listOf(47,27,541) ,"47 27 541".toInts())
    }
}
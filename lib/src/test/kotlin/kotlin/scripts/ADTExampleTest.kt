package adventures

import adventures.Cata.ofNullable
import kotlin.test.Test
import kotlin.test.assertTrue

class ADTExampleTest {
        @Test
        fun ofNullableTest() {
                val x: String? = null
                assertTrue(ofNullable(x) == None<String>())

                val y: String? = "abcde"
                assertTrue(ofNullable(y) == Some("abcde"))
        }
}

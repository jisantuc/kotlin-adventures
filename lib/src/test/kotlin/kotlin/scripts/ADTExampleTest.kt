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

        @Test
        fun testConfigOOUnitIsomorphism() {
                val f: (Config) -> Option<Option<Unit>> = { conf: Config ->
                        when (conf) {
                                Config.ConfigA -> None<Option<Unit>>()
                                Config.ConfigB -> Some(None<Unit>())
                                Config.ConfigC -> Some(Some(Unit))
                        }
                }

                val g: (Option<Option<Unit>>) -> Config = { o: Option<Option<Unit>> ->
                        when (o) {
                                Some(Some(Unit)) -> Config.ConfigC
                                Some(None<Unit>()) -> Config.ConfigB
                                else -> Config.ConfigA
                        }
                }

                testInvertibility(Config.ConfigA, f, g)
                testInvertibility(Config.ConfigB, f, g)
                testInvertibility(Config.ConfigC, f, g)

                testInvertibility(Some(Some(Unit)), g, f)
                testInvertibility(Some(None<Unit>()), g, f)
                testInvertibility(None<Option<Unit>>(), g, f)
        }

        fun <A, B> testInvertibility(a: A, f: (a: A) -> B, g: (b: B) -> A): Unit =
                        assertTrue(g(f(a)) == a)
}

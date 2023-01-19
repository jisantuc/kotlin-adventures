package adventures

sealed class UnitOrBool()

final data class OfUnit(val u: Unit) : UnitOrBool()

final data class OfBool(val b: Boolean) : UnitOrBool()

sealed class Option<A>

final class None<A>() : Option<A>() {
        override fun equals(other: Any?): Boolean {
                return when (other) {
                        is None<*> -> true
                        else -> false
                }
        }
}

final data class Some<A>(val value: A) : Option<A>() {
        override fun equals(other: Any?): Boolean {
                return when (other) {
                        is Some<*> -> other.value == this.value
                        else -> false
                }
        }
}

enum class Config {
        ConfigA,
        ConfigB,
        ConfigC;
}

object Cata {

        fun <A> ofNullable(a: A?): Option<A> {
                return when (a) {
                        null -> None<A>()
                        else -> Some(a)
                }
        }

        fun configToString(c: Config): String {
                return when (c) {
                        Config.ConfigA -> "a"
                        Config.ConfigB -> "b"
                        Config.ConfigC -> "c"
                }
        }

        fun boolToString(ob: OfBool): String {
                return when (ob) {
                        OfBool(true) -> "true"
                        OfBool(false) -> "false"
                        else -> "who cares"
                }
        }

        fun <A> optionToString(option: Option<A>): String {
                return when (option) {
                        is Some -> "${option.value}"
                        is None -> "none :("
                }
        }
}

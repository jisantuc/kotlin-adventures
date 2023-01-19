package adventures

class Thunk<A>(val f: (u: Unit) -> A) {

    fun run(): A = f(Unit);

    companion object Constructors {
        fun <A, Out> delay(f: (a: A) -> Out, a: A) = Thunk { _: Unit -> f(a) }
        fun <A, B, Out> delay(f: (a: A, b: B) -> Out, a: A, b: B) = Thunk { _: Unit -> f(a, b) }
        fun <A, B, C, Out> delay(f: (a: A, b: B, c: C) -> Out, a: A, b: B, c: C) =
                Thunk { _: Unit -> f(a, b, c) }

        fun <A, B, C, D, Out> delay(f: (a: A, b: B, c: C, d: D) -> Out, a: A, b: B, c: C, d: D) =
                Thunk { _: Unit -> f(a, b, c, d) }
    }

    // etc.
}

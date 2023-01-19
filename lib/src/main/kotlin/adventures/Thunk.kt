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

object ExpensiveComputations {
    fun doSomething1(x: Int, y: Int, z: Int): Unit {
        val result = x + y + z
        println(result)
    }

    fun doSomething2(x: Int, y: Int, z: Int): Unit {
        val result = x + y - z
        println(result)
    }

    fun doThings(x: Int, y: Int, z: Int) = {
        doSomething1(x, y, z)
        doSomething2(x, y, z)
    }

    fun doThingsThunked(x: Int, y: Int, z: Int) = {
        val thunk1 = Thunk.delay(::doSomething1, x, y, z)
        val thunk2 = Thunk.delay(::doSomething2, x, y, z)
        val thunk3 = Thunk.delay(::println, "hello")
    }
}

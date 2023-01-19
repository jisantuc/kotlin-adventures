package adventures

import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.launch
import kotlinx.coroutines.delay

class Thunk<A>(val f: (u: Unit) -> A) {

    suspend fun run(): A {
      delay(1000);
      return f(Unit);
    }

    fun runSync(): A {
      java.lang.Thread.sleep(1000L);
      return f(Unit);
    }

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

// TODO -- variadic thunk args, launch them all
object Combinators {
  fun <A> concurrently(vararg thunks: Thunk<A>): Unit = runBlocking {
    thunks.iterator().forEach { t -> launch { t.run() } }
  }
}

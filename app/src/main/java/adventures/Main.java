package adventures;

import java.util.List;
import kotlin.jvm.functions.Function1;

class Main {

        public static void main(String[] args) throws InterruptedException {
                Function1<Integer, Integer> debugInt = x -> {
                        System.out.println(x);
                        return x;
                };
                Thunk<Integer> d1 = Thunk.Constructors.delay(debugInt, Integer.valueOf(3));

                // takes 5 seconds
                //  List.of(d1, d1, d1, d1, d1).forEach(Thunk::runSync);

                // takes _less than 5 seconds_
                // Combinators.INSTANCE.concurrently(d1, d1, d1, d1, d1);

                System.out.println("done");
        }
}

package adventures;

import kotlin.jvm.functions.Function1;

class Main {

        public static void main(String[] args) {
                Function1<Integer, Integer> debug = x -> {
                        System.out.println(x);
                        return x;
                };
                Thunk<Integer> print = Thunk.Constructors.delay(debug, Integer.valueOf(3));
//                print.run();
                System.out.println("done");
        }
}

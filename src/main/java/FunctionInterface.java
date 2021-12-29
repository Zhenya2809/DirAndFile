import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
import java.util.function.*;

public class FunctionInterface {
    public static void main(String[] args) {
        Predicate<Integer> primeNumber = x -> (x % 2 != 0) && (x > 0);
        System.out.println("number is prime? " + primeNumber.test(5));

        Consumer<Integer> numberGenerator = x -> {
            Random random = new Random();
            System.out.println("number = " + random.nextInt() * x);
        };
        numberGenerator.accept(5);

ыфв
        Supplier<String> dayOfWeekSupplier = () -> {
            Date date = new Date();
            SimpleDateFormat dateFormat = new SimpleDateFormat("EEEE");
            return dateFormat.format(date);
        };
        System.out.println(dayOfWeekSupplier.get());

        Function<Double, Long> doubleToLongFunction = (x) -> x.longValue();
        System.out.println("double to long = " + doubleToLongFunction.apply(1241.2));

        UnaryOperator<Integer> integerUnaryOperator = n -> {
            int a = 0;
            int b = 1;
            for (int i = 2; i <= n; ++i) {
                int next = a + b;
                a = b;
                b = next;
            }
            return b;

        };
        System.out.println("число фибоначи (0,1,1,2,3,5,8,13,21,34,55....) = "+integerUnaryOperator.apply(5));
    }
}


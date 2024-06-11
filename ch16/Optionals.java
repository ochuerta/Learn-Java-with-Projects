package ch16;

import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.OptionalDouble;
import java.util.OptionalInt;
import java.util.stream.IntStream;

public class Optionals {

    public static void main(String[] args) {
        doOptionalPrimitiveAverage();
        doOptionalAPI();
        createOptionals();
        doOptionalNull();
    }

    public static void createOptionals() {
        Optional<Object> opt1 = Optional.empty();
        opt1.ifPresent(System.out::println);

        Optional<Integer> opt2 = Optional.of(23);
        opt2.ifPresent(System.out::println);

        Optional<Integer> opt3 = Optional.of(23);
        opt3.ifPresent(System.out::println);

        Optional<Object> opt4 = Optional.empty();
        opt4.ifPresent(System.out::println);
        if (opt4.isEmpty()) {
            System.out.println("opt4 is empty!"); // opt4 is empty!
        }
    }

    public static void doOptionalPrimitiveAverage() {
        OptionalDouble optAvg = IntStream.rangeClosed(1, 10).average();
        optAvg.ifPresent(System.out::println); // 5.5
        if (optAvg.isPresent()) {
            System.out.println(optAvg.getAsDouble()); // 5.5
        }
        double dblAvg = optAvg.orElse(Double.NaN); // Directly use orElse
        System.out.println(dblAvg); // 5.5

        OptionalInt optInt = OptionalInt.of(35);
        int age = optInt.orElse(0);
        System.out.println(age); // 35
        System.out.println(optInt.getAsInt()); // 35
    }

    public static void doOptionalNull() {
        Optional<String> optSK = howToDealWithNull("SK");
        optSK.ifPresent(System.out::println); // SK

        Optional<String> emptyOpt = howToDealWithNull(null);
        System.out.println(emptyOpt.orElseGet(Optionals::getEmptyOptionalMessage)); // Empty optional
    }

    public static Optional<String> howToDealWithNull(String param) {
        return Optional.ofNullable(param);
    }

    public static void doOptionalAPI() {
        Optional<Double> valueInOptional = Optional.of(60.0);
        valueInOptional.ifPresent(System.out::println); // 60.0
        System.out.println(valueInOptional.orElse(Double.NaN)); // 60.0

        Optional<Double> emptyOptional = Optional.empty();
        System.out.println(emptyOptional.orElse(Double.NaN)); // NaN
        System.out.println(emptyOptional.orElseGet(Math::random)); // Random number
        try {
            System.out.println(emptyOptional.orElseThrow(NoSuchElementException::new)); // NoSuchElementException
        } catch (NoSuchElementException e) {
            System.out.println("Exception caught: " + e);
        }
    }

    private static String getEmptyOptionalMessage() {
        return "Empty optional";
    }
}

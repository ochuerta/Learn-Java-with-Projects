package ch14;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class MethodReferenceTypes {
    public static void main(String[] args) {
        boundMethodReferences();        // bound
        unboundMethodReferences();      // unbound
        constructorMethodReferences();  // constructor
        staticMethodReferences();       // static
    }

    public static void boundMethodReferences(){
        String name = "Mr. Joe Bloggs";

        // Supplier<T>
        // T get()
        Supplier<String> lowerMR = name::toLowerCase; // method reference
        System.out.println(lowerMR.get()); // mr. Joe Bloggs

        // Predicate<T>
        // boolean test(T t)
        Predicate<String> titleMR = name::startsWith;
        System.out.println(titleMR.test("Mr.")); // true
        System.out.println(titleMR.test("Ms.")); // false
    }

    public static void unboundMethodReferences(){
        // Function<T, R>
        // R apply(T t)
        Function<String, String> upperMR = String::toUpperCase;
        System.out.println(upperMR.apply("sean")); // SEAN

        // BiFunction<T, U, R>
        // R apply(T t, U u)
        BiFunction<String, String, String> concatMR = String::concat;
        System.out.println(concatMR.apply("Sean ", "Kennedy")); // Sean Kennedy
    }

    public static void constructorMethodReferences(){
        // Supplier<T>
        // T get()
        Supplier<StringBuilder> sbMR = StringBuilder::new; // method reference
        StringBuilder sb = sbMR.get();
        sb.append("method reference version");
        System.out.println(sb);

        // Function<T, R>
        // R apply(T t)
        Function<Integer, List<String>> alMR = ArrayList::new;
        List<String> ls = alMR.apply(200); // initial capacity 200
        ls.add("88");
        System.out.println(ls); // [88]
    }

    public static void staticMethodReferences(){
        // Consumer<T>
        // void accept(T t)
        Consumer<List<Integer>> sortMR = Collections::sort;

        List<Integer> listOfNumbers = Arrays.asList(8, 12, 4, 3, 7);
        sortMR.accept(listOfNumbers); // execution
        System.out.println(listOfNumbers); // [3, 4, 7, 8, 12]
    }
}




/*
        X x = new X();
        x.accept("abc");
       listOfNumbers.forEach(x);

*/




/*
        List<String> names = Arrays.asList("Sean", "Mary", "John");
        names.forEach(name -> System.out.println(name)); // lambda
        names.forEach(System.out::println); // method reference
        
        

*/
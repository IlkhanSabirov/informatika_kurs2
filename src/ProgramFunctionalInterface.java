import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class ProgramFunctionalInterface {
    public static void main(String[] args) {
        Function<String,Integer> countFunction = s -> {
            int count = 0;
            for (int i = 0; i < s.length(); i++) {
                if (Character.isLetter(s.charAt(i))) {
                    count++;
                }
            }
            return count;
        };

        Predicate<Integer> numberPredicate = number -> number % 2 == 1;

        Consumer<Integer> printNumber = System.out::println;

        List<String> word = new ArrayList<>();

        word.add("hello");
        word.add("my world");
        word.add("java");

        Stream<String> wordStream = word.stream();

        Stream<Integer> countStream = wordStream.map(countFunction);

        Stream<Integer> numberStream = countStream.filter(numberPredicate);

        numberStream.forEach(printNumber);

        System.out.println("**************");

        word.stream().map(
                s -> {
                    int count = 0;
                    for (int i = 0; i < s.length(); i++) {
                        if (Character.isLetter(s.charAt(i))) {
                            count++;
                        }
                    }
                    return count;
                }
        ).filter(number -> number % 2 == 1).forEach(System.out::println);
    }
}

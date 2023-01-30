import java.util.*;
import java.util.function.BiConsumer;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        System.out.println("Тренировка по вебинару");
        System.out.println("Задача 1");
        Stream.iterate(2, e -> e + 2)
                .limit(11)
                .forEach(e -> System.out.print(e + ", "));
        System.out.println();

        System.out.println("Задача 2");
        List<User> users = List.of(
                new User(20),
                new User(18),
                new User(19),
                new User(21),
                new User(17)
        );
        boolean result = users.stream()
                .noneMatch(user -> user.getAge() < 18);
        System.out.println(result);

        System.out.println("Задача 3");
        Integer[] arr = new Integer[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

        Arrays.stream(arr)
                .sorted(Comparator.reverseOrder())
                .limit(5)
                .forEach(s -> System.out.print(s + ", "));
        System.out.println();
        Arrays.stream(arr)
                .sorted(Comparator.naturalOrder())
                .skip(arr.length - 5)
                .forEach(s -> System.out.print(s + ", "));

        System.out.println("Задача 4");
        System.out.println(users.stream()
                .mapToInt(User::getAge)
                .average()
                .orElse(0));
        System.out.println();

        // Задание 1
        System.out.println("Домашнее задание");
        System.out.println("Задание 1");
        ArrayList<Integer> arrayList = new ArrayList<>(Arrays.asList(6, 2, 1, 9, 4, 5, 22, 24, 8, 7, 21));
        Stream<Integer> stream = new ArrayList<>(arrayList).stream();
        Comparator<Integer> order = Comparator.naturalOrder();
        BiConsumer<Integer, Integer> minMaxConsumer = (x, y) -> System.out.println("Минимальный элекмент: " + x + ", Максимальный элемент: " + y);
        findMinMax(stream, order, minMaxConsumer);

        // Задание 2
        System.out.println("Задание 2");
        printCountAndEvenNumbers(arrayList);
    }

    private static <T> void findMinMax(Stream<? extends T> stream,
                                       Comparator<? super T> order,
                                       BiConsumer<? super T, ? super T> minMaxConsumer) {
        T min = null;
        T max = null;
        List<T> arrList = stream
                .sorted(order)
                .collect(Collectors.toList());
        if (arrList.size() != 0) {
            min = arrList.get(0);
            max = arrList.get(arrList.size() - 1);
        }
            minMaxConsumer.accept(min, max);
    }

    private static void printCountAndEvenNumbers(List<Integer> numbers) {
        List<Integer> evenNumbers = numbers.stream()
                .filter(n -> (n % 2 == 0))
                .toList();

        System.out.println("Количество четных чисел: " + evenNumbers.size());
        System.out.println("Четные числа: " + evenNumbers);
    }

    private static class User {
        private final int age;

        public User(int age) {
            this.age = age;
        }

        public int getAge() {
            return age;
        }
    }
}
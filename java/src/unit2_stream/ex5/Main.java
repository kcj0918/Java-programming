package unit2_stream.ex5;

import java.util.ArrayList;
import java.util.Optional;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        /*
        Stream<ArrayList<T>>에 있는 모든 요소들을 ArrayList<T> 하나로 결합하라.
        reduce의 세가지 형태를 이용해 이 작업을 수행하는 방법을 보여라.
         */
        ArrayList<Integer> list1 = new ArrayList<>();
        list1.add(1);
        list1.add(2);
        list1.add(3);

        ArrayList<Integer> list2 = new ArrayList<>();
        list2.add(4);
        list2.add(5);
        list2.add(6);

        ArrayList<Integer> list3 = new ArrayList<>();
        list3.add(7);
        list3.add(8);
        list3.add(9);


        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        list.add(list1);
        list.add(list2);
        list.add(list3);

        Stream<ArrayList<Integer>> stream = list.stream();
        ArrayList<Integer> result = join(stream);
//        result.forEach(System.out::println);

        Stream<ArrayList<Integer>> stream1 = list.stream();
        Optional<ArrayList<Integer>> result1 = join1(stream1);
        result1.ifPresent(l -> {
            l.stream().forEach(System.out::println);
        });
    }

    static <T> ArrayList<T> join(Stream<ArrayList<T>> stream) {
        return stream.reduce(new ArrayList<>(), (result, elements) -> {
            result.addAll(elements);
            return result;
        });
    }

    static <T> Optional<ArrayList<T>> join1(Stream<ArrayList<T>> stream) {
        return stream.reduce((list1, list2) -> {
            ArrayList<T> result = new ArrayList<>();

            result.addAll(list1);
            result.addAll(list2);

            return result;
        });
    }
}

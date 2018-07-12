package unit2_stream.ex3;

import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        /*
        int [] values = { 1, 4, 9, 16 } 배열이 있다고 하자.
        Stream.of(values)의 결과는 무엇인가?
        int stream 은 어떻게 얻을 수 있는가?
         */
        int[] values = {1, 4, 9, 16};
        Integer[] value = {1, 4, 9, 16};

        Stream<int[]> myStream = Stream.of(values);
        Stream<Integer> stream = Stream.of(value);

        IntStream myStream2 = IntStream.of(values);

        myStream2.forEach(System.out::println);
        stream.forEach(System.out::println);
    }
}

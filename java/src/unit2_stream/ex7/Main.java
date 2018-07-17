package unit2_stream.ex7;

import java.util.Arrays;
import java.util.stream.Stream;

public class Main {
    /*
    public static <T> Stream<T> zip(Stream<T> first, Stream<T> second) 메서드를 작성하라.
    메서드는 first 와 second 스트림의 요소들을 교환하며,
    두 스트림중 하나에서 요소가 바닥이 나면 작업을 중단한다.
     */
    static Stream firstStream;
    static Stream secondSteam;

    public static void main(String[] args) {
        String[] A = {"a1", "a2", "a3", "a4", "a5"};
        String[] B = {"b1", "b2", "b3", "b4", "b5", "b6"};

        firstStream = Stream.of(A);
        secondSteam = Stream.of(B);

        zip(firstStream, secondSteam);

        firstStream.forEach(System.out::println);
        System.out.println();
        secondSteam.forEach(System.out::println);
    }

    static <T> void zip(Stream<T> first, Stream<T> second) {
        Object[] f = first.toArray();
        Object[] s = second.toArray();
        int swapCount;
        if(f.length < s.length) {
            swapCount = f.length;
        } else {
            swapCount = s.length;
        }
        for(int i=0; i<swapCount; i++) {
            Object tmp = f[i];
            f[i] = s[i];
            s[i] = tmp;
        }
        firstStream = Arrays.stream(f);
        secondSteam = Arrays.stream(s);
    }
}

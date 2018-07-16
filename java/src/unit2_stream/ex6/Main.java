package unit2_stream.ex6;

import java.util.ArrayList;
import java.util.stream.Stream;

public class Main {
    /*
        단일 ArrayList를 스트림의 크기로 생성했다면, 여러 ArrayList를 병합하는 대신
        단일 리스트 안에 스트림 결과들을 동시에 모을 수 있어야 한다.
        이는 떨어진 위치에서 병행 set 연산은 스레드에 안전하기 때문이다.
        이 작업을 어떻게 할 수 있는가?
    */
    public static void main(String[] args) {
        ArrayList<Integer> result = new ArrayList<>();

        Stream<Integer> stream1 = Stream.of(50, 40, 60);
        Stream<Integer> stream2 = Stream.of(70, 80, 90);
        Stream<Integer> stream3 = Stream.of(80, 90, 100);

        Stream resultStream = Stream.concat(stream1, Stream.concat(stream2, stream3));

        resultStream.forEach(System.out::println);
    }
}

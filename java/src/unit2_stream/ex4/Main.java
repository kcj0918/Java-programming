package unit2_stream.ex4;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Main {
    /*
    44페이지에 있는 "2.3 filter, map, flatMap 메서드" 절의 characterStream 메서드는
    먼저 ArrayList 를 채운 후 스트림으로 변환하기 때문에 약간은 세련되지 못했다.
    스트림에 기반을 둔 한 행짜리 메서드로 작성하라.
    한 가지 접근법은 0 ~ s.length() - 1 범위에서 정수 스트림을 만들어서
    메서드 레퍼런스에 맵핑하는 것이다.
     */
    public static void main(String[] args) {
//        characterStream("beat").forEach(System.out::println);
//        newCharacterStream("boat").forEach(System.out::println);
        secondCharacterStream("boeat").forEach(System.out::println);
    }
    static Stream<Character> characterStream(String s) {
        List<Character> result = new ArrayList<>();
        for(char c : s.toCharArray()) result.add(c);
        return result.stream();
    }
    static Stream<Character> newCharacterStream(String s) {
        return s.chars().mapToObj(i -> (char)i);
    }
    static Stream<Character> secondCharacterStream(String s) {
        //range rangeClosed difference :
        //range : methods is last value not contain. (0<= range < s.length)
        //rangeClosed : methods is last value contain. (0 <= range <= s.length)
        IntStream myStream = IntStream.range(0,s.length());
        IntStream myStream2 = IntStream.rangeClosed(0,s.length()-1);

        return myStream.mapToObj(s::charAt);
    }
}

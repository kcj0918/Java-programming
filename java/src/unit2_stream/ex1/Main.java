package unit2_stream.ex1;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        /*
        처음 5개의 긴 단어를 요청했을 때 긴 단어를 5번째 발견하고 나면
        filter메서드를 호출하지 않음을 확인하라.
        간단하게 각 메서드 호출을 기억하라
         */
        String[] array = {"abcdefghijklmn",
                "as8r5ds98r8tsss",
                "dfsdfsdfsdfe",
                "4444",
                "333",
                "55555",
                "666666",
                "7777777",
                "88888888",
                "22",
                "1",
                "999999999999999999999",
                "aaaaaaaaaaaaaaaaaaaaaaaaaa"};

        Arrays.stream(array).filter(w -> w.length() > 6).peek(System.out::println).limit(5).count();
        System.out.println(array.length);
    }
}

package unit2_stream.ex2;

import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        /*
        stream 대신 parallelStream 을 이용해 긴 단어 개수를 셀 때 차이를 측정하라.
        각 호출 이전과 이후에 System.currentTimeMillis 를 호출하고 차이를 출력한다.
        빠른 컴퓨터를 보유하고 있다면 더 큰 문서로 바꿔서 측정한다.
         */
        String[] myArray = {"abcdefghijklmn",
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
        Stream<String> myStream = Stream.of(myArray);
        Stream<String> myStream2 = Stream.of(myArray);

        long startTime1 = System.currentTimeMillis();
        myStream.filter(w -> w.length() > 6).limit(5).count();
        long endTime1 = System.currentTimeMillis();


        long startTime2 = System.currentTimeMillis();
        myStream2.parallel().filter(w -> w.length() > 6).limit(5).count();
        long endTime2 = System.currentTimeMillis();

        System.out.println("##  time1 : " + (endTime1 - startTime1) / 1000.0f + "초");
        System.out.println("##  time2 : " + (endTime2 - startTime2) / 1000.0f + "초");
    }
}

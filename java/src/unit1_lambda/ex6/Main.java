package unit1_lambda.ex6;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        /*
        람다 표현식이 다음과 같은
        향상된 for 루프에 있는 변수를 캡처할 때 무슨 일이 일어나는가?

        String[] names = {"Peter", "Paul", "Mary"};
        List<Runnable> runners = new ArrayList<>();
        for(String name : names) {
            runners.add(() -> System.out.println(name));
        }

        규칙에 맞는 작업인가? 각 람다 표현식이 다른 값을 캡처하는가, 아니면 모두 마지막 값을 얻는가?
        만일 전통적인 루프인 for(int i=0; i < names.length; i++)를 사용하면 무슨 일이 일어나는가?
         */
        String[] names = {"Peter", "Paul", "Mary"};

        List<Runnable> runners = new ArrayList<>();
        List<Runnable> runners2 = new ArrayList<>();


        for(String name : names) {
            runners.add(() -> System.out.println(name));
        }

        for(Runnable name : runners) {
            name.run();
        }


//        for(int i=0; i < names.length; i++) {
//            runners2.add(()-> System.out.println(names[i]));
//        }
    }
}

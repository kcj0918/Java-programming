package unit1_lambda.ex5;

public class Main {
    public static void main(String[] args) {
        /*
        Runnable 인스턴스 두 개를 파라미터로 받고 첫 번째 인스턴스를 실행한 후
        두 번째를 실행하는 Runnable 을 리턴하는 andThen 정적 메서드 작성.
        main 메서드에서 andThen 호출에 람다 표현식 두 개를 전달하고, 결과로 받은 인스턴스를 실행하라.
         */
        MyRunnable r1 = new MyRunnable("first");
        MyRunnable r2 = new MyRunnable("second");

//        Runnable a = () -> {System.out.println("first");};
//        Runnable a2 = () -> {System.out.println("second");};

        Runnable result = andThen(r1,r2);
        result.run();

        //andThen(r1,r2).run();

    }
    public static Runnable andThen(MyRunnable r1,MyRunnable r2) {
        r1.run();
        return r2;
        /*Runnable result = funcInterface.andThen(() -> )
        return result;*/
    }
}

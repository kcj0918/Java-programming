package unit1_lambda.ex4;

public class Main {
    public static void main(String[] args) throws Exception {
        /*
        Runnable 에서 검사 예외를 다뤄야 하는 점이 싫지 않은가?
        모든 검사 예외를 잡아내서 비검사 예외로 바꾸는
        uncheck method 작성해라. 예를 들면 다음과 같다.
        new Thread(uncheck(
            () -> { System.out.println("Zzz"); Thread.sleep(1000); })).start();
            //여길 보자 catch(InterruptException) 부분이 없다.
        힌트 : run 메서드에서 모든 예외를 던질 수 있는 RunnableEx 인터페이스를 정의한다.
        다음으로 public static Runnable uncheck(RunnableEx runner) 구현.
        uncheck 함수 안에서 람다 표현식을 사용한다.
        RunnableEx 대신 단순히 Callable<void>를 사용할 수 없는 이유는 무엇인가?
        */
        new Thread(uncheck(
                () -> {
                    System.out.println("Zzz");
                    Thread.sleep(1000);
                })).start();
    }

    public static Runnable uncheck(RunnableEx runner) throws Exception {
        runner.apply();
        return null;
    }
}

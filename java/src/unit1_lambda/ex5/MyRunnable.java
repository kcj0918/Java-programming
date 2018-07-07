package unit1_lambda.ex5;

public class MyRunnable implements Runnable {
    String s;
    public MyRunnable(String s) {
        this.s = s;
    }

    @Override
    public void run() {
        System.out.println(s + " runnable");
    }
}

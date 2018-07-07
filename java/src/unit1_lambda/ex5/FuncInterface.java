package unit1_lambda.ex5;

@FunctionalInterface
public interface FuncInterface {
    Runnable andThen(Runnable a, Runnable b);
}
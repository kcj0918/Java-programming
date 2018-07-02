package unit1_lambda.ex1;


import java.io.File;
import java.util.ArrayList;

public interface FileFunc {
    ArrayList<String> apply(File rootFile, ArrayList<String> resultFiles);
}

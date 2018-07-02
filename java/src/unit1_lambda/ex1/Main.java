package unit1_lambda.ex1;

import java.io.File;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        /*
        Java.io.File 클래스의 listFiles(FileFilter)와 isDirectory 메서드를 이용해 주어진
        디렉터리의 모든 서브디렉터리를 리턴하는 메서드를 작성하라. FileFilter 객체 대신 람다 표현식을 사용하라.
        메서드 표현식을 이용해 같은 작업을 반복하라.
         */

        String source = "C:\\spring_project\\Directory";
        File f = new File(source);
        ArrayList<String> resultFiles = new ArrayList<String>();

        FileFunc r = Main::findSubFiles;

        ArrayList<String> result = r.apply(f, resultFiles);
        //ArrayList<String> result = findSubFiles(f, resultFiles);
        for (String fileName : result) {
            System.out.println(fileName);
        }
    }

    public static ArrayList<String> findSubFiles(File rootFile, ArrayList<String> resultFiles) {
        File[] resultDirectory = rootFile.listFiles((rd) -> rd.isDirectory());
        for (File file : resultDirectory) {
            if (file.isDirectory()) {
                resultFiles.add(file.getPath());
                findSubFiles(file, resultFiles);
            }
        }
        return resultFiles;
    }
}

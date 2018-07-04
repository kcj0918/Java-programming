package unit1_lambda.ex3;

import java.io.File;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        /*
        java.io.File 클래스의 list(filenameFilter) 메서드를 이용해 주어진 디렉터리에서
        주어진 확장자를 지닌 모든 파일을 리턴하는 메서드를 작성하라. FilenameFilter 아닌 람다 표현식을 사용하라.
        이 람다 표현식이 자신을 감싸는 유효 범위에 있는 어느 변수를 캡처하는가?
        */
        String source = "C:\\spring_project\\Directory";
        String extension = ".txt";
        ArrayList<String> resultFileName = new ArrayList<>();
        resultFileName = checkFile(source, resultFileName, extension);
        for (String name : resultFileName) {
            System.out.println(name);
        }
    }

    public static ArrayList<String> checkFile(String source, ArrayList<String> resultFileName, String extension) {
        File rootFile = new File(source);
        File[] directoryList = rootFile.listFiles(dir -> dir.isDirectory());
        File[] fileList = rootFile.listFiles((dir, name) -> name.toLowerCase().endsWith(extension));
        if (directoryList != null) {
            for (File files : directoryList) {
                checkFile(files.getPath(), resultFileName, extension);
            }
        }
        if (fileList != null) {
            isFileProcess(fileList, resultFileName);
        }
        return resultFileName;
    }

    public static void isFileProcess(File[] fileList, ArrayList<String> resultFileName) {
        for (File txtFile : fileList) {
            resultFileName.add(txtFile.getName());
        }
    }
}

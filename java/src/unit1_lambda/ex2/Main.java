package unit1_lambda.ex2;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;

public class Main {
    public static void main(String[] args) {
        /*
        File 객체 배열이 주어졌을 때, 디렉터리가 파일보다 앞에 위치하고
        각 그룹 안에서 요소들이 경로 이름에 따라 정렬되도록 정렬하라.
        Comparator 가 아닌 람다 표현식을 사용하라.
         */
        String source = "C:\\spring_project\\Directory";
        ArrayList<FileInfo> resultDirectorys = new ArrayList<>();
        ArrayList<FileInfo> resultFiles = new ArrayList<>();

        resultDirectorys = isDirectoryProcess(source, resultDirectorys);
        System.out.println("-----------DirectoryList------------");
        for (FileInfo fileInfo : resultDirectorys) {
            System.out.println(fileInfo.fileName);
        }
        System.out.println();
        System.out.println("-----------FileList------------");
        resultFiles = isFileProcess(source, resultFiles);

        Collections.sort(resultFiles, (o1, o2) -> {
            if (o1.getFileParentPath().equals(o2.getFileParentPath())) {
                return o1.getFileName().compareTo(o2.getFileName());
            } else {
                return o1.getFileParentPath().compareTo(o2.getFileParentPath());
            }
        });
        for (FileInfo fileInfo : resultFiles) {
            System.out.println(fileInfo.filePath);
        }
    }

    public static ArrayList<FileInfo> isDirectoryProcess(String source, ArrayList<FileInfo> resultDirectory) {
        File rootFIle = new File(source);
        File[] directoryList = rootFIle.listFiles(dir -> dir.isDirectory());
        for (File dir : directoryList) {

            resultDirectory.add(new FileInfo(dir.getName(), dir.getAbsolutePath()));
            isDirectoryProcess(dir.getPath(), resultDirectory);
        }
        return resultDirectory;
    }

    public static ArrayList<FileInfo> isFileProcess(String source, ArrayList<FileInfo> resultFile) {
        File rootFile = new File(source);
        File[] directoryList = rootFile.listFiles(dir -> dir.isDirectory());
        File[] fileList = rootFile.listFiles(dir -> dir.isFile());
        if (directoryList != null) {
            for (File file : directoryList) {
                isFileProcess(file.getPath(), resultFile);
            }
        }
        if (fileList != null) {
            for (File file : fileList) {
                System.out.println("parent "+file.getParent());
                resultFile.add(new FileInfo(file.getName(), file.getParent(), file.getPath()));
            }
        }
        return resultFile;
    }
}

package unit1_lambda.ex2;

public class FileInfo {
    String fileName;
    String fileParentPath;
    String filePath;

    public FileInfo(String fileName, String fileParentPath, String filePath) {
        this.fileName = fileName;
        this.fileParentPath = fileParentPath;
        this.filePath = filePath;
    }
    public FileInfo(String fileName, String filePath) {
        this.fileName = fileName;
        this.filePath = filePath;
    }

    public String getFileName() {
        return fileName;
    }

    public String getFileParentPath() {
        return fileParentPath;
    }
}

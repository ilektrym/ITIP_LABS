import java.io.*;

public class FileCopy {
    public static void main(String[] args) {
        String sourceFileName = "source.txt";
        String targetFileName = "target.txt";

        try (FileInputStream in = new FileInputStream(sourceFileName);
             FileOutputStream out = new FileOutputStream(targetFileName)) {
            byte[] buffer = new byte[1024];
            //in.close();
            //out.close();
            int length;
            while ((length = in.read(buffer)) > 0) {
                out.write(buffer, 0, length);
            }
            System.out.println("Файл скопирован");
        } catch (IOException e) {
            System.out.println("Ошибка при чтении/записи файла: " + e.getMessage());
        }
    }
}
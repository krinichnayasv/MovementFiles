import java.io.IOException;
import java.nio.file.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {

        // C:/Света/sony/Сбербанк
        // C:/Света/sony/Новая папка


        FileUtils fileUtils = new FileUtils();
        System.out.println("Введите копируемую папку:");
        Scanner scanner = new Scanner(System.in);
        String path1 = scanner.nextLine();
        System.out.println("Введите путь куда копируем:");
        String path2 = scanner.nextLine();
      //  fileUtils.getChange(path1);


        try {
           fileUtils.copyFolder(path1, path2);
        } catch (Exception ex) {
            ex.getStackTrace();
        }


    }
}

import java.io.IOException;
import java.nio.file.*;

public class FileUtils {

    public static String change;

    public FileUtils () {

    }

    public static String getChange (String sourceDirectory) {
        Path path = Path.of(sourceDirectory);
        change = path.getParent().toString();
        return change;
    }

    public static void copyFolder(String sourceDirectory, String destinationDirectory) throws IOException {
        // TODO: write code copy content of sourceDirectory to destinationDirectory

        Path paths = Path.of(sourceDirectory);
        String change = paths.getParent().toString();

        Files.walk(Paths.get(sourceDirectory))
                .forEach(source -> {
                    // так верно!
                    // Path destination = Paths.get(destinationDirectory,source.toString().replace(change,""));
                    // для теста:
                Path destination = Paths.get(destinationDirectory,source.toString().substring(sourceDirectory.length()));
                    System.out.println(destination);
                    try {
                        Files.copy(source, destination, StandardCopyOption.REPLACE_EXISTING);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                });

        // или с переменной change

//        Path paths = Path.of(sourceDirectory);
//        String destDir = Path.of(destinationDirectory).toString();
//        String dir = Path.of(destinationDirectory).toString().concat(paths.toString().replace(change,""));
//        try {        Files.createDirectory(Path.of(dir)); }
//        catch (Exception ex) {ex.getStackTrace();}
//        try (DirectoryStream< Path > files = Files.newDirectoryStream(paths)) {
//            for (Path p : files) {
//                 if (Files.isDirectory(p)) {
//                    copyFolder(p.toString(), destinationDirectory);
//                } else if (Files.isRegularFile(p)) {
//                    String dst = p.toString().replace(change, destDir);
//                    Files.copy(Path.of(p.toString()), Path.of(dst), StandardCopyOption.REPLACE_EXISTING);
//                }
//            }
//        }   catch (Exception ex) {ex.getStackTrace();}



    }

}

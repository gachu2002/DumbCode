package readability;


import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

class ReadFile {
    public static String readFileAsString(String fileName) throws IOException {
        return new String(Files.readAllBytes(Paths.get(fileName)));
    }
}

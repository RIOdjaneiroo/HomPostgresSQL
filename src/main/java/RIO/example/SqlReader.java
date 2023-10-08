package RIO.example;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class SqlReader {
    public StringBuffer readSqlFromFile(String filePath) {
        StringBuffer sqlBuffer = new StringBuffer();

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                sqlBuffer.append(line).append("\n");
            }
        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
        }

        return sqlBuffer;
    }
}


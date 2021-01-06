import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class Main {
    static JsonReader reader = new JsonReader();
    static Output output = new Output();
    static Map<String, List<Integer>> result;

    public static void main(String[] args) throws IOException {
        result = reader.sumData("C:\\source_archive\\source01.csv",
                "C:\\source_archive\\source02.csv",
                "C:\\source_archive\\source03.csv"); // Ввод путей до файлов с данными, количество может быть любым
        output.printTypeOne(result);
        output.printTypeTwo(result);
        output.printTypeThree(result);
        return;
    }
}

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class JsonReader {

    // Метод "умного" добавления метки в мапу
    HashMap<String,List<Integer>> addPair (HashMap<String,List<Integer>> map, String key, Integer value) {
        key = key.toLowerCase();
        if (map.containsKey(key)){
            map.get(key).add(value);
        }
        else {
            List<Integer> valueList = new ArrayList<>();
            valueList.add(value);
            map.put(key, valueList);
        }

        return map;
    }

    // Метод получения данных из файла, переданного в метод
    private HashMap<String, List<Integer>> getInfo(String fileInput) {
        HashMap<String, List<Integer>> result = new HashMap<>();
        System.out.println("Открытие файла " + fileInput);
        try (BufferedReader br = new BufferedReader(new FileReader(fileInput))) {
            System.out.println("Чтение файла " + fileInput);
            String line;
            while ((line = br.readLine()) != null) {
                if (line.charAt(0) == '#'){
                    System.out.println("Комментарий: " + line);
                }
                else {
                    String[] values = line.split(",");
                    List<String> pair= Arrays.asList(values);
                    String keyPair = pair.get(0); Integer valuePair = Integer.parseInt(pair.get(1));
                    result = addPair(result, keyPair, valuePair);
                }
            }
            System.out.println("Анализ файла " + fileInput + " завершен");
            System.out.println();
        } catch (FileNotFoundException e) {
            System.out.println("Файл не был найден");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }

    // Метод формирования результата
    public HashMap<String,List<Integer>> sumData(String... fileName){
        HashMap<String,List<Integer>> summary = new HashMap<>();
        for (String name:fileName) {

            Map<String,List<Integer>> nameData= getInfo(name);
            for (Map.Entry<String, List<Integer>> el : nameData.entrySet())
                for (Integer i:el.getValue())
                    summary = addPair(summary, el.getKey(), i);
        }
        return summary;
    }
}


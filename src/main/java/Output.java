import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class Output {
    public static final List<String> LABELS_LIST = Arrays.asList("mark01", "mark17", "mark23", "mark35", "markFV", "markFT", "markFX");

    private String existsInLabels(String key){
        for (String label : LABELS_LIST)
            if (label.toLowerCase().equals(key))
                return label;
        return key;
    }

    // Вывод трех вариантов отчета в три различных файла, после формирования отчета выходит соответсвующее сообщение

    void printTypeOne(Map<String, List<Integer>> result) throws IOException {
        Map<String, Integer> outputList = new HashMap<>();
        for (Map.Entry<String, List<Integer>> element : result.entrySet()) {
            int sum = 0;
            for (Integer i : element.getValue())
                sum += i;
            outputList.put(element.getKey(), sum);
        }
        String out = "{"; // Начало формирования Json строки типа 1
        for (Map.Entry<String, Integer> element : outputList.entrySet()) {
            out += "\"" + existsInLabels(element.getKey()) + "\":" + element.getValue() + ",";
        }
        out = out.substring(0,out.length()-1) + "}";
        String fileOutput = "result01.json";
        FileWriter writer = new FileWriter(fileOutput, false);
        writer.write(out); // Конец формирования Json строки, вывод
        writer.flush();
        System.out.println("Итоговый отчет в форме 1 записан в файл " + fileOutput);
    }

    void printTypeTwo(Map<String, List<Integer>> result) throws IOException {
        Map<String, Integer> outputList = new HashMap<>();
        for (Map.Entry<String, List<Integer>> element : result.entrySet()) {
            int sum = 0;
            for (Integer i : element.getValue())
                sum += i;
            outputList.put(element.getKey(), sum);
        }
        String out = "{"; // Начало формирования Json строки типа 2
        for (String label: LABELS_LIST) {
            out += "\"" + label + "\":";
            if (outputList.containsKey(label.toLowerCase()))
                out += outputList.get(label.toLowerCase()) + ",";
            else
                out += "null,";
        }
        out = out.substring(0,out.length()-1) + "}";
        String fileOutput = "result02.json";
        FileWriter writer = new FileWriter(fileOutput, false);
        writer.write(out); // Конец формирования Json строки, вывод
        writer.flush();
        System.out.println("Итоговый отчет в форме 2 записан в файл " + fileOutput);
    }

    void printTypeThree(Map<String, List<Integer>> result) throws IOException {
        String out = "{";// Начало формирования Json строки типа 3
        for (Map.Entry<String, List<Integer>> element : result.entrySet()) {
            out += "\"" + existsInLabels(element.getKey()) + "\":[";
            Collections.sort(element.getValue());
            for (int i = element.getValue().size() - 1; i > 0 ; i--)
                out += element.getValue().get(i) + " ";
            out = out.substring(0,out.length() - 1) + "],";
        }
        out = out.substring(0, out.length() - 1) + "}";
        String fileOutput = "result03.json";
        FileWriter writer = new FileWriter(fileOutput, false);
        writer.write(out); // Конец формирования Json строки, вывод
        writer.flush();
        System.out.println("Итоговый отчет в форме 3 записан в файл " + fileOutput);
    }

}


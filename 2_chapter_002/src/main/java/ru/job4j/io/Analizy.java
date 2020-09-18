package ru.job4j.io;

import java.io.*;

/**
 * Класс предназначен для преобразования одного файла в другой.
 */
public class Analizy {
    /**
     * Метод определяющий период, когда сервер не работал.
     *
     * @param source файл лога
     * @param target файл после анализа
     */
    public void unavailable(String source, String target) {
        try (BufferedReader br = new BufferedReader(new FileReader(source));
             BufferedWriter writer = new BufferedWriter(new FileWriter(target))) {
            String start = null;
            boolean outCycle = true;
            while (br.ready()) {
                String line = br.readLine();
                if ((line.startsWith("400") || line.startsWith("500")) && outCycle) {
                    writer.write(line.split(" ")[1] + ";");
                    outCycle = false;
                } else if ((!line.startsWith("400") && !line.startsWith("500")) && !outCycle) {
                    writer.write(line.split(" ")[1]);
                    writer.newLine();
                    outCycle = true;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

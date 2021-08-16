package ru.job4j.io;

import java.io.*;

/**
 * Задание.
 * 1. Реализуйте метод unavailable, где "source" - имя файла лога, "target" - имя файла после анализа.
 * <p>
 * 2. Метод "unavailable" должен находить диапазоны, когда сервер не работал.
 * Сервер не работал, если статус 400 или 500.
 * Диапазон считается последовательность статусов 400 и 500
 * Например:
 * 200 10:56:01
 * 500 10:57:01
 * 400 10:58:01
 * 200 10:59:01
 * 500 11:01:02
 * 200 11:02:02
 * тут два периода - 10:57:01 до 10:59:01 и 11:01:02 до 11:02:02
 * Начальное время - это время когда статус 400 или 500,
 * конечное время это когда статус меняется с 400 или 500 на 200 или 300.
 * <p>
 * 3. Результат анализа нужно записать в файл target.
 * Формат файла: начало периода; конец периода;
 * <p>
 * 4. Записать тесты.
 */
public class Analysis {

    public static final String CLIENT_ERROR = "400";
    public static final String SERVER_ERROR = "500";

    /**
     * Найти период времени, когда сервер не работал.
     * Сервер не работал, если status 400, 500.
     *
     * @param source файл с исходными данными
     * @param target файл с обработанными данными
     */
    public void unavailable(String source, String target) {
        try (var in = new BufferedReader(new FileReader(source));
             var out = new BufferedWriter(new FileWriter(target))) {
            boolean trigger = true;
            while (in.ready()) {
                String line = in.readLine();
                if (trigger && (line.startsWith(CLIENT_ERROR) || line.startsWith(SERVER_ERROR))) {
                    out.write(line.split("\\s")[1] + ";");
                    trigger = false;
                } else if (!trigger && (!line.startsWith(CLIENT_ERROR) && !line.startsWith(SERVER_ERROR))) {
                    out.write(line.split(" ")[1]);
                    out.newLine();
                    trigger = true;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Записать события в файл.
     */
    public static void outPrintlnFile(String pathSource) {
        try (var out = new PrintWriter(new FileOutputStream(pathSource))) {
            out.println("200 10:56:01");
            out.println("500 10:57:01");
            out.println("400 10:58:01");
            out.println("200 10:59:01");
            out.println("500 11:01:02");
            out.println("200 11:02:02");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

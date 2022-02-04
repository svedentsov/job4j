package ru.job4j.filedownloader;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;

/**
 * Нужно написать консольную программу аналог wget.
 * <p>
 * Программа должна скачивать файл из сети с ограничением по скорости скачки.
 * например wget url 200
 * wget (ссылка) (скорость в килобайтах в секунту)
 * для того. чтобы ограничить скорость скачки нужно проверять сколько загрузилось за 1 секунду. если объем больше. то нужно выставлять паузу.
 * Для скачивания файлу используйте HttpConnection.java.
 */
public class HttpDownloader implements Runnable {

    private String url;
    private String target;
    private int speedKbSec;

    public static void main(String[] args) {
        String url = "https://docs.oracle.com/en/java/javase/13/core/java-core-libraries-developer-guide.pdf";
        int speed = 256;
        String target = System.getProperty("java.io.tmpdir")
                + System.getProperty("file.separator")
                + "test.pdf";

        HttpDownloader wget = new HttpDownloader(url, target, speed);
        new Thread(wget).start();
    }

    public HttpDownloader(String url, String target, int speedKbSec) {
        this.url = url;
        this.target = target;
        this.speedKbSec = speedKbSec;
    }

    @Override
    public void run() {
        try {
            URL urlObj = new URL(url);
            HttpURLConnection httpCon = (HttpURLConnection) urlObj.openConnection();
            int responseCode = httpCon.getResponseCode();

            if (responseCode == HttpURLConnection.HTTP_OK) {
                InputStream inputStream = httpCon.getInputStream();
                BufferedInputStream reader = new BufferedInputStream(inputStream);

                BufferedOutputStream writer = new BufferedOutputStream(new FileOutputStream(target));

                byte[] buffer = new byte[speedKbSec * 1024];
                int bytesRead = -1;
                long start = System.nanoTime();
                long mark = System.nanoTime();

                while ((bytesRead = reader.read(buffer)) != -1) {

                    writer.write(buffer, 0, bytesRead);

                    long iterationTime = (System.nanoTime() - mark) / 1000L;
                    long pause = 1000L - iterationTime;
                    if (1000L - iterationTime > 0) {
                        try {
                            Thread.currentThread().sleep(pause);
                            System.out.println(String.format("pause %d ms", pause));
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    mark = System.nanoTime();

                }
                writer.close();
                reader.close();

                long endTime = System.nanoTime();

                long allTime = (endTime - start) / (1000000);  // sec
                long size = Files.size(Path.of(target)) / 1024;
                long averageSpeed = (size * 1000) / allTime;

                System.out.println("File saved.");

                System.out.println(String.format("Downloading time %d ms", allTime));
                System.out.println(String.format("File size %d Kb", size));
                System.out.println(String.format("Average downloading speed %d Kb/sec", averageSpeed));

            } else {
                System.out.println("Server returned response code " + responseCode + ". Download failed.");
            }

        } catch (IOException e) {
            System.out.println("An I/O error occurs: " + e.getMessage());
        }
    }
}

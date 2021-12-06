package ru.job4j.solid.ocp.worker.converter;

import com.google.gson.Gson;
import ru.job4j.solid.ocp.worker.Worker;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class ToJSON implements Converter {

    private Gson gson;

    public ToJSON() {
        this.gson = new Gson();
    }

    public void save(List<Worker> list, File target) throws IOException {
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(target))) {
            list.forEach(worker -> {
                try {
                    bufferedWriter.write(this.gson.toJson(worker));
                    bufferedWriter.newLine();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });
        }
    }


    public void show(List<Worker> list) {
        list.forEach(worker -> {
            System.out.println(this.gson.toJson(worker));
        });
    }

    @Override
    public String toString() {
        return "JSON";
    }
}

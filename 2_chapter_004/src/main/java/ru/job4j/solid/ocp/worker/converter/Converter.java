package ru.job4j.solid.ocp.worker.converter;

import ru.job4j.solid.ocp.worker.Worker;

import java.io.File;
import java.util.List;

public interface Converter {

    /**
     * Method save. Генерация из значений полей объектов в файл target.
     *
     * @param list лист объектов Worker
     */
    void save(List<Worker> list, File target) throws Exception;

    /**
     * Method show. ПВывести на консоль в формате JSON значения полей объектов.
     *
     * @param list лист объектов Worker
     */
    void show(List<Worker> list) throws Exception;
}

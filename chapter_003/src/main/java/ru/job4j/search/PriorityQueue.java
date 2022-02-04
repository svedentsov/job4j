package ru.job4j.search;

import java.util.LinkedList;
import java.util.List;

public class PriorityQueue {
    private List<Task> tasks = new LinkedList<>();
    /**
     * Метод должен вставлять в нужную позицию элемент.
     * Позиция определять по полю приоритет.
     * Для вставки использовать add(int index, E value)
     *
     * @param task задача
     */
    public void put(Task task) {
        var i = 0;
        for (var element : tasks) {
            if (element.getPriority() > task.getPriority()) {
                break;
            }
            i++;
        }
        this.tasks.add(i, task);
    }

    public Task take() {
        return tasks.remove(0);
    }
}

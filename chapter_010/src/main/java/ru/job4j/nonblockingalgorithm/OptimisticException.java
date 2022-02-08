package ru.job4j.nonblockingalgorithm;

public class OptimisticException extends RuntimeException {

    private int version;

    public OptimisticException(String message) {
        System.out.println(message);
    }
}

package ru.job4j.nonblockingalgorithm;

public class Base {

    private int id;
    private volatile int version;

    public Base(int id, int version) {
        this.id = id;
        this.version = version;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }

    @Override
    public String toString() {
        return "Base{" + "id=" + id + ", version=" + version + '}';
    }
}

package ru.job4j.gc;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import static com.carrotsearch.sizeof.RamUsageEstimator.sizeOf;

/**
 * VM options -Xmx8m
 * размер кучи устанавливаем 8MB
 * <p>
 * Далее поочередно устанавливаем параметры для выполнения класса с соответствующим GC:
 * -XX:+UseConcMarkSweepGC
 * -XX:+UseSerialGC
 * -XX:+UseParallelGC
 * -XX:+UseG1GC
 * и наблюдаем сборки мусора и время потраченное на работу GC.
 */
public class MemoryUsage {

    private static final Logger LOG = LogManager.getLogger(MemoryUsage.class.getName());

    public static class User {
        public String name;

        public User(String name) {
            this.name = name;
        }

        @Override
        protected void finalize() throws Throwable {
            super.finalize();
            System.out.println(String.format("finalize: destroy object %s", this));
        }

        @Override
        public String toString() {
            return "User{"
                    + "name='"
                    + name
                    + '\''
                    + '}';
        }
    }

    public static class EmptyUser {
    }

    public static void main(String[] args) {
        System.out.println(String.format("empty object size %s B", sizeOf(new EmptyUser())));
        System.out.println(String.format("String \"name\" size %s B", sizeOf(new String("name"))));
        System.out.println(String.format("user size %s B", sizeOf(new User("name"))));

        System.out.println("start");
        info();

        for (int i = 1; i < 1_000_000; i++) {
            User user = new User("u " + i);
            Runtime runtime = Runtime.getRuntime();
            System.out.println(String.format(
                    "Used memory %s B. Average user%s size %s B.",
                    (runtime.totalMemory() - runtime.freeMemory()),
                    i,
                    (runtime.totalMemory() - runtime.freeMemory()) / i)
            );

            System.out.println(String.format("estimated object size %s", sizeOf(user)));
            user = null;
        }
    }

    /**
     * Выдает статистику использования кучи.
     */
    protected static void info() {
        int kb = 1024;

        // Ссылка на среду выполнения из системы.
        // Позволяет получать необходимую информацию об использовании JVM памяти.
        Runtime runtime = Runtime.getRuntime();

        System.out.println("Heap utilization statistics [KB]");

        System.out.println("Used memory:"
                + (runtime.totalMemory() - runtime.freeMemory()) / kb
        );

        System.out.println(
                "Free memory:"
                        + runtime.freeMemory() / kb
        );

        // Всего доступно памяти.
        System.out.println(
                "Total memory:"
                        + runtime.totalMemory() / kb
        );

        // Максимальный объем памяти используемой JVM.
        System.out.println(
                "Max memory:"
                        + runtime.maxMemory() / kb
        );
    }
}

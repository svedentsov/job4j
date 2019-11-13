package ru.job4j.poly;

/**
 * Интерфейс Transport.
 *
 * @author Igor Svedentsov (svedensov@gmail.com)
 * @version $Id$
 * @since 0.1
 */
public interface Transport {
    void drive();

    void passengers(int count);

    double refuel(int gas);
}

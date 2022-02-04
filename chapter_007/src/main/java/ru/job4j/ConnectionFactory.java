package ru.job4j;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * Represents functional interface to get new connection to DB.
 */
@FunctionalInterface
public interface ConnectionFactory {
    Connection getConnection() throws SQLException;
}

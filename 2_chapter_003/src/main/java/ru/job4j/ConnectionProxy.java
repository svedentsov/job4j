package ru.job4j;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * Represents functional interface to wrap submitted connection objects
 */
@FunctionalInterface
public interface ConnectionProxy {
    Connection proxy(Connection connection) throws SQLException;
}

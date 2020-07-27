package ru.job4j.tictactoe;

import java.util.Arrays;
import java.util.function.Predicate;

/**
 * Класс Logic3T - отвечает за проверку логики.
 */
public class Logic3T {
    /**
     * Поле для игры.
     */
    private final Figure3T[][] table;

    /**
     * Конструктор класса.
     *
     * @param table поле для игры
     */
    public Logic3T(Figure3T[][] table) {
        this.table = table;
    }

    /**
     * Универсальный метод ля проверки ячейки.
     *
     * @param predicate интерфейс Predicate.
     * @param startX    начальная точка по оси Х.
     * @param startY    начальная точка по оси Y.
     * @param deltaX    направление движения по оси X.
     * @param deltaY    направление движения по оси Y.
     * @return true, если ячейки содержат одинаковую фигуру, иначе - false.
     */
    public boolean fillBy(Predicate<Figure3T> predicate, int startX, int startY, int deltaX, int deltaY) {
        boolean result = true;
        for (int index = 0; index != this.table.length; index++) {
            Figure3T cell = this.table[startX][startY];
            startX += deltaX;
            startY += deltaY;
            if (!predicate.test(cell)) {
                result = false;
                break;
            }
        }
        return result;
    }

    /**
     * Проверить победил ли "X".
     *
     * @return true, если побудил О, иначе - false.
     */
    public boolean isWinnerX() {
        return isWinner(Figure3T::hasMarkX);
    }

    /**
     * Проверить победил ли "О".
     *
     * @return true, если побудил О, иначе - false.
     */
    public boolean isWinnerO() {
        return isWinner(Figure3T::hasMarkO);
    }

    public boolean isWinner(Predicate<Figure3T> hasMark) {
        return this.fillBy(hasMark, 0, 0, 1, 0)
                || this.fillBy(hasMark, 0, 1, 1, 0)
                || this.fillBy(hasMark, 0, 2, 1, 0)
                || this.fillBy(hasMark, 0, 0, 0, 1)
                || this.fillBy(hasMark, 1, 0, 0, 1)
                || this.fillBy(hasMark, 2, 0, 0, 1)
                || this.fillBy(hasMark, 0, 0, 1, 1)
                || this.fillBy(hasMark, this.table.length - 1, 0, -1, 1);
    }

    /**
     * Проверить есть ли пустые клетки.
     *
     * @return true, если есть ходы, иначе - false.
     */
    public boolean hasGap() {
        return Arrays.stream(this.table)
                .flatMap(Arrays::stream)
                .anyMatch(cell -> !cell.hasMarkX() && !cell.hasMarkO());
    }
}

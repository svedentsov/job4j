package ru.job4j.array;

/**
 * @author Igor Svedentsov (svedensov@gmail.com)
 * @version $Id$
 * @since 0.1
 */
public class MatrixCheck {
    /**
     * Проверка все ли элементы по диагонали равны true или false.
     *
     * @param data проверяемая таблица
     * @return
     */
    public boolean mono(boolean[][] data) {
        boolean result = true;
        for (int i = 0; i < data.length; i++) {
            if (data[0][0] != data[i][i]) {
                result = false;
                break;
            }
            if (data[data.length - 1][0] != data[data.length - i - 1][i]) {
                result = false;
                break;
            }
        }
        return result;
    }
}

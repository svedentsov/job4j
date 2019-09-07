package ru.job4j.oop;

/**
 * @author Igor Svedentsov (svedensov@gmail.com)
 * @version $Id$
 * @since 0.1
 */
public class Jukebox {
    /**
     * Метод выводит в консоль слова выбранной песни.
     *
     * @param position номер песня.
     */
    public void music(int position) {
        if (position == 1) {
            System.out.println("Пусть бегут неуклюже");
        } else if (position == 2) {
            System.out.println("Спокойной ночи");
        } else {
            System.out.println("Песня не найдена");
        }
    }

    public static void main(String[] args) {
        Jukebox play = new Jukebox();
        play.music(1);
        play.music(2);
        play.music(0);
    }
}

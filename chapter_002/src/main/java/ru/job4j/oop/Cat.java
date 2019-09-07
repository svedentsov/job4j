package ru.job4j.oop;

/**
 * @author Igor Svedentsov (svedensov@gmail.com)
 * @version $Id$
 * @since 0.1
 */
public class Cat {
    private String food;
    private String name;

    /**
     * Отобразить название кличку кошки и название еды.
     */
    public void show() {
        System.out.println(this.name + " : " + this.food);
    }

    /**
     * Записать кличку кошки.
     *
     * @param nick кличка кошки.
     */
    public void giveNick(String nick) {
        this.name = nick;
    }

    /**
     * Записать название еды.
     *
     * @param meat название еда.
     */
    public void eat(String meat) {
        this.food = meat;
    }

    public static void main(String[] args) {
        System.out.println("There are gav's food.");
        Cat gav = new Cat();
        gav.giveNick("Gav");
        gav.eat("kotleta");
        gav.show();
        System.out.println("There are black's food.");
        Cat black = new Cat();
        black.giveNick("Black");
        black.eat("fish");
        black.show();
    }
}

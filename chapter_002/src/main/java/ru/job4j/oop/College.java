package ru.job4j.oop;

/**
 * @author Igor Svedentsov (svedensov@gmail.com)
 * @version $Id$
 * @since 0.1
 */
public class College {
    public static void main(String[] args) {
        Freshman freshman = new Freshman();
        // Понижающее приведение (down casting)
        Student student = freshman;
        Object object = freshman;
    }
}

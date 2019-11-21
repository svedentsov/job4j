package ru.job4j.tracker;

/**
 * Класс FindItemByName. Получение заявок найденных по имени.
 *
 * @author Igor Svedentsov (svedensov@gmail.com)
 * @version $Id$
 * @since 0.1
 */
public class FindItemByNameAction implements UserAction {
    @Override
    public String name() {
        return "=== Find items by name ===";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        System.out.print("Enter name: ");
        String name = input.askStr("");
        for (Item item : tracker.findByName(name)) {
            System.out.println("Name: " + item.getName() + " id: " + item.getId());
        }
        return true;
    }
}

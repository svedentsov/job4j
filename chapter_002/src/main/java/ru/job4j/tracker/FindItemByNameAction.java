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
        String name = input.askStr("Enter name: ");
        for (Item item : tracker.findByName(name)) {
            System.out.println("Name: " + item.getName() + " id: " + item.getId());
        }
        return true;
    }
}

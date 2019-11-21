package ru.job4j.tracker;

/**
 * Класс ShowAllItems. Получение списка всех заявок.
 *
 * @author Igor Svedentsov (svedensov@gmail.com)
 * @version $Id$
 * @since 0.1
 */
public class ShowAllItemsAction implements UserAction {
    @Override
    public String name() {
        return "=== Show all items ===";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        for (Item item : tracker.findAll()) {
            System.out.println("Name: " + item.getName() + " id: " + item.getId());
        }
        return true;
    }
}

package ru.job4j.tracker;

/**
 * Класс FindItemById. Получение заявок найденных по id.
 *
 * @author Igor Svedentsov (svedensov@gmail.com)
 * @version $Id$
 * @since 0.1
 */
public class FindItemByIdAction implements UserAction {
    @Override
    public String name() {
        return "=== Find item by Id ===";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        System.out.print("Enter id: ");
        String id = input.askStr("");
        Item item = tracker.findById(id);
        if (item != null) {
            System.out.println("Search results");
            System.out.println("Name: " + item.getName() + " id: " + item.getId());
        } else {
            System.out.println("Item not found.");
        }
        return true;
    }
}

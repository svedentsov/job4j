package ru.job4j.tracker;

/**
 * Класс DeleteItem. Удаление заявки.
 *
 * @author Igor Svedentsov (svedensov@gmail.com)
 * @version $Id$
 * @since 0.1
 */
public class DeleteItemAction implements UserAction {
    @Override
    public String name() {
        return "=== Delete item ===";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        String name = input.askStr("Enter item name: ");
        if (tracker.delete(name)) {
            System.out.println("Item has been deleted.");
        } else {
            System.out.println("Item not found.");
        }
        return true;
    }
}

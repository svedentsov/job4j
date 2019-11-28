package ru.job4j.tracker;

/**
 * Класс ReplaceItem. Редактирование заявки.
 *
 * @author Igor Svedentsov (svedensov@gmail.com)
 * @version $Id$
 * @since 0.1
 */
public class ReplaceItemAction implements UserAction {
    @Override
    public String name() {
        return "=== Edit item ===";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        String id = input.askStr("Enter id: ");
        String name = input.askStr("Enter new name: ");
        Item next = new Item(name);
        next.setId(id);
        if (tracker.replace(next.getId(), next)) {
            System.out.println("Item has been changed.");
        } else {
            System.out.println("Item not found.");
        }
        return true;
    }
}

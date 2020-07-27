package ru.job4j.tracker;

/**
 * Класс DeleteItem. Удаление заявки.
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

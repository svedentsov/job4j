package ru.job4j.tracker;


/**
 * Класс StartUI является консольным приложение для работы с классом Tracker.
 *
 * @author Igor Svedentsov (svedensov@gmail.com)
 * @version $Id$
 * @since 0.1
 */
public class StartUI {

    public void init(Input input, Tracker tracker) {
        boolean run = true;
        while (run) {
            this.showMenu();
            System.out.print("Select: ");
            int select = Integer.valueOf(input.askStr(""));
            if (select == 0) {
                System.out.println("=== Create a new Item ====");
                System.out.print("Enter name: ");
                String name = input.askStr("");
                Item item = new Item(name);
                tracker.add(item);
            } else if (select == 1) {
                System.out.println("=== Show all items ===");
                for (Item item : tracker.findAll()) {
                    System.out.println("Name: " + item.getName() + " id: " + item.getId());
                }
            } else if (select == 2) {
                System.out.println("=== Edit item ===");
                System.out.print("Enter id: ");
                String id = input.askStr("");
                System.out.print("Enter new name: ");
                String name = input.askStr("");
                Item next = new Item(name);
                next.setId(id);
                if (tracker.replace(next.getId(), next)) {
                    System.out.println("Item has been changed.");
                } else {
                    System.out.println("Item not found.");
                }
            } else if (select == 3) {
                System.out.println("=== Delete item ===");
                System.out.print("Enter item name: ");
                String name = input.askStr("");
                if (tracker.delete(name)) {
                    System.out.println("Item has been deleted.");
                } else {
                    System.out.println("Item not found.");
                }
            } else if (select == 4) {
                System.out.println("=== Find item by Id ===");
                System.out.print("Enter id: ");
                String id = input.askStr("");
                Item item = tracker.findById(id);
                if (item != null) {
                    System.out.println("Search results");
                    System.out.println("Name: " + item.getName() + " id: " + item.getId());
                } else {
                    System.out.println("Item not found.");
                }
            } else if (select == 5) {
                System.out.println("=== Find items by name ===");
                System.out.print("Enter name: ");
                String name = input.askStr("");
                for (Item item : tracker.findByName(name)) {
                    System.out.println("Name: " + item.getName() + " id: " + item.getId());
                }
            } else if (select == 6) {
                run = false;
                System.out.println("=== Exit Program ===");
            }
        }
    }

    private void showMenu() {
        System.out.println("=== Menu ===");
        System.out.println("0. Add new Item");
        System.out.println("1. Show all items");
        System.out.println("2. Edit item");
        System.out.println("3. Delete item");
        System.out.println("4. Find item by Id");
        System.out.println("5. Find items by name");
        System.out.println("6. Exit Program");
    }

    public static void main(String[] args) {
        Input input = new ConsoleInput();
        Tracker tracker = new Tracker();
        new StartUI().init(input, tracker);
    }
}

package ru.job4j.tracker;

/**
 * Класс StartUI является консольным приложением для работы с классом Tracker.
 *
 * @author Igor Svedentsov (svedensov@gmail.com)
 * @version $Id$
 * @since 0.1
 */
public class StartUI {
    /**
     * Добавление заявки.
     *
     * @param input   заявка.
     * @param tracker массив заявок.
     */
    public static void createItem(Input input, Tracker tracker) {
        System.out.println("=== Create a new Item ====");
        System.out.print("Enter name: ");
        String name = input.askStr("");
        Item item = new Item(name);
        tracker.add(item);
    }

    /**
     * Получение списка всех заявок.
     *
     * @param tracker массив заявок.
     */
    public static void showAllItems(Tracker tracker) {
        System.out.println("=== Show all items ===");
        for (Item item : tracker.findAll()) {
            System.out.println("Name: " + item.getName() + " id: " + item.getId());
        }
    }

    /**
     * Редактирование заявки.
     *
     * @param input   заявка.
     * @param tracker массив заявок.
     */
    public static void replaceItem(Input input, Tracker tracker) {
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
    }

    /**
     * Удаление заявки.
     *
     * @param input   название заявки.
     * @param tracker массив заявок.
     */
    public static void deleteItem(Input input, Tracker tracker) {
        System.out.println("=== Delete item ===");
        System.out.print("Enter item name: ");
        String name = input.askStr("");
        if (tracker.delete(name)) {
            System.out.println("Item has been deleted.");
        } else {
            System.out.println("Item not found.");
        }
    }

    /**
     * Получение заявок найденных по id.
     *
     * @param input   id заявки.
     * @param tracker массик заявок.
     */
    public static void findItemById(Input input, Tracker tracker) {
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
    }

    /**
     * Получение заявок найденных по имени.
     *
     * @param input   имя заявки.
     * @param tracker массив заявок.
     */
    public static void findItemByName(Input input, Tracker tracker) {
        System.out.println("=== Find items by name ===");
        System.out.print("Enter name: ");
        String name = input.askStr("");
        for (Item item : tracker.findByName(name)) {
            System.out.println("Name: " + item.getName() + " id: " + item.getId());
        }
    }

    public void init(Input input, Tracker tracker) {
        boolean run = true;
        while (run) {
            this.showMenu();
            System.out.print("Select: ");
            int select = Integer.valueOf(input.askStr(""));
            if (select == 0) {
                StartUI.createItem(input, tracker);
            } else if (select == 1) {
                StartUI.showAllItems(tracker);
            } else if (select == 2) {
                StartUI.replaceItem(input, tracker);
            } else if (select == 3) {
                StartUI.deleteItem(input, tracker);
            } else if (select == 4) {
                StartUI.findItemById(input, tracker);
            } else if (select == 5) {
                StartUI.findItemByName(input, tracker);
            } else if (select == 6) {
                run = false;
                System.out.println("=== Exit Program ===");
            }
        }
    }

    public void init(Input input, Tracker tracker, UserAction[] actions) {
        boolean run = true;
        while (run) {
            this.showMenu(actions);
            int select = input.askInt("Select: ");
            UserAction action = actions[select];
            run = action.execute(input, tracker);
        }
    }

    /**
     * Меню отображаемое пользователю.
     */
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

    private void showMenu(UserAction[] actions) {
        System.out.println("Menu.");
        for (int index = 0; index < actions.length; index++) {
            System.out.println(index + ". " + actions[index].name());
        }
    }

    /**
     * Запуск программы.
     *
     * @param args
     */
    public static void main(String[] args) {
        Input input = new ConsoleInput();
        Tracker tracker = new Tracker();
        UserAction[] actions = {
                new CreateAction(),
                new ShowAllItemsAction(),
                new ReplaceItemAction(),
                new DeleteItemAction(),
                new FindItemByIdAction(),
                new FindItemByNameAction(),
                new ExitAction()
        };
        new StartUI().init(input, tracker, actions);
    }
}

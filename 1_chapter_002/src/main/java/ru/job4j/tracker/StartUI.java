package ru.job4j.tracker;

import java.util.ArrayList;
import java.util.List;

/**
 * Пользовательский интерфейс.
 */
public class StartUI {
    /**
     * Основной цикл программы.
     */
    public void init(Input input, Tracker tracker, List<UserAction> actions) {
        boolean run = true;
        while (run) {
            this.showMenu(actions);
            int select = input.askInt("Select: ", actions.size());
            UserAction action = actions.get(select);
            run = action.execute(input, tracker);
        }
    }

    /**
     * Меню.
     */
    private void showMenu(List<UserAction> actions) {
        System.out.println("Menu.");
        for (UserAction action : actions) {
            System.out.println(actions.indexOf(action) + ". " + action.name());
        }
    }

    /**
     * Запуск программы.
     *
     * @param args входные параметры
     */
    public static void main(String[] args) {
        Input input = new ConsoleInput();
        Input validate = new ValidateInput(input);
        Tracker tracker = new Tracker();
        List<UserAction> actions = new ArrayList<>();
        actions.add(new CreateAction());
        actions.add(new FindAllAction());
        actions.add(new ReplaceItemAction());
        actions.add(new DeleteItemAction());
        actions.add(new FindByIDAction());
        actions.add(new FindByNameAction());
        actions.add(new ExitAction());
        new StartUI().init(validate, tracker, actions);
    }
}

package ru.job4j.bank;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Класс BankService.
 * Выполняет различные операции со счетами пользователей.
 */
public class BankService {
    /**
     * Пользователи системы со счетами.
     */
    private Map<User, List<Account>> users = new HashMap<>();

    /**
     * Добавление пользователя, если его нет базе.
     *
     * @param user пользователь
     */
    public void addUser(User user) {
        users.putIfAbsent(user, new ArrayList<>());
    }

    /**
     * Поиск пользователя по номеру паспорта.
     *
     * @param passport номер паспорта
     * @return найденный пользователь
     */
    public User findByPassport(String passport) {
        return users.keySet().stream()
                .filter(o -> o.getPassport().equals(passport))
                .findFirst()
                .orElse(null);
    }

    /**
     * Добавление счёта к пользователю.
     *
     * @param passport номер паспорта
     * @param account  банковский счёт
     */
    public void addAccount(String passport, Account account) {
        User user = findByPassport(passport);
        if (user != null && !users.get(user).contains(account)) {
            users.get(user).add(account);
        }
    }

    /**
     * Поиск счёта пользователя по реквизитам.
     *
     * @param passport  номер паспорта
     * @param requisite реквизиты
     * @return найденный счёт
     */
    public Account findByRequisite(String passport, String requisite) {
        User user = findByPassport(passport);
        Account account = null;
        if (user != null) {
            account = users.get(user).stream()
                    .filter(o -> o.getRequisite().equals(requisite))
                    .findFirst()
                    .orElse(null);
        }
        return account;
    }

    /**
     * Перевод между счетами.
     *
     * @param srcPassport   номер паспорта счёта списания
     * @param srcRequisite  реквизиты счёта списания
     * @param destPassport  номер паспорта счёта зачисления
     * @param destRequisite реквизиты счёта зачисления
     * @param amount        сумма перевода
     * @return результат перевода
     */
    public boolean transferMoney(String srcPassport,
                                 String srcRequisite,
                                 String destPassport,
                                 String destRequisite,
                                 double amount) {
        boolean result = false;
        Account srcAccount = findByRequisite(srcPassport, srcRequisite);
        Account destAccount = findByRequisite(destPassport, destRequisite);
        if (srcAccount != null && destAccount != null && srcAccount.getBalance() >= amount) {
            srcAccount.setBalance(srcAccount.getBalance() - amount);
            destAccount.setBalance(destAccount.getBalance() + amount);
            result = true;
        }
        return result;
    }
}
